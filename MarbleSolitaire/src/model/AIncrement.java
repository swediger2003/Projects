package src.model;

/**
 * an abstract class used to extract reused code that adds increments to a pixel value, used in
 * brighten and darken.
 */
public abstract class AIncrement extends AFunction {

  /**
   * Constructs a command class with an increment argument for the image processing program.
   *
   * @param imageName the source image name the desired command is to be implemented on.
   * @param imageDest the destination name in which the image name is to be saved under after the
   *                  command has been implemented.
   */
  public AIncrement(String imageName, String imageDest) {
    super(imageName, imageDest);
  }


  /**
   * Applies the increment from either the brighten or the darken class.
   *
   * @param image     2D array of Pixels representing the image being operated on.
   * @param increment The amount the color values of the pixels are being increased/decreased
   * @param row       Value representing the Y-coordinate of where the current pixel is.
   * @param col       Value representing the X-coordinate of where the current pixel is.
   * @return          The adjusted pixel per its increment.
   */
  public Pixel applyIncrement(Pixel[][] image, int increment, int row, int col) {
    Pixel pixel = image[row][col];
    int r = pixel.getRed() + increment;
    int g = pixel.getGreen() + increment;
    int b = pixel.getBlue() + increment;
    if (r > 255) {
      r = 255;
    }
    if (g > 255) {
      g = 255;
    }
    if (b > 255) {
      b = 255;
    }
    if (r < 0) {
      r = 0;
    }
    if (g < 0) {
      g = 0;
    }
    if (b < 0) {
      b = 0;
    }
    return new Pixel(r, g, b);
  }


}


