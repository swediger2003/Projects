
import java.io.StringReader;

import org.junit.Test;

import src.controller.ControllerImpl;
import src.controller.IController;
import src.model.ImageModel;
import src.model.ImageProcModel;
import src.model.ImageUtil;
import src.model.Load;
import src.model.Pixel;
import src.model.Image;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * testing class.
 */
public class TestOperations {

  /**
   * this method tests the save function class. it loads an image, manipulates it, and saves it.
   * then, it compares the image saved in the model with the file with the new image.
   */
  @Test
  public void testSave() {
    ImageModel m = new ImageProcModel();
    ImageUtil util = new ImageUtil();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test2.png test " +
            "save /Users/jacobostapenko/Desktop/testOutput.ppm tests q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
    Image i = new Image(m.getCopy("test"));
    Image i2 = new Image(util.readPPM("/Users/jacobostapenko/Desktop/testOutput.ppm"));
    assertTrue(i.equals(i2));
  }

  @Test
  public void testSave2() {
    ImageModel m = new ImageProcModel();
    ImageUtil util = new ImageUtil();
    Readable rd = new StringReader("load /Users/jacobostapenko/Downloads/" +
            "NortheasternTest.png test " +
            "greyscale test test-b " +
            "save /Users/jacobostapenko/Downloads/NortheasternGreyscale.png test-b q");
    IController controller = new ControllerImpl(rd, m);
    new Load("/Users/jacobostapenko/Desktop/NortheasternGreyscale.png",
            "test2").execute(m);
    controller.playGame();
    Image i2 = new Image(m.getCopy("test2"));
    Image i = new Image(m.getCopy("test-b"));
    assertTrue(i.equals(i2));

  }

