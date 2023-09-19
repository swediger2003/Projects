package src.model;

import java.io.IOException;

/**
 * test class that acts as a mock command class.
 */
public class TestComp implements ImageFunction {
  Appendable log = new StringBuffer();
  String name;
  String dest;

  /**
   * construcotr for the class.
   * @param name image name.
   * @param dest destination name.
   * @throws IOException when inputs invalid.
   */
  public TestComp(String name, String dest) throws IOException {
    this.name = name;
    this.dest = dest;
    log.append(name + " ");
    log.append(dest + " ");
  }

  public String toString() {
    return this.log.toString();
  }

  /**
   * mock holder method.
   * @param m the model that hold the image in which the command acts upon.
   */
  @Override
  public void execute(ImageModelState m) {
    //Execute method
  }

  /**
   * returns useless info.
   * @param image image.
   * @param imageCopy copy.
   * @param height height.
   * @param width width.
   * @param row row.
   * @param col col.
   * @return nothing useful.
   */
  public Pixel[][] doSpecificOperation(Pixel[][] image, Pixel[][] imageCopy,
                                       int height, int width, int row, int col) {
    return new Pixel[0][];
  }
}
