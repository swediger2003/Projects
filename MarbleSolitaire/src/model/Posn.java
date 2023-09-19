package src.model;

/**
 * Class Posn - represents a point in two-dimensional space.
 */
public class Posn implements IPosition {
  private int x;
  private int y;

  /**
   * Constructor for class Posn.
   * @param x  the x coordinate of the new Posn.
   * @param y  the y coordinate of the new Posn.
   */
  public Posn(int x, int y) {

    this.x = x;
    this.y = y;
  }

  /**
   Positions y coordinate.
   @return int:y coordinate.
   */
  public int getY() {
    return this.y;
  }

  /**
   Posn's x coordinate.
   @return int: x coord.
   */
  public int getX() {
    return this.x;
  }


  /**
   * Distance from one another.
   * @param other Other position that we want to calculate distance of.
   * @return the distance.
   */
  public double dist(Posn other) {
    int xDiff = this.x - other.x;
    int yDiff = this.y - other.y;
    return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
  }

  /**
   * Compare two positions for equality.
   * @param other Other position that we compare this posn to.
   * @return if the two objects are equal.
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Posn)) {
      return false;
    }
    Posn p = (Posn)other;
    return (this.x == p.getX() && this.y == p.getY());
  }

  /**
   * Overides the hash code of a posn object.
   * @return The hash code of the object as an int.
   */
  @Override
  public int hashCode() {
    return (this.x * this.y) + this.x + this.y;
  }
}