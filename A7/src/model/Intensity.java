package src.model;


/**
 * Command Class which represents the act of changing each pixels color values(rgb) to the
 * average value of all of them.
 */
public class Intensity extends AFunction implements ImageFunction {

  /**
   * Constructs a Intensity command class object.
   *
   * @param imageName name of the image the command is acting upon.
   * @param imageDest name that the modified image will be saved under.
   */
  public Intensity(String imageName, String imageDest) {
    super(imageName, imageDest);
  }


  /**
   * Command which changes a pixels RGB values to the average of all of them.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return          a copy of the pixel from the imageCopy, with the Intensity command implemented
   *                  on it.
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    Pixel pixel = image[row][col];
    int r = pixel.getRed();
    int g = pixel.getGreen();
    int b = pixel.getBlue();
    int average = (r + g + b) / 3;
    imageCopy[row][col] = new Pixel(average, average, average);
    return imageCopy;
  }
}
