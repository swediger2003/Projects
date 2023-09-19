package src.model;


/**
 * Posn interface. Represents operations that we use on positions to be able to tell the distance
 * from one another.
 */
public interface IPosition {

  /**
   * Get the x coordinate of a posn.
   * @return x coord as posn.
   */
  public int getX();

  /**
   * GEts tje y coordinate of a posn.
   * @return y coord as an int.
   */
  public int getY();

  /**
   * Calculates the distance between two posns.
   * @param other Given position that we find the distance between.
   * @return The distance between the two posns.
   */
  public double dist(Posn other);

  /**
   * Checks if two positions are equal.
   * @param other Other position that we compare this posn to.
   * @return True if the positions are the same.
   */
  public boolean equals(Object other);
}
