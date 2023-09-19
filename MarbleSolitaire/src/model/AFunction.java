package src.model;

import java.util.Objects;

/**
 * Abstract class for imageFunction, abstracts out common fields as well as functionality
 * through its execute method.
 */
public abstract class AFunction implements ImageFunction {
  protected String imageName;
  protected String imageDest;

  /**
   * Constructs a command class argument for the image processing program.
   *
   * @param imageName the source image name the desired command is to be implemented on.
   * @param imageDest the destination name in which the image name is to be saved under after the
   *                  command has been implemented.
   */
  public AFunction(String imageName, String imageDest) {
    this.imageName = Objects.requireNonNull(imageName);
    this.imageDest = Objects.requireNonNull(imageDest);
  }


  /**
   * Abstract method that takes out the common code usage of iterating through the images pixels.
   *
   * @param m model where all of teh parameters and data are taken from.
   */
  @Override
  public void execute(ImageModelState m) {
    Pixel[][] image = m.getCopy(imageName);
    int height = image.length;
    int width = image[0].length;
    Pixel[][] imageCopy = new Pixel[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        imageCopy = doSpecificOperation(image, imageCopy, height, width, row, col);
      }
    }
    m.addToVersions(imageCopy, imageDest);
  }

  /**
   * Abstract method for the uncommon functionality between classes that extend AFunction.
   *
   * @param image     2D Pixel array which is used as the image to be returned.
   * @param imageCopy 2D pixel array representing the source picture being implemented on.
   * @param height    value representing how many pixels are in a row.
   * @param width     value representing how many pixels are in a column.
   * @param row       index representing the row where the pixel being implemented on lies.
   * @param col       index representing the column where the pixel being implemented on lies.
   * @return          a copy of the board with the command ran on a specific pixel.
   */
  public abstract Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                                int height, int width, int row, int col);


}




