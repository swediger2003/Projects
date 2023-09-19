package src.model;

/**
 * Command Class which represents the action of changing the colors of an image
 * using a Sepia filter.
 */
public class Sepia extends AFunction {

  /**
   * Constructs a command class argument for the image processing program.
   *
   * @param imageName the source image name the desired command is to be implemented on.
   * @param imageDest the destination name in which the image name is to be saved under after the
   *                  command has been implemented.
   */
  public Sepia(String imageName, String imageDest) {
    super(imageName, imageDest);
  }

  /**
   * Applies the sepia Kernel matrix to each one of the pixels in the 2D Pixel array, and
   * saves the changes of each pixel to the imageCopy array. The calculations of the sepia are
   * found by finding the dot product between the sepia matrix and the surrounding pixels.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return The imageCopy array with the individual pixel changed.
   */
  @Override
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    Pixel pixel = image[row][col];
    int r = pixel.getRed();
    int g = pixel.getGreen();
    int b = pixel.getBlue();
    int redFinal = (int) (r * .393 + g * .769 + b * .189);
    int greenFinal = (int) (r * .349 + g * .686 + b * .168);
    int blueFinal = (int) (r * .272 + g * .534 + b * .131);


    if (redFinal > 255) {
      redFinal = 255;
    }
    if (greenFinal > 255) {
      greenFinal = 255;
    }
    if (blueFinal > 255) {
      blueFinal = 255;
    }

    imageCopy[row][col] = new Pixel(redFinal, greenFinal, blueFinal);
    return imageCopy;
  }

}
