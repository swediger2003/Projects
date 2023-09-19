package src.model;


/**
 * Interface for all the classes that perform a command on a 2D array of pixels.
 */
public interface ImageFunction {

  /**
   * Method that applies said command to the model.
   *
   * @param m the model that hold the image in which the command acts upon.
   */
  void execute(ImageModelState m);
}


