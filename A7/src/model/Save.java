package src.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * Command Class which represents the action of saving a file to a given destination filepath.
 */
public class Save implements ImageFunction {

  private String filepath;
  private String imageName;

  /**
   * Constructs a Save command class object.
   *
   * @param imageName name of the image the command is acting upon.
   * @param filepath  the file path in which the image is being saved to.
   */
  public Save(String filepath, String imageName) {
    this.filepath = filepath;
    this.imageName = imageName;
  }

  /**
   * Takes the given model and saves a version of the picture with the imageName to the filePath.
   *
   * @param m model which holds the picture that is to be saved.
   */
  @Override
  public void execute(ImageModelState m) {
    int endingIndexStart = filepath.length() - filepath.indexOf(".") - 1;
    String ending = filepath.substring(filepath.length() - endingIndexStart);
    if (ending.equals("ppm")) {
      saveAsPPM(m);
    } else {
      saveBufferedImage(m, ending);
    }
  }

  private void saveBufferedImage(ImageModelState m, String ending) {
    Pixel[][] image = m.getCopy(imageName);
    int type;
    if (ending.equals("jpeg") || ending.equals("bmp")) {
      type = BufferedImage.TYPE_INT_RGB;
    } else {
      type = BufferedImage.TYPE_INT_ARGB;
    }
    BufferedImage newImage = new BufferedImage(image[0].length, image.length, type);
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        Pixel pixel = image[row][col];
        newImage.setRGB(col, row,
                new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue()).getRGB());
      }
    }
    File outputfile = new File(filepath);
    // String ending = filepath.substring(filepath.length() - 3);
    try {
      ImageIO.write(newImage, ending, outputfile);
    } catch (IOException e) {
      throw new IllegalArgumentException("no output file found");
    }
  }

  private void saveAsPPM(ImageModelState m) {
    StringBuilder output = new StringBuilder();
    output.append("P3\n" + m.getWidth(imageName) + "\n" + m.getHeight(imageName) + "\n255\n");
    FileOutputStream outputFile;
    try {
      outputFile = new FileOutputStream(filepath);
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("not output file found");
    }

    for (int row = 0; row < m.getHeight(imageName); row++) {
      for (int col = 0; col < m.getWidth(imageName); col++) {
        Pixel pixel = m.getPixel(imageName, row, col);
        int r = pixel.getRed();
        int g = pixel.getGreen();
        int b = pixel.getBlue();
        output.append(r + " " + g + " " + b + " ");
      }
      output.append("\n");
    }
    try {
      outputFile.write(new String(output).getBytes());
      outputFile.close();
    } catch (Exception e) {
      throw new IllegalArgumentException("something doesn't work");
    }
  }
}
