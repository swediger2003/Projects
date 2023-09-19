/*package src.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class AHistogram implements ImageFunction{

  protected String imageName;
  protected String imageDest;

  @Override
  public void execute(ImageModelState m) {
    Pixel[][] image = m.getCopy(imageName);
    Map<Integer, Integer> histoMap = new HashMap<>();
    int height = image.length;
    int width = image[0].length;
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        int pixelNum = histogramOp(image[row][col]);
       // int pixelNum = func.apply(image[row][col]);
        histoMap.put(pixelNum, histoMap.get(pixelNum) + 1);
      }
    }
  }

  public abstract int histogramOp(Pixel p);

  /**
   * gets a copy of the designated ppm stored in the model.
   *
   * @param func a function that takes in a pixel and gets the integer value of one of its color
   *             components.
   * @return a copy of the desired image in the form of a 2-D Color array.
   */
  /*public Map<Integer, Integer> getHistogramMap(String imageName, Function<Pixel, Integer> func) {
    Pixel[][] image = versions.get(imageName);

    // DESIGN CHOICE: each key in the map represents the "brightness" value of one of the pixels
    // colors
    Map<Integer, Integer> histoMap = new HashMap<>();
    for (int row = 0; row < image.length; row ++) {
      for (int col = 0; col < image[0].length; col ++) {
        int pixelNum = func.apply(image[row][col]);
        histoMap.put(pixelNum, histoMap.get(pixelNum) + 1);
      }
    }

    return histoMap;
  }
}
*/