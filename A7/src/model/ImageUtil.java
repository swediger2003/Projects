package src.model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


// THIS CLASS:
// RETURNS: THE IMAGE HEIGHT, WIDTH, AND ARRAY OF PIXELS


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filepath the path of the file.
   */
  public static Pixel[][] readPPM(String filepath) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filepath));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("no file found");
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxNumber = sc.nextInt();

    Pixel[][] board = new Pixel[height][width];


    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        //creates color and adds pixel to board
        Pixel pixel = new Pixel(r, g, b);
        board[i][j] = pixel;
        //       System.out.println("Color of pixel ("+j+","+i+"): "+ r+","+g+","+b);
      }
    }
    return board;
  }

  /**
   * Converts a bufferedImage to a 2D pixel array that represents the image.
   * @param image A BufferedImage from a popular file format.
   * @return A 2D array of pixels which maps out to the pixels of the BufferedImage.
   */
  public Pixel[][] convertToArray(BufferedImage image)  {
    Pixel[][] newImage = new Pixel[image.getHeight()][image.getWidth()];
    for (int row = 0; row < image.getHeight(); row ++) {
      for (int col = 0; col < image.getWidth(); col ++) {
        int i = image.getRGB(col, row);
        Color color = new Color(i, true);
        newImage[row][col] = new Pixel(color.getRed(), color.getGreen(), color.getBlue());
      }
    }
    return newImage;
  }
}



