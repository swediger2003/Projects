package src.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Utils class for the mosaic image processing ooperation.
 */
public class MosaicUtils {

  /**
   * Fund a list of random Posns on an 2d array of Pixels.
   *
   * @param pixels The array of pixels that we are finding the random positions on.
   * @param seed   The number of positions we find.
   * @param r      The random object used
   * @return List of random posisions on the 2d array of pixels.
   */
  public static ArrayList<Posn> findRandomPixels(Pixel[][] pixels, int seed, Random r) {

    Objects.nonNull(pixels);

    if (seed > pixels.length * pixels[0].length) {
      throw new IllegalArgumentException("seed is greater than number of pixels");
    }

    if (seed <= 0) {
      throw new IllegalArgumentException("Seed must be greater than 0");
    }

    ArrayList<Posn> seeds = new ArrayList<Posn>();
    boolean exists;
    seeds.add(new Posn((int) (Math.random() * (pixels.length)),
            (int) (Math.random() * (pixels[0].length))));
    int counter = 1;

    while (counter < seed) {
      exists = false;

      int randRow = r.nextInt(pixels.length);
      int randCol = r.nextInt(pixels[0].length);

      Posn temp = new Posn(randRow, randCol);

      for (int p = 0; p < counter; p++) {
        Posn posn = seeds.get(p);
        if (posn.getX() == randRow && posn.getY() == randCol) {
          exists = true;
          break;
        }
      }

      if (!exists) {
        seeds.add(temp);
        counter++;
      }
    }
    return seeds;
  }

}
