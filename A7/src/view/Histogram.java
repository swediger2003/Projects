package src.view;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Class that represents a histogram for the colors in ana image. Uses a line grpah to chart the
 * values of the histogram.
 */
public class Histogram extends JPanel {
  int[] rhisto = new int[256];
  int[] ghisto = new int[256];
  int[] bhisto = new int[256];
  int[] avgHisto = new int[256];



  /**
   * initializes the red histogram with a given array of ints representing the red values. Stores
   * the values of red from 0-255 and charts how frequently they show up.
   *
   * @param rhisto histogram with a given array of ints representing the red values.
   */
  public void setRHisto(int[] rhisto) {
    this.rhisto = rhisto;
  }


  /**
   * initializes the green histogram with a given array of ints representing the red values. Stores
   * the values of green from 0-255 and charts how frequently they show up.
   *
   * @param ghisto histogram with a given array of ints representing the green values.
   */
  public void setGHisto(int[] ghisto) {
    this.ghisto = ghisto;
  }


  /**
   * initializes the blue histogram with a given array of ints representing the blue values. Stores
   * the values of blue from 0-255 and charts how frequently they show up.
   *
   * @param bhisto histogram with a given array of ints representing the blue values.
   */
  public void setBHisto(int[] bhisto) {
    this.bhisto = bhisto;
  }

  /**
   * initializes the average histogram with a given array of ints representing the average values
   * of all three colors. Stores the values of the average from 0-255 and charts how frequently
   * the averages show up
   *
   * @param avgHisto histogram with a given array of ints representing the blue values.
   */
  public void setAvgHisto(int[] avgHisto) {
    this.avgHisto = avgHisto;
  }


  /**
   * Paints all 4 histograms overlaying each other, on a given graphics object.
   *
   * @param g the <code>Graphics</code> is the given graphics object from the guiView
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics = (Graphics2D) g;
    drawLines(graphics, rhisto, Color.RED);
    drawLines(graphics, ghisto, Color.GREEN);
    drawLines(graphics, bhisto, Color.BLUE);
    drawLines(graphics, avgHisto, Color.BLACK);
  }

  /**
   * Draws the line of a given histogram on a given graphics object. The values follow a range of
   * 0-255 and represent the "brightness" of each color value.
   *
   * @param g     given grphics object from the view.
   * @param histo given histogram from the model, passed through the controller and finally to
   *              the view.
   * @param color Identity of the histogram we are making, also the color of the line.
   */
  private void drawLines(Graphics g, int[] histo, Color color) {

    double max = 1.0;
    for (int c = 0; c < 256; c++) {
      if (((double) histo[c]) > max) {
        max = (double) histo[c];
      }
    }
    // max is highest number in array of values
    // used to scale
    // height of histo windo is 200.
    for (int colorBrightness = 0; colorBrightness < 255; colorBrightness++) {
      int y1;
      int y2;
      if (histo[colorBrightness] == 0) {
        y1 = 0;
      } else {
        try {
          y1 = (int) (((double) histo[colorBrightness]) * ((200.0 / max)));
        } catch (NullPointerException e) {
          y1 = 0;
        }
      }
      if (histo[colorBrightness + 1] == 0) {
        y2 = 0;
      } else {
        try {
          y2 = (int) (((double) histo[colorBrightness + 1])
                  * ((200.0 / max)));
        } catch (NullPointerException e) {
          y2 = 0;
        }
      }

      g.setColor(color);
      g.drawLine(colorBrightness, y1, colorBrightness + 1, y2);

    }
  }

}







