package src.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Class which represents the model of the image processing program. This is where all relevant
 * data to the pictures and changes made to them are stored.
 */
public class ImageProcModel implements ImageModel {
  private Map<String, Pixel[][]> versions = new HashMap<>();

  /**
   * Constructs an ImageProcModel.
   */
  public ImageProcModel() {
    this.versions = versions;
  }

  /**
   * Gets a copy of the specified image from the map of images.
   *
   * @param imageName name of the image being copied.
   * @return a 2D pixel array representing the image from the map of versions.
   */
  public Pixel[][] getCopy(String imageName) {
    if (versions.get(imageName) == null) {
      throw new IllegalArgumentException("no such image");
    }
    Pixel[][] image = versions.get(imageName);
    Pixel[][] imageCopy = new Pixel[image.length][image[0].length];
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        imageCopy[row][col] = image[row][col];
      }
    }
    return imageCopy;
  }

  /**
   * Alters a copy of the image based on the given command.
   *
   * @param c command which is to be implemented on the model.
   */
  public void alter(ImageFunction c) {
    c.execute(this);
  }

  /**
   * toString method which is used to represent an entire image(by pixels) with a string.
   *
   * @param imageName name of the image being copied as a string.
   * @return string of nums representing the color values of each one of the pixels in the picture.
   */
  public String toString(String imageName) {
    StringBuilder output = new StringBuilder();
    for (int row = 0; row < this.getHeight(imageName); row++) {
      for (int col = 0; col < this.getWidth(imageName); col++) {
        Pixel pixel = this.getPixel(imageName, row, col);
        int r = pixel.getRed();
        int g = pixel.getGreen();
        int b = pixel.getBlue();
        output.append(r + " " + g + " " + b + " ");
      }
    }
    return output.toString();
  }


  /**
   * Adds a given 2D array of pixels to the map of versions with the imageName as its key.
   *
   * @param image     2D array of pixels representing an image.
   * @param imageName Name which the version is to be saved under
   */
  public void addToVersions(Pixel[][] image, String imageName) {
    versions.put(imageName, image);
  }

  /**
   * Returns a copy of the pixel at the specified position, from the specified image in the map of
   * versions.
   *
   * @param imageName Name of the image being referenced.
   * @param row       the row of the position sought, starting at 0.
   * @param col       the column of the position sought, starting at 0.
   * @return the specific pixel in the referenced image.
   */
  @Override
  public Pixel getPixel(String imageName, int row, int col) {
    Pixel[][] image = versions.get(imageName);
    return image[row][col];
  }

  /**
   * Gets the width(left to right) measurement of the 2D Pixel array.
   *
   * @param imageName Name of the image being referenced.
   * @return the length of the columns in the 2D Pixel array.
   */
  @Override
  public int getWidth(String imageName) {
    Pixel[][] image = versions.get(imageName);
    return image.length;
  }

  /**
   * Gets the height(top to bottom ) measurement of the 2D Pixel array.
   *
   * @param imageName Name of the image being referenced.
   * @return the length of the rows in the 2D Pixel array.
   */
  @Override
  public int getHeight(String imageName) {
    Pixel[][] image = versions.get(imageName);
    return image[0].length;
  }

  /**
   * gets a copy of the designated ppm stored in the model.
   *
   * @param func a function that takes in a pixel and gets the integer value of one of its color
   *             components.
   * @return a copy of the desired image in the form of a 2-D Color array.
   */
  public int[] getHistogramMap(String imageName, Function<Pixel, Integer> func) {
    Pixel[][] image = versions.get(imageName);

    // DESIGN CHOICE: each key in the map represents the "brightness" value of one of the pixels
    // colors
    int[] histo = new int[256];

    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        int pixelNum = func.apply(image[row][col]);
        histo[pixelNum] = histo[pixelNum] + 1;

      }
    }

    return histo;
  }

  /**
   * returns the avg histogram array.
   * @param imageName the name of the image being worked on.
   *
   * @return the average histogram array.
   */
  public int[] getAvgHistogramMap(String imageName) {
    Pixel[][] image = versions.get(imageName);

    int[] histo = new int[256];
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        Pixel pixel = image[row][col];
        int pixelNum = (pixel.getGreen() + pixel.getRed() + pixel.getBlue()) / 3;
        histo[pixelNum] = histo[pixelNum] + 1;
      }
    }

    return histo;
  }

  /**
   * gets a buffered image.
   * @param imageName Name of the image that is being accessed
   * @return a buffered image.
   */
  public BufferedImage getBufferedImage(String imageName) {
    Pixel[][] image = getCopy(imageName);
    int type = BufferedImage.TYPE_INT_ARGB;
    BufferedImage newImage = new BufferedImage(image[0].length, image.length, type);
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        Pixel pixel = image[row][col];
        newImage.setRGB(col, row,
                new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue()).getRGB());
      }
    }
    return newImage;
  }

}
