package src;

import src.controller.ControllerImpl;
import src.controller.IController;
import src.model.ImageModel;
import src.model.ImageProcModel;

/**
 * main class for this program that holds the main method.
 */
public class ImageProcessing {

  /**
   * main method used to start and run the program.
   * @param args the argumetns used to start the program.
   */
  public static void main(String[] args) {

    ImageModel m = new ImageProcModel();
    IController controller = new ControllerImpl(m);
    controller.playGame();
  }
}
