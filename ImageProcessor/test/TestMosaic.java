import org.junit.Test;

import src.controller.ControllerImpl;
import src.controller.IController;
import src.model.Image;
import src.model.ImageModel;
import src.model.ImageProcModel;
import src.model.Load;
import src.model.Mosaic;
import src.model.MosaicUtils;
import src.model.Pixel;
import src.model.Posn;
import src.model.Save;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

/**
 * Tests that the mosaicing function works by testing just the command objects, controller to model
 * interaction, and individual MosaicUtils() and Posn() methods such as distance calculations
 * and creating a list of random positions.
 */
public class TestMosaic {
  private final Random rand = new Random(2);
  private final Random rand2 = new Random(3);

  @Test
  public void testControllerToModel() {
    ImageModel m = new ImageProcModel();
    Readable rd = new StringReader("res/TestImage.ppm test" +
            "mosaic 1 test test-mosaic " +
            "save res/testimage.png test-mosaic q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
    Image copy = new Image(m.getCopy("test-mosaic"));
    ImageModel m2 = new ImageProcModel();
    new Load("res/testMosaic1.png",
            "test-mosaic").execute(m2);
    Image output = new Image(m2.getCopy("test-mosaic"));
    assertTrue(output.equals(copy));
  }

  @Test
  public void testIncorrectInputs() {
    ImageModel m = new ImageProcModel();
    new Load("res/TestImage.ppm", "test").execute(m);
    Readable sr = new StringReader("mosaic 10 test test-brighten q");
    IController controller = new ControllerImpl(sr, m);


    assertThrows(IllegalArgumentException.class, () ->
            new Mosaic(11, "test", "test-mosaic", rand2).execute(m));
    assertThrows(IllegalArgumentException.class, () ->
            new Mosaic(0, "test", "test-mosaic", rand2).execute(m));
    assertThrows(IllegalArgumentException.class, () ->
            new Mosaic(-5, "test", "test-mosaic", rand2).execute(m));
  }

  @Test
  public void testMosaic1() {
    ImageModel m = new ImageProcModel();
    new Load("res/TestImage.ppm", "test").execute(m);
    Readable sr = new StringReader(
            "mosaic 10 test test-mosaic save res/testMosaic1.png test-mosaic q");
    IController controller = new ControllerImpl(sr, m);


    new Mosaic(3, "test", "test-mosaic2", rand).execute(m);
    new Save("res/testMosaic1.png", "test-mosaic2").execute(m);
    new Load("res/testMosaic1.png", "test-m2").execute(m);

    Pixel r0c0 = new Pixel(40, 43, 46);
    Pixel r0c1 = new Pixel(10, 20, 30);
    Pixel r0c2 = new Pixel(46, 50, 53);
    Pixel[] row0 = {r0c0, r0c1, r0c2};


    Pixel r1c0 = new Pixel(40, 50, 60);
    Pixel r1c1 = new Pixel(10, 20, 30);
    Pixel r1c2 = new Pixel(40, 50, 60);
    Pixel[] row1 = {r1c0, r1c1, r1c2};

    Pixel r2c0 = new Pixel(40, 50, 60);
    Pixel r2c1 = new Pixel(10, 20, 30);
    Pixel r2c2 = new Pixel(46, 50, 53);
    Pixel[] row2 = {r2c0, r2c1, r2c2};


    Pixel[][] pix1 = {row0, row1, row2};
    Pixel[][] pix2 = m.getCopy("test-m2");

    assertEquals(pix2[0][0], pix1[0][0]);
    assertEquals(pix2[0][1], pix1[0][1]);
    assertEquals(pix2[0][2], pix1[0][2]);

    assertEquals(pix2[1][0], pix1[1][0]);
    assertEquals(pix2[1][1], pix1[1][1]);
    assertEquals(pix2[1][2], pix1[1][2]);

    assertEquals(pix2[2][0], pix1[2][0]);
    assertEquals(pix2[2][1], pix1[2][1]);
    assertEquals(pix2[2][2], pix1[2][2]);

  }

  @Test
  public void testMosaic2() {
    ImageModel m = new ImageProcModel();
    new Load("res/TestImage.ppm", "test").execute(m);
    Readable sr = new StringReader(
            "mosaic 10 test test-mosaic save res/testMosaic1.png test-mosaic q");
    IController controller = new ControllerImpl(sr, m);


    new Mosaic(1, "test", "test-mosaic2", rand).execute(m);
    new Save("res/testMosaic1.png", "test-mosaic2").execute(m);
    new Load("res/testMosaic1.png", "test-m2").execute(m);

    Pixel r0c0 = new Pixel(50, 53, 54);
    Pixel r0c1 = new Pixel(50, 53, 54);
    Pixel r0c2 = new Pixel(50, 53, 54);
    Pixel[] row0 = {r0c0, r0c1, r0c2};


    Pixel r1c0 = new Pixel(50, 53, 54);
    Pixel r1c1 = new Pixel(50, 53, 54);
    Pixel r1c2 = new Pixel(50, 53, 54);
    Pixel[] row1 = {r1c0, r1c1, r1c2};

    Pixel r2c0 = new Pixel(50, 53, 54);
    Pixel r2c1 = new Pixel(50, 53, 54);
    Pixel r2c2 = new Pixel(50, 53, 54);
    Pixel[] row2 = {r2c0, r2c1, r2c2};


    Pixel[][] pix1 = {row0, row1, row2};
    Pixel[][] pix2 = m.getCopy("test-m2");

    assertEquals(pix2[0][0], pix1[0][0]);
    assertEquals(pix2[0][1], pix1[0][1]);
    assertEquals(pix2[0][2], pix1[0][2]);

    assertEquals(pix2[1][0], pix1[1][0]);
    assertEquals(pix2[1][1], pix1[1][1]);
    assertEquals(pix2[1][2], pix1[1][2]);

    assertEquals(pix2[2][0], pix1[2][0]);
    assertEquals(pix2[2][1], pix1[2][1]);
    assertEquals(pix2[2][2], pix1[2][2]);

  }

  @Test
  public void testMosaicUtils() {
    ImageModel m = new ImageProcModel();
    new Load("res/TestImage.ppm", "test").execute(m);
    Pixel[][] image2 = m.getCopy("test");

    assertThrows(IllegalArgumentException.class, () ->
            new MosaicUtils().findRandomPixels(image2, 11, rand2));
    assertThrows(IllegalArgumentException.class, () ->
            new MosaicUtils().findRandomPixels(image2, 0, rand2));
    assertThrows(IllegalArgumentException.class, () ->
            new MosaicUtils().findRandomPixels(image2, -5, rand2));

    Posn p1 = new Posn(1, 1);
    Posn p2 = new Posn(2, 2);
    Posn p3 = new Posn(0, 2);

    ArrayList<Posn> positions = new ArrayList<>();
    positions.add(p1);
    positions.add(p2);
    positions.add(p3);
    ArrayList<Posn> seeds = new MosaicUtils().findRandomPixels(image2, 3, rand2);

    System.out.println(seeds.get(0).getX() + "," + seeds.get(0).getX());
    assertEquals(p1, seeds.get(0));

    System.out.println(seeds.get(1).getX() + "," + seeds.get(1).getX());
    assertEquals(p2, seeds.get(1));

    System.out.println(seeds.get(2).getX() + "," + seeds.get(2).getX());
    assertEquals(p3, seeds.get(2));

  }

  @Test
  public void testPosn() {
    Posn p1 = new Posn(1, 1);
    Posn p2 = new Posn(2, 2);
    Posn p3 = new Posn(0, 2);

    assertEquals(p1.dist(p1), 0, 0.01);
    assertEquals(p1.dist(p2), 1.4142135623730951, 0.01);
    assertEquals(p2.dist(p3), 2, 0.01);
    assertEquals(p3.dist(p1), 1.4142135623730951, 0.01);
    assertEquals(p3.dist(p2), 2, 0.01);
  }
}
