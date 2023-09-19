package src.view;

import src.controller.Features;


import java.awt.image.BufferedImage;


/**
 * Interface which displays the the functionality that is promised to the user of the program.
 */
public interface IView {
  void updateHistogram( int[] r, int[] g, int[] b, int[] avg);



  /**
   * Updates the current image on the screen with the given Image.
   */
  void updateImage(BufferedImage image);


  /**
   * Adds features to the view, ie functionallity for a button, linking the current view to any
   * controller that implements the features interface.
   * @param features Controller that implements the features interface and provides functionality
   *                 to the view's various buttons and actionable items.
   */
  void addFeatures(Features features);

  /**
   * Opens the command pop-up window when the user clicks the choose a command button.
   */
  void openCommandPopup();

  /**
   * Method to return the name of the current image being worked on.
   * @return the name of the current image being worked on.
   */
  String getCurrentName();

  /**
   * Sets the current image name, allowing the user or controller to change the name they
   * are working on.
   * @param a Name that the newe image will be called by.
   */
  void setImageName(String a);
}
