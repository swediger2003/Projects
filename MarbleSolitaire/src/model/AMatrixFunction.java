package src.model;

import java.util.function.Function;

/**
 * a class used to abstract reused code that takes in a matrix and multiples the surrounding
 * pixels with the values in the matrix.
 */
public abstract class AMatrixFunction extends AFunction implements ImageFunction {


  /**
   * Constructs a command class argument for the image processing program.
   *
   * @param imageName the source image name the desired command is to be implemented on.
   * @param imageDest the destination name in which the image name is to be saved under after the
   *                  command has been implemented.
   */
  public AMatrixFunction(String imageName, String imageDest) {
    super(imageName, imageDest);
  }

  /**
   * INVARIANT: the kernel will always be a square of odd number sides.
   *
   * @param row    Y-index of the pixel that is being operated on.
   * @param col    X-index of the pixel that is being operated on.
   * @param image  2D Pixel array that is a representation of the picture.
   * @param kernel 2D double array representing the matrix of the command being operated on
   *               the given pixel
   * @return       The result of applying the kernal matrix with the surrounding values
   *                  of the given pixel.
   */
  public Pixel matrixMult(int row, int col, Pixel[][] image, double[][] kernel) {
    int bound = (kernel.length - 1) / 2;


    // fills the surrounding pixel matrix
    int[][] redSurroundingPixels = getSurroundingPixels(row, col, image, bound, kernel.length,
            (Pixel::getRed));
    int[][] greenSurroundingPixels = getSurroundingPixels(row, col, image, bound, kernel.length,
            (Pixel::getGreen));
    int[][] blueSurroundingPixels = getSurroundingPixels(row, col, image, bound, kernel.length,
            (Pixel::getBlue));

    // multiply by kernel matrix
    int redComp = multiplyCompByKernel(redSurroundingPixels, row, col, kernel, image, bound);
    int greenComp = multiplyCompByKernel(greenSurroundingPixels, row, col, kernel, image, bound);
    int blueComp = multiplyCompByKernel(blueSurroundingPixels, row, col, kernel, image, bound);

    if (redComp > 255) {
      redComp = 255;
    }
    if (greenComp > 255) {
      greenComp = 255;
    }
    if (blueComp > 255) {
      blueComp = 255;
    }

    if (redComp < 0) {
      redComp = 0;
    }
    if (greenComp < 0) {
      greenComp = 0;
    }
    if (blueComp < 0) {
      blueComp = 0;
    }
    // set new pixel.
    return new Pixel(redComp, greenComp, blueComp);


  }

  private int multiplyCompByKernel(int[][] surroundingValues, int row, int col, double[][] kernel,
                                   Pixel[][] image, int bound) {
    double dotProduct = 0;
    for (int krow = 0; krow < kernel.length; krow++) {
      for (int kcol = 0; kcol < kernel[0].length; kcol++) {
        if (squareValid(row, col, krow, kcol, image[0].length, image.length)) {
          dotProduct += (kernel[krow][kcol] * surroundingValues[krow][kcol]);
        }
      }
    }
    return (int) dotProduct;
  }


  private int[][] getSurroundingPixels(int row, int col, Pixel[][] image, int bound,
                                       int len, Function<Pixel, Integer> func) {
    int[][] pixels = new int[len][len];
    for (int krow = 0 - bound; krow <= 0 + bound; krow++) {
      for (int kcol = 0 - bound; kcol <= 0 + bound; kcol++) {
        if (squareValid(row, col, krow, kcol, image[0].length, image.length)) {
          Pixel pixel = image[krow + row][kcol + col];
          pixels[krow + bound][kcol + bound] = func.apply(pixel);
        }
      }
    }
    return pixels;
  }

  private boolean squareValid(int row, int col, int krow, int kcol, int width, int height) {
    return ((row + krow >= 0 && col + kcol >= 0) && (row + krow < height && col + kcol < width));
  }
}
