package src.model;


import java.util.function.Function;

/**
 * interface for the model that outlines operations that can be performed that dont change the
 * model. this is used by the controller to regulate the game.
 */
public interface ImageModelState {

  /**
   * Gets the Color values of the individual pixels in the array of pixels using the supplied
   * numbers as a coordinate.
   *
   * @param row the row of the position sought, starting at 0.
   * @param col the column of the position sought, starting at 0.
   * @return the pixel at the specific position in the board of pixels.
   */
  public Pixel getPixel(String imageName, int row, int col);

  /**
   * Gets the width of the board at pixels, the width being the length of the row.
   *
   * @return the length of the rows in the array of Colors
   */
  public int getWidth(String imageName);

  /**
   * Gets the height of the board at pixels, the height being the length of the Columns.
   *
   * @return the length of the columns in the array of Colors
   */
  public int getHeight(String imageName);

  /**
   * gets a copy of the designated ppm stored in the model.
   *
   * @param imageName name of the image being copied.
   * @return a copy of the desired image in the form of a 2-D Color array.
   */
  public Pixel[][] getCopy(String imageName);


  /**
   * gets a copy of the designated image stored in the model.
   *
   * @param imageName the name of the image being worked on.
   * @param func      a function that takes in a pixel and gets the integer value
   *                  of one of its color
   *                  components.
   * @return          a copy of the desired image in the form of a 2-D Color array.
   */
  public int[] getHistogramMap(String imageName, Function<Pixel, Integer> func);


  /**
   * gets a copy of the avg pixel values in a histogram of the current image stored in the model.
   *
   * @param imageName the name of the image being worked on.
   *                  
   * @return          a copy of the desired image in the form of a 2-D Color array.
   */
  public int[] getAvgHistogramMap(String imageName);

  /**
   * Adds a given 2D array of pixels to the map of versions with the imageName as its key.
   *
   * @param image     2D array of pixels representing an image.
   * @param imageName Name which the version is to be saved under
   */
  public void addToVersions(Pixel[][] image, String imageName);
}
