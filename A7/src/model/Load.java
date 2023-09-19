package src.model;


import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;



/**
 * Command Class which represents the action of loading a ppm file from a given filepath into the
 * model.
 */
public class Load implements ImageFunction {
  private String filepath;

  private String imageName;

  private ImageUtil util;

  /**
   * Constructs a Load command class object.
   *
   * @param imageName name of the image the command is acting upon.
   * @param filepath  the file path in which the image is being accessed from.
   */
  public Load(String filepath, String imageName) {
    this.filepath = filepath;
    this.imageName = imageName;
    this.util = new ImageUtil();
  }

  /**
   * Overrides the abstract class, as this command represents the action of loading an image into
   * the model, not iterating over it.
   *
   * @param m Model in which the image is to be added to.
   */
  @Override
  public void execute(ImageModelState m) {
    if (filepath.substring(filepath.length() - 3).equals("ppm")) {
      m.addToVersions(this.util.readPPM(filepath), imageName);
    }
    else {
      try {
        BufferedImage image = ImageIO.read(new File(filepath));
        Pixel[][] newImage = this.util.convertToArray(image);
        m.addToVersions(newImage, imageName);
      } catch (Exception e) {
        throw new IllegalArgumentException("improper file inputted");
      }

    }
  }
}
