package src.model;


/**
 * Command Class representing the act of changing every rgd value to the luma value which cna be
 * found using the following equation: 0.2126 * red + 0.7152 * green + 0.0722 * blue
 * DESIGN CHOICE: Decided to floor the luma value, truncated by int conversion.
 */
public class Luma extends AFunction implements ImageFunction {


  /**
   * Constructs a Luma command class object.
   *
   * @param imageName name of the image the command is acting upon.
   * @param imageDest name that the modified image will be saved under.
   */
  public Luma(String imageName, String imageDest) {
    super(imageName, imageDest);
  }

  /**
   * Command which changes each rgb value in a pixel to its luma value(see top of class).
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return          a copy of the pixel from the imageCopy, with the Luma command implemented on
   *                it.
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    Pixel pixel = image[row][col];
    int r = pixel.getRed();
    int g = pixel.getGreen();
    int b = pixel.getBlue();
    int lumaSum = (int) ((r * 0.2126) + (g * 0.7152) + (b * 0.0722));
    imageCopy[row][col] = new Pixel(lumaSum, lumaSum, lumaSum);
    return imageCopy;
  }
}
