package src.model;

/**
 * Class which represents a single pixel from a ppm image.
 */
public class Pixel {
  private int red;
  private int green;
  private int blue;

  /**
   * Constructs a pixel object. Throws an IllegalArgumentException if the color value is under 0 or
   * over 255.
   *
   * @param red   represents the integer value of a red pixel.
   * @param green represents the integer value of a green pixel.
   * @param blue  represents the integer value of a blue pixel.
   */
  public Pixel(int red, int green, int blue) {
    if (red < 0 || green < 0 || blue < 0 || red > 255 || green > 255 || blue > 255) {
      throw new IllegalArgumentException("Cannot have an invalid int below 0 or above" +
              " 255 for the color value");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * gets the red value from a pixel.
   *
   * @return the red value from a pixel.
   */
  public int getRed() {
    return red;
  }

  /**
   * gets the green value from a pixel.
   *
   * @return the green value from a pixel.
   */
  public int getGreen() {
    return green;
  }

  /**
   * gets the blue value from a pixel.
   *
   * @return the blue value from a pixel.
   */
  public int getBlue() {
    return blue;
  }

  /**
   * Represents a single pixel as a string by displaying each rgb value.
   *
   * @return each rgb value separated by a space.
   */
  @Override
  public String toString() {
    return String.format("%s %s %s", red, green, blue);
  }

  /**
   * Checks if two pixels are the same by comparing the return of their toString().
   *
   * @param other the pixel object being compared.
   * @return Whether the objects rgb values are equal or not.
   */
  @Override
  public boolean equals(Object other) {
    return this.toString().equals(other.toString());
  }

  /**
   * Generates a unique number for each color.
   *
   * @return a code representing the color values as a whole.
   */
  @Override
  public int hashCode() {
    return this.red + this.green + this.blue;
  }

}
