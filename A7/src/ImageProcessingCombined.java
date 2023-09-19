package src;

import src.controller.Controller;
import src.controller.ControllerImpl;
import src.controller.IController;
import src.model.ImageModel;
import src.model.ImageProcModel;
import src.view.IView;
import src.view.JFrameView;

/**
 * Main method for program.
 */
public class ImageProcessingCombined {

  /**
   * main method used to start and run the program. allows for both a graphical view and interaction
   * with the console/terminal.
   * @param args the arguments used to start the program.
   */
  public static void main(String[] args) {

    if (args.length == 0) {
      ImageModel model = new ImageProcModel();
      Controller graphicalController = new Controller(model);
      IView view = new JFrameView();
      graphicalController.setView(view);
    }
    else {
      ImageModel m = new ImageProcModel();
      IController controller = new ControllerImpl(m);
      controller.playGame();

    }
  }
}
