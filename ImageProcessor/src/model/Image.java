package src.model;

/**
 * Class which represents an image. Created to help compare 2D arrays of pixels to one another.
 */
public class Image {
  Pixel[][] pics;

  public Image(Pixel[][] imageCopy) {
    this.pics = imageCopy;
  }

  public int getHeight() {
    return pics.length;
  }

  public int getWidth() {
    return pics[0].length;
  }

  public Pixel getPixel(int row, int col) {
    return pics[row][col];
  }


  @Override
  public boolean equals(Object other) {
    for (int row = 0; row < getHeight(); row++) {
      for (int col = 0; col < getWidth(); col++) {
        if (other instanceof Image) {
          Image newImage = (Image) other;
          if (!pics[row][col].equals(newImage.getPixel(row, col))) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int counter = 0;
    for (int row = 0; row < this.getHeight(); row++) {
      for (int col = 0; col < this.getWidth(); col++) {
        counter += (pics[row][col].hashCode());
      }
    }
    return counter;
  }
}
