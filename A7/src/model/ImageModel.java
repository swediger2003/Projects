package src.model;

import java.awt.image.BufferedImage;

/**
 * Interface for all of the methods that affect the model and the versions stored inside the model.
 */
public interface ImageModel extends ImageModelState {

  /**
   * Runs a given command on the current model.
   *
   * @param c Function that creates a new, different copy of one of the pictures in the model.
   */
  public void alter(ImageFunction c);

  /**
   * Returns a bufferedImage of one of a given version.
   *
   * @param imageName Name of the image that is being accessed
   */
  public BufferedImage getBufferedImage(String imageName);

}











