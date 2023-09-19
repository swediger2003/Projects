package src.model;


/**
 * Command class that takes a pixel and changes the color values based on the maximum rgb value of
 * the three and sets the two smaller color values to the max color value.
 */
public class ValueComponent extends AFunction implements ImageFunction {

  /**
   * Constructs a command class argument for the image processing program.
   *
   * @param imageName the source image name the desired command is to be implemented on.
   * @param imageDest the destination name in which the image name is to be saved under after the
   *                  command has been implemented.
   */
  public ValueComponent(String imageName, String imageDest) {
    super(imageName, imageDest);
  }


  /**
   * Command which takes the maxium color value of an image and makes a greyscale image of that
   * color.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return          a copy of the pixel from the imageCopy, with the ValueComponent command
   *                implemented on it.
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    Pixel pixel = image[row][col];
    int r = pixel.getRed();
    int g = pixel.getGreen();
    int b = pixel.getBlue();
    int smallerMax = Math.max(r, g);
    int maxValue = Math.max(smallerMax, b);
    imageCopy[row][col] = new Pixel(maxValue, maxValue, maxValue);
    return imageCopy;
  }
}
