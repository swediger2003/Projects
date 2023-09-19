package src.model;


/**
 * Class that represents the act of changing an images pixels to a grayscale version, with its
 * red pixel value as all of the color values.
 */
public class RedGreyscale extends AFunction implements ImageFunction {


  /**
   * Constructs a RedGreyscale command class object.
   * @param imageName name of the image the command is acting upon.
   * @param imageDest name that the modified image will be saved under.
   */
  public RedGreyscale(String imageName, String imageDest) {
    super(imageName, imageDest);
  }

  /**
   * Command which turns each pixel in an images green and blue values to its red value to create
   * a grayscale image.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return          a copy of the pixel from the imageCopy, with the RedGreyscale command
   *                    implemented on it.
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    Pixel pixel = image[row][col];
    int r = pixel.getRed();
    imageCopy[row][col] = new Pixel(r,r,r);
    return imageCopy;
  }




}

