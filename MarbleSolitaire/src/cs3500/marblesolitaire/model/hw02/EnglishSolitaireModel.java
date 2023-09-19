package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.ASolitaireModel;

/**
 * English Solitaire model game class.
 */
public class EnglishSolitaireModel extends ASolitaireModel
        implements MarbleSolitaireModel {


  /**
   * This constructor doesn't take in any parameters. It builds a 7 by 7 board of English solitaire
   * with the empty slot at the middle. The arm thickness of the board is 3.
   */
  public EnglishSolitaireModel() {
    this.size = 7;
    this.armThickness = 3;
    board = makeBoard(3, 3, 3);


  }

  /**
   * This constructor builds a 7 by 7 board of English Solitaire. The empty slot is given by the
   * paramaters at the position (sRow, sCol). THe arm thickness is still three. The empty slot
   * has to be a valid point on the board.
   *
   * @param sRow Integer that tells what row the empty slot is on
   * @param sCol Integer that determines what column the empty slot is on
   * @throws IllegalArgumentException If the given coordinate is off the board
   */
  public EnglishSolitaireModel(int sRow, int sCol) {

    this.armThickness = 3;
    this.size = 7;
    if (!isValid(sRow, sCol, 3) || isOffBoard(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow +
              ", " + sCol + ")");
    }
    board = makeBoard(sRow, sCol, 3);


  }


  /**
   * hHis constructor creates a board based on the size of the arm thinkness given by the parameter.
   * The arm thickness has to be greater than zero and it has to be odd.
   *
   * @param arm This is the arm thickness of the board
   * @throws IllegalArgumentException If arm thickness is even or less than zero.
   */
  public EnglishSolitaireModel(int arm) {
    if (arm <= 0 || arm % 2 == 0) {
      throw new IllegalArgumentException("Invalid arm thickness");
    }


    if (arm == 1) {
      this.size = 3;
      this.armThickness = 1;
      board = makeBoard(1, 1, 1);
    } else {
      int size = arm + (2 * (arm - 1));


      this.size = size;
      this.armThickness = arm;
      board = makeBoard(size / 2, size / 2, arm);


    }
  }


  /**
   * This constructor takes in where the empty slot is basedon the Srow and sCol parameters
   * and determines the sizes of the board based on the arm thickness parameter. Again, the arm
   * thickness can't be even or less that 1. The empty slot can't be in an invalid posn.
   *
   * @param sRow Where the row of the empty slot is
   * @param sCol Where the column of the empty slot is
   * @param arm  The arm thickness of the board
   * @throws IllegalArgumentException If the empty slot is in an invalid position or if the arm
   *                                  thickness is invalid
   */
  public EnglishSolitaireModel(int arm, int sRow, int sCol) {

    if (arm <= 0 || arm % 2 == 0) {
      throw new IllegalArgumentException("Invalid arm thickness");
    }


    if (arm == 1) {
      this.size = 3;
      this.armThickness = 1;
      if (!isValid(sRow, sCol, arm)
              || isOffBoard(sCol, sRow)) {
        throw new IllegalArgumentException("Invalid empty cell position (" + sRow +
                ", " + sCol + ")");
      }
      board = makeBoard(sRow, sCol, 1);
    } else {
      int size = arm + (2 * (arm - 1));

      this.size = size;
      this.armThickness = arm;
      if (isOffBoard(sRow, sCol)) {
        throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", " +
                sCol + ")");
      }
      board = makeBoard(sRow, sCol, arm);
    }

  }



}
