package src.model;

/**
 * Class which represents the command of flipping an image horizontally by changing the columns
 * if each pixels position.
 */
public class HorzFlip extends AFunction implements ImageFunction {


  /**
   * Constructs a HorzFlip command class object.
   *
   * @param imageName     name of the image the command is acting upon.
   * @param imageDestName name that the modified image will be saved under.
   */
  public HorzFlip(String imageName, String imageDestName) {
    super(imageName, imageDestName);
  }

  /**
   * Command which changes a pixels column position, based on relative to the width of the picture.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return          a copy of the pixel from the imageCopy, with the HorizontalFlip command
   *                  implemented on it.
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    imageCopy[row][width - 1 - col] = image[row][col];
    return imageCopy;
  }
}