  /**
   * this method tests the save function class. it loads an image, manipulates it, and saves it.
   * then, it compares the image saved in the model with the file with the new image.
   */
  @Test
  public void testSavePPMToPNG() {
    ImageModel m = new ImageProcModel();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test.ppm test " +
            "brighten 10 test test-brighten " +
            "save /Users/jacobostapenko/Desktop/testBrightenOutput.png test-brighten q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
    Image copy = new Image(m.getCopy("test-brighten"));

    ImageModel m2 = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/testBrightenOutput.png",
            "test-brighten").execute(m2);
    Image output = new Image(m2.getCopy("test-brighten"));
    //  assertEquals(output, copy);
    assertTrue(output.equals(copy));
  }

  /**
   * test method used to test that the program can greyscale an image and save it correctly.
   */
  @Test
  public void testSaveGreyscale() {
    ImageModel m = new ImageProcModel();
    ImageUtil util = new ImageUtil();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test.ppm test " +
            "red-component test test-grey " +
            "save /Users/jacobostapenko/Desktop/testOutputGrey.ppm test-grey q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
    Pixel[][] copy = m.getCopy("test-grey");
    Pixel[][] saved = util.readPPM("/Users/jacobostapenko/Desktop/testOutputGrey.ppm");
    for (int row = 0; row < m.getHeight("test-grey"); row++) {
      for (int col = 0; col < m.getWidth("test-grey"); col++) {
        assertEquals(copy[row][col], saved[row][col]);
      }
    }
  }

  /**
   * test method used to test that the program can vertical flip an image and save it correctly.
   */
  @Test
  public void testSaveVFlip() {
    ImageModel m = new ImageProcModel();
    ImageUtil util = new ImageUtil();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test.ppm test " +
            "vertical-flip test test-VFlip " +
            "save /Users/jacobostapenko/Desktop/testOutputVFlip.ppm test-VFlip q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
    Pixel[][] copy = m.getCopy("test-VFlip");
    Pixel[][] saved = util.readPPM("/Users/jacobostapenko/Desktop/testOutputVFlip.ppm");
    for (int row = 0; row < m.getHeight("test-VFlip"); row++) {
      for (int col = 0; col < m.getWidth("test-VFlip"); col++) {
        assertEquals(copy[row][col], saved[row][col]);
      }
    }
  }

  /**
   * test method used to test that the program can darken an image and save it correctly.
   */
  @Test
  public void testSaveDarken() {
    ImageModel m = new ImageProcModel();
    ImageUtil util = new ImageUtil();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test.ppm test " +
            "darken 10 test test-darken " +
            "save /Users/jacobostapenko/Desktop/testOutputDarken.ppm test-darken q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
    Pixel[][] copy = m.getCopy("test-darken");
    Pixel[][] saved = util.readPPM("/Users/jacobostapenko/Desktop/testOutputDarken.ppm");
    for (int row = 0; row < m.getHeight("test-darken"); row++) {
      for (int col = 0; col < m.getWidth("test-darken"); col++) {
        assertEquals(copy[row][col], saved[row][col]);
      }
    }
  }

  /**
   * test method used to test that the program can horizontally flip an image and save it correctly.
   */
  @Test
  public void testSaveHorizontal() {
    ImageModel m = new ImageProcModel();
    ImageUtil util = new ImageUtil();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test.ppm test " +
            "horizontal-flip test test-horizontal " +
            "save /Users/jacobostapenko/Desktop/testOutputHFlip.ppm test-horizontal q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
    Pixel[][] copy = m.getCopy("test-horizontal");
    Pixel[][] saved = util.readPPM("/Users/jacobostapenko/Desktop/testOutputHFlip.ppm");
    for (int row = 0; row < m.getHeight("test-horizontal"); row++) {
      for (int col = 0; col < m.getWidth("test-horizontal"); col++) {
        assertEquals(copy[row][col], saved[row][col]);
      }
    }
  }

  /**
   * this method tests that the brighten function class throws an exception when it doesn't receive
   * an increment by which to brighten.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBrightenException() {
    ImageModel m = new ImageProcModel();
    ImageUtil util = new ImageUtil();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test.ppm test " +
            "brighten test test-brighten ");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
  }

  /**
   * this method tests that the darken function class throws an exception when it doesn't receive
   * an increment by which to brighten.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDarkenException() {
    ImageModel m = new ImageProcModel();
    ImageUtil util = new ImageUtil();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test.ppm test " +
            "darken test test-darken ");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
  }

  /**
   * test methdo that tests that the program throws an exception when given an invalid file path.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidLocation() {
    ImageModel m = new ImageProcModel();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/foo.ppm test ");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();

  }

  /**
   * test method that checks that the program throws an exception when given an unknown/invalid cmd.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCmd() {
    ImageModel m = new ImageProcModel();
    Readable rd = new StringReader("fail /Users/jacobostapenko/Desktop/test.ppm test q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
  }


  /**
   * test method that checks the program can load a file correctly and put it into the model.
   */
  @Test
  public void testLoad() {
    ImageModel m = new ImageProcModel();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test.ppm test q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
    Pixel[][] image = m.getCopy("test");

    Pixel[][] image2 = new Pixel[][]{
            {new Pixel(24, 120, 120), new Pixel(0, 0, 0), new Pixel(100, 100, 100)},
            {new Pixel(255, 255, 255), new Pixel(0, 0, 0), new Pixel(50, 50, 50)},
            {new Pixel(75, 0, 0), new Pixel(0, 50, 0), new Pixel(0, 0, 100)}
    };
    Pixel[][] imaged = m.getCopy("test");
    for (int row = 0; row < m.getHeight("test"); row++) {
      for (int col = 0; col < m.getWidth("test"); col++) {
        assertEquals(image[row][col], image2[row][col]);
      }
    }
  }

  /**
   * test method that checks the program can load a file correctly and put it into the model.
   */
  @Test
  public void testLoad2() {
    ImageModel m = new ImageProcModel();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/IMG_6550copy.JPG test q");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();
    Pixel[][] image = m.getCopy("test");

    Pixel[][] image2 = new Pixel[][]{
            {new Pixel(125, 121, 48), new Pixel(0, 0, 0), new Pixel(100, 100, 100)},
            {new Pixel(255, 255, 255), new Pixel(0, 0, 0), new Pixel(50, 50, 50)},
            {new Pixel(75, 0, 0), new Pixel(0, 50, 0), new Pixel(0, 0, 100)}
    };
    //  Pixel[][] imaged = m.getCopy("test");
    assertEquals(image[0][0].getRed(), image2[0][0].getRed());
    assertEquals(image[0][0].getGreen(), image2[0][0].getGreen());
    assertEquals(image[0][0].getBlue(), image2[0][0].getBlue());

  }

  /**
   * test method that checks that the program can take a current image version and brighten its
   * pixels.
   */
  @Test
  public void testBrighten() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm", "test").execute(m);
    Readable sr = new StringReader("brighten 10 test test-brighten q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel brightenFirstPixel = m.getPixel("test-brighten", 0, 0);
    Pixel brightenMiddlePixel = m.getPixel("test-brighten", 1, 0);
    Pixel brightenLastPixel = m.getPixel("test-brighten", 2, 2);

    assertEquals(34, brightenFirstPixel.getRed());
    assertEquals(130, brightenFirstPixel.getGreen());
    assertEquals(130, brightenFirstPixel.getBlue());

    assertEquals(255, brightenMiddlePixel.getRed());
    assertEquals(255, brightenMiddlePixel.getGreen());
    assertEquals(255, brightenMiddlePixel.getBlue());

    assertEquals(10, brightenLastPixel.getRed());
    assertEquals(10, brightenLastPixel.getGreen());
    assertEquals(110, brightenLastPixel.getBlue());

  }

  /**
   * test method that checks that the program can take a current image version and darken its
   * pixels.
   */
  @Test
  public void testDarken() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm",
            "test").execute(m);
    Readable sr = new StringReader("darken 10 test test-darken q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel darkenFirstPixel = m.getPixel("test-darken", 0, 0);
    Pixel darkenMiddlePixel = m.getPixel("test-darken", 1, 1);
    Pixel darkenLastPixel = m.getPixel("test-darken", 2, 2);

    assertEquals(14, darkenFirstPixel.getRed());
    assertEquals(110, darkenFirstPixel.getGreen());
    assertEquals(110, darkenFirstPixel.getBlue());

    assertEquals(0, darkenMiddlePixel.getRed());
    assertEquals(0, darkenMiddlePixel.getGreen());
    assertEquals(0, darkenMiddlePixel.getBlue());

    assertEquals(0, darkenLastPixel.getRed());
    assertEquals(0, darkenLastPixel.getGreen());
    assertEquals(90, darkenLastPixel.getBlue());

  }

  /**
   * test method that checks that the program can take a current image version and red-grey-scale
   * its pixels.
   */
  @Test
  public void testRedGreyScale() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm",
            "test").execute(m);
    Readable sr = new StringReader("red-component test test-red-greyscale q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel redgsFirstPixel = m.getPixel("test-red-greyscale", 0, 0);
    Pixel redgsMiddlePixel = m.getPixel("test-red-greyscale", 0, 2);
    Pixel redgsLastPixel = m.getPixel("test-red-greyscale", 2, 2);

    assertEquals(24, redgsFirstPixel.getRed());
    assertEquals(24, redgsFirstPixel.getGreen());
    assertEquals(24, redgsFirstPixel.getBlue());

    assertEquals(75, redgsMiddlePixel.getRed());
    assertEquals(75, redgsMiddlePixel.getGreen());
    assertEquals(75, redgsMiddlePixel.getBlue());

    assertEquals(0, redgsLastPixel.getRed());
    assertEquals(0, redgsLastPixel.getGreen());
    assertEquals(0, redgsLastPixel.getBlue());

  }

  /**
   * test method that checks that the program can take a current image version and green-grey-scale
   * its pixels.
   */
  @Test
  public void testGreenGreyScale() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm",
            "test").execute(m);
    Readable sr = new StringReader("green-component test test-green-greyscale q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel greengsFirstPixel = m.getPixel("test-green-greyscale", 0, 0);
    Pixel greengsMiddlePixel = m.getPixel("test-green-greyscale", 2, 1);
    Pixel greengsLastPixel = m.getPixel("test-green-greyscale", 2, 2);

    assertEquals(120, greengsFirstPixel.getRed());
    assertEquals(120, greengsFirstPixel.getGreen());
    assertEquals(120, greengsFirstPixel.getBlue());

    assertEquals(50, greengsMiddlePixel.getRed());
    assertEquals(50, greengsMiddlePixel.getGreen());
    assertEquals(50, greengsMiddlePixel.getBlue());

    assertEquals(0, greengsLastPixel.getRed());
    assertEquals(0, greengsLastPixel.getGreen());
    assertEquals(0, greengsLastPixel.getBlue());

  }

  /**
   * test method that checks that the program can take a current image version and blue-grey-scale
   * its pixels.
   */
  @Test
  public void testBlueGreyScale() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm",
            "test").execute(m);
    Readable sr = new StringReader("blue-component test test-blue-greyscale q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel bluegsFirstPixel = m.getPixel("test-blue-greyscale", 0, 0);
    Pixel bluegsMiddlePixel = m.getPixel("test-blue-greyscale", 1, 1);
    Pixel bluegsLastPixel = m.getPixel("test-blue-greyscale", 2, 2);

    assertEquals(120, bluegsFirstPixel.getRed());
    assertEquals(120, bluegsFirstPixel.getGreen());
    assertEquals(120, bluegsFirstPixel.getBlue());

    assertEquals(0, bluegsMiddlePixel.getRed());
    assertEquals(0, bluegsMiddlePixel.getGreen());
    assertEquals(0, bluegsMiddlePixel.getBlue());

    assertEquals(100, bluegsLastPixel.getRed());
    assertEquals(100, bluegsLastPixel.getGreen());
    assertEquals(100, bluegsLastPixel.getBlue());
  }

  /**
   * Tests for assuring the accuracy of the HorizontalFlip command and command class.
   */
  @Test
  public void testHorizontalFlip() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm",
            "test").execute(m);
    Readable sr = new StringReader("horizontal-flip test test-horizontal q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel horizFirstPixel = m.getPixel("test-horizontal", 0, 0);
    Pixel horizMiddlePixel = m.getPixel("test-horizontal", 1, 1);
    Pixel horizLastPixel = m.getPixel("test-horizontal", 0, 2);

    assertEquals(100, horizFirstPixel.getRed());
    assertEquals(100, horizFirstPixel.getGreen());
    assertEquals(100, horizFirstPixel.getBlue());

    assertEquals(0, horizMiddlePixel.getRed());
    assertEquals(0, horizMiddlePixel.getGreen());
    assertEquals(0, horizMiddlePixel.getBlue());

    assertEquals(24, horizLastPixel.getRed());
    assertEquals(120, horizLastPixel.getGreen());
    assertEquals(120, horizLastPixel.getBlue());
  }

  /**
   * Tests for assuring the accuracy of the VerticalFlip command and command class.
   */
  @Test
  public void testVerticalFlip() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm",
            "test").execute(m);
    Readable sr = new StringReader("vertical-flip test test-vertical q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel horizFirstPixel = m.getPixel("test-vertical", 0, 0);
    Pixel horizMiddlePixel = m.getPixel("test-vertical", 1, 1);
    Pixel horizLastPixel = m.getPixel("test-vertical", 2, 0);

    assertEquals(75, horizFirstPixel.getRed());
    assertEquals(0, horizFirstPixel.getGreen());
    assertEquals(0, horizFirstPixel.getBlue());

    assertEquals(0, horizMiddlePixel.getRed());
    assertEquals(0, horizMiddlePixel.getGreen());
    assertEquals(0, horizMiddlePixel.getBlue());

    assertEquals(24, horizLastPixel.getRed());
    assertEquals(120, horizLastPixel.getGreen());
    assertEquals(120, horizLastPixel.getBlue());
  }


  /**
   * Tests for assuring the accuracy of the Intesity command and command class.
   */
  @Test
  public void testIntensity() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm",
            "test").execute(m);
    Readable sr = new StringReader("intensity test test-intensity q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel intensityFirstPixel = m.getPixel("test-intensity", 0, 0);
    Pixel intensityMiddlePixel = m.getPixel("test-intensity", 1, 1);
    Pixel intensityLastPixel = m.getPixel("test-intensity", 2, 2);

    assertEquals(88, intensityFirstPixel.getRed());
    assertEquals(88, intensityFirstPixel.getGreen());
    assertEquals(88, intensityFirstPixel.getBlue());

    assertEquals(0, intensityMiddlePixel.getRed());
    assertEquals(0, intensityMiddlePixel.getGreen());
    assertEquals(0, intensityMiddlePixel.getBlue());

    assertEquals(33, intensityLastPixel.getRed());
    assertEquals(33, intensityLastPixel.getGreen());
    assertEquals(33, intensityLastPixel.getBlue());
  }

  /**
   * Tests for assuring the accuracy of the Luma command and command class.
   */
  @Test
  public void testLuma() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm",
            "test").execute(m);
    Readable sr = new StringReader("luma test test-luma q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel lumaFirstPixel = m.getPixel("test-luma", 0, 0);
    Pixel lumaMiddlePixel = m.getPixel("test-luma", 1, 1);
    Pixel lumaLastPixel = m.getPixel("test-luma", 2, 2);

    assertEquals(99, lumaFirstPixel.getRed());
    assertEquals(99, lumaFirstPixel.getGreen());
    assertEquals(99, lumaFirstPixel.getBlue());

    assertEquals(0, lumaMiddlePixel.getRed());
    assertEquals(0, lumaMiddlePixel.getGreen());
    assertEquals(0, lumaMiddlePixel.getBlue());

    assertEquals(7, lumaLastPixel.getRed());
    assertEquals(7, lumaLastPixel.getGreen());
    assertEquals(7, lumaLastPixel.getBlue());
  }


  /**
   * Tests for assuring the accuracy of the valueComponent command and command class.
   */

  @Test
  public void testValueComponent() {
    ImageModel m = new ImageProcModel();
    new Load("/Users/jacobostapenko/Desktop/test.ppm",
            "test").execute(m);
    Readable sr = new StringReader("value-component test test-value-component q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    Pixel valueComponentFirstPixel = m.getPixel("test-value-component", 0, 0);
    Pixel valueComponentMiddlePixel = m.getPixel("test-value-component", 1, 1);
    Pixel valueComponentLastPixel = m.getPixel("test-value-component", 2, 2);

    assertEquals(120, valueComponentFirstPixel.getRed());
    assertEquals(120, valueComponentFirstPixel.getGreen());
    assertEquals(120, valueComponentFirstPixel.getBlue());

    assertEquals(0, valueComponentMiddlePixel.getRed());
    assertEquals(0, valueComponentMiddlePixel.getGreen());
    assertEquals(0, valueComponentMiddlePixel.getBlue());

    assertEquals(100, valueComponentLastPixel.getRed());
    assertEquals(100, valueComponentLastPixel.getGreen());
    assertEquals(100, valueComponentLastPixel.getBlue());
  }

  /**
   * Tests for assuring the accuracy of the Blur command and command class.
   */
  @Test
  public void testBlur() {
    ImageModel m = new ImageProcModel();
    Readable sr = new StringReader(
            "load /Users/jacobostapenko/Downloads/NortheasternTest.png test2 "
                    + "blur test2 test-blur q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    new Load("/Users/jacobostapenko/Downloads/NortheasternGaussianBlur.png",
            "testcopy").execute(m);
    Pixel[][] image2 = m.getCopy("testcopy");
    Pixel[][] imageCopy = m.getCopy("test-blur");
    Image i2 = new Image(image2);
    Image i = new Image(imageCopy);
    assertTrue(i.equals(i2));

  }

  /**
   * Tests for assuring the accuracy of the Blur command and command class.
   */
  @Test
  public void testSepia() {
    ImageModel m = new ImageProcModel();
    Readable sr = new StringReader(
            "load /Users/jacobostapenko/Downloads/NortheasternTest.png test2 "
                    + "sepia test2 test-sepia q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    new Load("/Users/jacobostapenko/Downloads/NortheasternSepia.png",
            "testcopy").execute(m);
    Pixel[][] image2 = m.getCopy("testcopy");
    Pixel[][] imageCopy = m.getCopy("test-sepia");
    Image i2 = new Image(image2);
    Image i = new Image(imageCopy);
    assertTrue(i.equals(i2));

  }

  /**
   * Tests that the sharpen method works as intended with valid inputs.
   */
  @Test
  public void testSharpen() {
    ImageModel m = new ImageProcModel();
    Readable sr = new StringReader(
            "load /Users/jacobostapenko/Downloads/NortheasternTest.png test2 "
                    + "sharpen test2 test-sharpen q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    new Load("/Users/jacobostapenko/Downloads/NortheasternSharpened.png",
            "testcopy").execute(m);
    Pixel[][] image2 = m.getCopy("testcopy");
    Pixel[][] imageCopy = m.getCopy("test-sharpen");
    Image i2 = new Image(image2);
    Image i = new Image(imageCopy);
    assertTrue(i.equals(i2));

  }

  /**
   * Tests that the generic greyscale method works as intended with valid inputs.
   */
  @Test
  public void testGreyscale() {
    ImageModel m = new ImageProcModel();
    Readable sr = new StringReader(
            "load /Users/jacobostapenko/Downloads/NortheasternTest.png test2 "
                    + "greyscale test2 test-greyscale q");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

    new Load("/Users/jacobostapenko/Downloads/NortheasternGreyscale.png",
            "testcopy").execute(m);
    Pixel[][] image2 = m.getCopy("testcopy");
    Pixel[][] imageCopy = m.getCopy("test-greyscale");
    Image i2 = new Image(image2);
    Image i = new Image(imageCopy);
    assertTrue(i.equals(i2));

  }

  /**
   * Tests that a valid file throws an IllegalArgument exception when containing invalid commands.
   */
  @Test
  public void testLoadCommandsFromFile() {
    ImageModel m = new ImageProcModel();
    Readable sr = new StringReader("file /Users/jacobostapenko/Desktop/brightenCommands.txt");
    IController controller = new ControllerImpl(sr, m);
    Image i = new Image(new Pixel[][]{
            {new Pixel(34, 130, 130), new Pixel(110, 60, 60), new Pixel(110, 110, 110)},
            {new Pixel(255, 255, 255), new Pixel(210, 210, 210), new Pixel(160, 60, 160)},
            {new Pixel(85, 10, 209), new Pixel(210, 60, 10), new Pixel(10, 10, 110)}
    });
    controller.playGame();
    new Load("/Users/jacobostapenko/Desktop/testOutput.ppm", "test3").execute(m);
    Image image2 = new Image(m.getCopy("test3"));

    assertTrue(image2.equals(i));
  }

  /**
   * Tests that an invalid file throws an IllegalArgument exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLoadCommandsFromFile2() {
    ImageModel m = new ImageProcModel();
    Readable sr = new StringReader("file /Users/jacobostapenko/Desktop/brightenCommandscopy.txt");
    IController controller = new ControllerImpl(sr, m);
    Image i = new Image(new Pixel[][]{
            {new Pixel(34, 130, 130), new Pixel(110, 60, 60), new Pixel(110, 110, 110)},
            {new Pixel(255, 255, 255), new Pixel(210, 210, 210), new Pixel(160, 60, 160)},
            {new Pixel(85, 10, 209), new Pixel(210, 60, 10), new Pixel(10, 10, 110)}
    });
    controller.playGame();
    new Load("/Users/jacobostapenko/Desktop/testOutput.ppm", "test3").execute(m);
    Image image2 = new Image(m.getCopy("test3"));
  }


  /**
   * Tests for reading a pmm file from a filepath.
   */
  @Test
  public void testReadPPM() {
    ImageUtil util = new ImageUtil();


    Pixel[][] koalaBoard = util.readPPM("/Users/jacobostapenko/Desktop/test.ppm");
    Pixel koalaFirstPixel = koalaBoard[0][0];

    assertEquals(3, koalaBoard.length);
    assertEquals(24, koalaFirstPixel.getRed());
    assertEquals(120, koalaFirstPixel.getGreen());
    assertEquals(120, koalaFirstPixel.getBlue());
  }


  /**
   * this method tests that the file function throws an exception when it receives
   * a file with incorrect command arguments.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFileWrongInputs() {
    ImageModel m = new ImageProcModel();
    Readable sr = new StringReader(
            "file commandcopy.txt");
    IController controller = new ControllerImpl(sr, m);
    controller.playGame();

  }

  /**
   * this method tests that the save function class throws an exception when it receives
   * an invalid file.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSaveWrongFileException() {
    ImageModel m = new ImageProcModel();
    Readable rd = new StringReader("load /Users/jacobostapenko/Desktop/test.ppm test " +
            "darken test test-darken " +
            "save /Users/jacobostapenko/Desktop/testbad.ppm test-darken");
    IController controller = new ControllerImpl(rd, m);
    controller.playGame();


  }


}
