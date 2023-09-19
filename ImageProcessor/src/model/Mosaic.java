package src.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Command class that represents the mosaic image processing function. Creates a List of random
 * positions on the image (seeds) and then goes through each pixel and checks which position
 * each pixel is closest to and changes its rgb values to be the same as the closest position.
 */
public class Mosaic extends AFunction implements ImageFunction {
  private final int seed;
  private ArrayList<Posn> positions;

  private HashMap<Posn, ArrayList<Integer>> kernels;

  private HashMap<Posn, ArrayList<ArrayList<Integer>>> kernelColor;
  private Random rand;


  /**
   * Constructs a command class argument for the image processing program.
   *
   * @param imageName the source image name the desired command is to be implemented on.
   * @param imageDest the destination name in which the image name is to be saved under after the
   *                  command has been implemented.
   */
  public Mosaic(int seed, String imageName, String imageDest, Random r) {
    super(imageName, imageDest);
    this.seed = seed;
    this.rand = r;
    this.kernels = new HashMap<>();
    this.kernelColor = new HashMap<>();
  }

  /**
   * Iterates through the image. This needed to be overriden because the List of positions needed
   * to stay consistent over the entire mosaicing process and it could not be done in the
   * constructor as there is no model passed into the constructor so that the necessary information
   * about the image (size of the array) cannot be extracted in order to run the find randomPixels
   * method.
   *
   * @param m the model that hold the image in which the command acts upon.
   */
  @Override
  public void execute(ImageModelState m) {
    Pixel[][] image = m.getCopy(imageName);
    this.positions = new MosaicUtils().findRandomPixels(image, this.seed, this.rand);
    int height = image.length;
    int width = image[0].length;
    this.assignKernels(image, height, width);

    Pixel[][] imageCopy = new Pixel[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        imageCopy = doSpecificOperation(image, imageCopy, height, width, row, col);

      }
    }
    m.addToVersions(imageCopy, imageDest);
  }


  /**
   * Does the specific operation that each pixel. Changes rgb values to closest seed.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return the imageCopy
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy, int height, int width,
                                       int row, int col) {
    ArrayList<Integer> color = this.kernels.get(this.isClosestTo(row, col));
    int red = color.get(0);
    int green = color.get(1);
    int blue = color.get(2);

    imageCopy[row][col] = new Pixel(red, green, blue);
    return imageCopy;
  }

  /**
   * Assigns each Pixel Color to a certain kernel.
   *
   * @param image  the 2d array of pixels
   * @param height the height of teh image
   * @param width  the width of the image
   */
  private void assignKernels(Pixel[][] image, int height, int width) {
    for (Posn p : positions) {
      ArrayList<ArrayList<Integer>> colors = new ArrayList<>();
      kernelColor.put(p, colors);
    }

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        Posn closest = this.isClosestTo(row, col);
        Pixel p = image[row][col];
        ArrayList<Integer> colorPix = new ArrayList<>();
        colorPix.add(p.getRed());
        colorPix.add(p.getGreen());
        colorPix.add(p.getBlue());
        this.kernelColor.get(closest).add(colorPix);

      }
    }

    this.createKernelColor();
  }


  /**
   * Creates an overall list of average colors for all the kernels.
   */
  private void createKernelColor() {
    for (Posn p : positions) {
      ArrayList<Integer> color = this.kernelColorHelper(this.kernelColor.get(p));
      kernels.put(p, color);
    }
  }


  /**
   * Creates an average color for each Kernel.
   *
   * @param kernel the list of Pixel colors in each kernel
   * @return A list of the average r, g, b values
   */
  private ArrayList<Integer> kernelColorHelper(ArrayList<ArrayList<Integer>> kernel) {
    int counter = 0;
    int red = 0;
    int green = 0;
    int blue = 0;

    for (int s = 0; s < kernel.size(); s++) {
      ArrayList<Integer> c = kernel.get(s);
      red += c.get(0);
      green += c.get(1);
      blue += c.get(2);
      counter++;
    }
    red = red / counter;
    green = green / counter;
    blue = blue / counter;

    ArrayList<Integer> color = new ArrayList<>();
    color.add(red);
    color.add(green);
    color.add(blue);

    return color;
  }


  /**
   * Finds what position is closest to the given row, column.
   *
   * @param row Row of current position.
   * @param col Column of current position.
   * @return Returns the closest position to the current position.
   */
  private Posn isClosestTo(int row, int col) {
    Posn currPixel = new Posn(row, col);
    double distance = currPixel.dist(positions.get(0));
    Posn closestPosn = positions.get(0);

    for (int i = 1; i < positions.size(); i++) {
      if (currPixel.dist(positions.get(i)) < distance) {
        closestPosn = positions.get(i);
        distance = currPixel.dist(positions.get(i));
      }
    }
    return closestPosn;
  }
}
