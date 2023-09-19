package src.controller;

import src.model.ImageModel;

import src.model.Pixel;
import src.view.IView;
import java.io.StringReader;
import java.util.Objects;


/**
 * NEw Controller for the image Processing application that handles a gui view and
 * delegates/translates
 * the functionality to the old controller.
 * function
 */
public class Controller implements Features {
  private ImageModel model;
  private IView view;

  private IController oldController;


  public Controller(ImageModel m) {
    model = m;
    oldController = new ControllerImpl();
  }

  /**
   * Sets the current view with features from this controller.
   *
   * @param v Blank View Object that is to be changed by adding features to it.
   */
  public void setView(IView v) {
    view = v;
    //provide view with all the callbacks
    view.addFeatures(this);
  }

  /**
   * Tells the view to open up the command popup, preserving MVC Roles.
   */
  public void commandSelect() {
    view.openCommandPopup();
  }


  /**
   * Tells the view to do the given action it sent to the controller.
   *
   * @param s name of the command that was sent to the controller from the view.
   */
  @Override
  public void doAction(String s) {
    String imageName = "";
    String cmd = s.split(" ")[0];
    switch (cmd) {
      case "save":
        imageName = Objects.requireNonNull(view.getCurrentName());
        break;
      case "load":
        imageName = "test";
        break;
      default:
        imageName = "test" + "-" + cmd;
        // imageName = new StringBuilder("test").append("-%s", cmd);
    }

    StringReader reader = new StringReader(s + " " + imageName);
    oldController = new ControllerImpl(reader, model);
    oldController.playGame();
    view.setImageName(imageName);
    imageName = Objects.requireNonNull(view.getCurrentName());
    view.updateImage(model.getBufferedImage(imageName));
    this.updateHistoValues();
  }

  /**
   * Exit protocol when the view gives a system feedback of 0.
   */
  @Override
  public void exitProgram() {
    System.exit(0);
  }

  /**
   * updtaes the values of histgram.
   */
  public void updateHistoValues() {
    int[] rArray = model.getHistogramMap(view.getCurrentName(), Pixel::getRed);
    int[] gArray = model.getHistogramMap(view.getCurrentName(), Pixel::getGreen);
    int[] bArray = model.getHistogramMap(view.getCurrentName(), Pixel::getBlue);
    int[] avgArray = model.getAvgHistogramMap(view.getCurrentName());
    view.updateHistogram(rArray, gArray, bArray, avgArray);

  }


}
