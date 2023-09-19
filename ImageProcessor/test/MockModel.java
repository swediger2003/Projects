import src.model.ImageFunction;
import src.model.ImageModel;
import src.model.Pixel;

import java.awt.image.BufferedImage;
import java.util.function.Function;

/**
 * mock model.
 */
public class MockModel implements ImageModel {
  @Override
  public void alter(ImageFunction c) {
    //alters imageFunction.
  }

  @Override
  public BufferedImage getBufferedImage(String imageName) {
    return null;
  }

  @Override
  public Pixel getPixel(String imageName, int row, int col) {
    return null;
  }

  @Override
  public int getWidth(String imageName) {
    return 0;
  }

  @Override
  public int getHeight(String imageName) {
    return 0;
  }

  @Override
  public Pixel[][] getCopy(String imageName) {
    return new Pixel[0][];
  }

  @Override
  public int[] getHistogramMap(String imageName, Function<Pixel, Integer> func) {
    return null;
  }

  @Override
  public int[] getAvgHistogramMap(String imageName) {
    return null;
  }

  @Override
  public void addToVersions(Pixel[][] image, String imageName) {
  // addversions.
  }
}
