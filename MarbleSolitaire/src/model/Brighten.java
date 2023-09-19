package src.model;


/**
 * Class which represents the command of adding an increment to each color value, in each pixel of
 * an image.
 */
public class Brighten extends AIncrement implements ImageFunction {

  int increment;

  /**
   * Constructs a Brighten command class object.
   *
   * @param imageName name of the image the command is acting upon.
   * @param imageDest name that the modified image will be saved under.
   */
  public Brighten(int increment, String imageName, String imageDest) {
    super(imageName, imageDest);
    this.increment = increment;
  }

  /**
   * Command which adds a specified increment to each color value of a pixel.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return          a copy of the pixel from the imageCopy, with the brighten command implemented
   *                on it.
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    imageCopy[row][col] = this.applyIncrement(image, this.increment, row, col);
    return imageCopy;
  }
}
