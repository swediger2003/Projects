package src.model;

/**
 * command class in charge of greyscaling the image. extends AFunction.
 */
public class GreyScale extends AFunction implements ImageFunction {

  /**
   * Constructs a command class argument for the image processing program.
   *
   * @param imageName the source image name the desired command is to be implemented on.
   * @param imageDest the destination name in which the image name is to be saved under after the
   *                  command has been implemented.
   */
  public GreyScale(String imageName, String imageDest) {
    super(imageName, imageDest);
  }


  /**
   * Applies the greyscale Kernel matrix to each one of the pixels in the 2D Pixel array, and
   * saves the changes of each pixel to the imageCopy array. The calculations of the greyscale are
   * found by finding the dot product between the greyscale matrix and the surrounding pixels.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return          The imageCopy array with the individual pixel changed.
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    Pixel p = image[row][col];
    int i = (int) (.2126 * p.getRed() + .7152 * p.getGreen() + .0722 * p.getBlue());
    imageCopy[row][col] = new Pixel(i, i, i);
    return imageCopy;
  }
}
