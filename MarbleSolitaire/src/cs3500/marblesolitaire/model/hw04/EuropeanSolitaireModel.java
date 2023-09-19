package cs3500.marblesolitaire.model.hw04;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * European Solitaire model class. Extends English solitaire model. Creates a model
 * for a european solitaire board.
 */
public class EuropeanSolitaireModel extends ASolitaireModel
        implements MarbleSolitaireModel {


  /**
   * This constructor doesn't take in any parameters. It builds a 7 by 7 board of English solitaire
   * with the empty slot at the middle. The arm thickness of the board is 3.
   */
  public EuropeanSolitaireModel() {
    this.size = 7;
    this.armThickness = 3;
    board = makeBoard(3, 3, 3);


  }


  /**
   * THis creates a 7 by 7 European solitaire board with a arm thickness
   * of 3 and an empty slot given by parameters. Empty slot has to be valid.
   * @param sRow Where the row of the empty slot is
   * @param sCol sCol Where the column of the empty slot is
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {

    this.armThickness = 3;
    this.size = 7;
    if (isOffBoard(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow +
              ", " + sCol + ")");
    }
    board = makeBoard(sRow, sCol, 3);


  }


  /**
   * hHis constructor creates a European board based on the size of the arm
   * thinkness given by the parameter.
   * The arm thickness has to be greater than zero and it has to be odd.
   *
   * @param arm This is the arm thickness of the board
   * @throws IllegalArgumentException If arm thickness is even or less than zero.
   */
  public EuropeanSolitaireModel(int arm) {
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
   * and determines the sizes of the board based on the arm thickness parameter.
   * Creates a EUropean solitaire board. Again, the arm
   * thickness can't be even or less that 1. The empty slot can't be in an invalid posn.
   *
   * @param sRow Where the row of the empty slot is
   * @param sCol Where the column of the empty slot is
   * @param arm  The arm thickness of the board
   * @throws IllegalArgumentException If the empty slot is in an invalid position or if the arm
   *                                  thickness is invalid
   */
  public EuropeanSolitaireModel(int arm, int sRow, int sCol) {

    if (arm <= 0 || arm % 2 == 0) {
      throw new IllegalArgumentException("Invalid arm thickness");
    }


    if (arm == 1) {
      this.size = 3;
      this.armThickness = 1;
      if (!isValid(sRow, sCol, 1)
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

  /**
   * This method determins if the specific coordinates on the board is invalid or valid.
   *
   * @param row    The row of the coordinate given
   * @param column The column of the coordinate given
   * @return Whether the piece is va;id pt not (bool)
   */
  private boolean isValidEuro(int row, int column) {
    return ((row < this.armThickness - 1 && column < (this.size / 2) -
            ((this.armThickness + (2 * row)) / 2))
            || (row < this.armThickness - 1 && column > (this.size / 2) +
            ((this.armThickness + (2 * row)) / 2))
            || (row > (this.size / 2) + ((this.armThickness + (2 * column)) / 2)
            && column < armThickness - 1)
            || (row > armThickness * 2 - 2 && column > (this.size / 2)
            + ((this.armThickness + ((this.size - row - 1) * 2)) / 2)));

  }

  /**
   * Creates a European Marble Solitaire board based of of the empty slot and arm thickness given by
   * constructor.
   * @param sRow         The row where the empty slot is
   * @param sCol         THe column where the empty slot is
   * @param armThickness The arm thickness of the board
   * @return Ibnitialized Euro board.
   * @throws IllegalArgumentException If the given inputs do are not valid. (eg. armthickness even).
   */

  protected MarbleSolitaireModelState.SlotState[][] makeBoard(int sRow, int sCol, int armThickness)
          throws IllegalArgumentException {
    int size;
    MarbleSolitaireModelState.SlotState[][] b;
    if (armThickness == 1) {
      size = 3;
      b = new MarbleSolitaireModelState.SlotState[size][size];
      b[0][0] = MarbleSolitaireModelState.SlotState.Invalid;
      b[0][1] = MarbleSolitaireModelState.SlotState.Marble;
      b[0][2] = MarbleSolitaireModelState.SlotState.Invalid;
      b[1][0] = MarbleSolitaireModelState.SlotState.Marble;
      b[1][1] = MarbleSolitaireModelState.SlotState.Marble;
      b[1][2] = MarbleSolitaireModelState.SlotState.Marble;
      b[2][0] = MarbleSolitaireModelState.SlotState.Invalid;
      b[2][1] = MarbleSolitaireModelState.SlotState.Marble;
      b[2][2] = MarbleSolitaireModelState.SlotState.Invalid;

      if (!(b[sRow][sCol].equals(MarbleSolitaireModelState.SlotState.Marble))) {
        throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", "
                + sCol + ")");
      } else {
        b[sRow][sCol] = MarbleSolitaireModelState.SlotState.Empty;
      }
    } else {

      size = armThickness + (2 * (armThickness - 1));

      b = new MarbleSolitaireModelState.SlotState[size][size];


      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          if (!isValidEuro(i, j)) {
            b[i][j] = MarbleSolitaireModelState.SlotState.Marble;
          } else {
            b[i][j] = MarbleSolitaireModelState.SlotState.Invalid;
          }
        }

      }

      if (isOffBoard(sRow, sCol)) {
        throw new IllegalArgumentException("Given point is off the board ");
      }

      if (!(b[sRow][sCol].equals(MarbleSolitaireModelState.SlotState.Marble))) {
        throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", "
                + sCol + ")");
      } else {
        b[sRow][sCol] = MarbleSolitaireModelState.SlotState.Empty;
      }


    }

    return b;
  }

}

