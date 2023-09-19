package src.model;

/**
 * Class which represents the command of flipping an image vertically by changing the rows
 * if each pixels position.
 */
public class VerticalFlip extends AFunction implements ImageFunction {

  public VerticalFlip(String imageName, String imageDestName) {
    super(imageName, imageDestName);

  }

  /**
   * Command which changes a pixels row position, based on relative to the height of the picture.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return          a copy of the pixel from the imageCopy, with the VerticalFlip command
   *                implemented on it.
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    imageCopy[height - 1 - row][col] = image[row][col];
    return imageCopy;
  }

}
