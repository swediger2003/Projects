package cs3500.marblesolitaire.model.hw04;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Triangle model class. Creates the board and the methods that are needed to play the game.
 */
public class TriangleSolitaireModel extends ASolitaireModel
        implements MarbleSolitaireModel {


  /**
   * Initialized the board. Default case. Creates a triangle of size 5 with empty slot at 0, 0.
   */
  public TriangleSolitaireModel() {
    this.size = 5;
    this.board = makeBoard(0, 0, size);
  }

  /**
   * Creates a Triangle marble solitaire board. Takes in the sizes of the trianlge. Empty slot is
   * still at 0, 0.
   * @param dimensions The size of the triangle.
   * @throws IllegalArgumentException if dimensions is less than 1.
   */
  public TriangleSolitaireModel(int dimensions) {
    if (dimensions < 1) {
      throw new IllegalArgumentException("Dimension of triangle not positive");
    }

    this.size = dimensions;

    this.board = makeBoard(0, 0, size);
  }

  /**
   * Creates  a Triangle marble solitaire board where the empty slot is given by user. The size
   * of the triangle is still 5.
   * @param row Row where empty slot is.
   * @param col Column of empty slot
   * @throws IllegalArgumentException If the given empty slot is invalid.
   */
  public TriangleSolitaireModel(int row, int col) {
    this.size = 5;
    if (isOffBoard(row, col)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + row +
              ", " + col + ")");
    }
    this.board = makeBoard(row, col, size);

  }

  /**
   * Creates a triangle Marble solitaire  board
   * where the size and paramaters are given by the inputs.
   * @param dimensions THe size of the triangle.
   * @param row Row of empty slot.
   * @param col Column of empty slot.
   * @throws IllegalArgumentException If the given empty slot or dimensions are invalid.
   */
  public TriangleSolitaireModel(int dimensions, int row, int col) {
    this.size = dimensions;
    if (dimensions < 1) {
      throw new IllegalArgumentException("Dimension of triangle not positive");
    }

    if (isOffBoard(row, col)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + row +
              ", " + col + ")");
    }


    this.board = makeBoard(row, col, size);
  }


  /**
   * Actually initializes the Triangle Marble solitaire board.
   * @param sRow         The row where the empty slot is
   * @param sCol         THe column where the empty slot is
   * @param armThickness The arm thickness of the board
   * @return THe initialized triangle board.
   * @throws IllegalArgumentException If the given empty slot or dimensions are invalid.
   */
  protected MarbleSolitaireModelState.SlotState[][] makeBoard(int sRow, int sCol, int armThickness)
          throws IllegalArgumentException {
    MarbleSolitaireModelState.SlotState[][] b;


    if (size == 1) {
      b = new MarbleSolitaireModelState.SlotState[size][size];
      if (sRow != 0 || sCol != 0) {
        throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", " +
                sCol + ")");
      }
      b[0][0] = SlotState.Empty;
    } else {
      b = new MarbleSolitaireModelState.SlotState[size][size];


      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          if (i < j) {
            b[i][j] = SlotState.Invalid;
          } else {
            b[i][j] = SlotState.Marble;
          }

        }
      }
      if (isOffBoard(sRow, sCol)) {
        throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", "
                + sCol + ")");
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


  /**
   * Helper that lets move method know that a move diagonally down and right is valid.
   * @param fromRow From row
   * @param fromCol From column
   * @param toRow To row
   * @param toCol To column
   * @return Truw is the move is valid.
   */
  private boolean moveDiagonalDownRight(int fromRow, int fromCol, int toRow, int toCol) {
    if (isOffBoard(toRow, toCol) || !isTaken(board[fromRow][fromCol])
            || !isEmpty(board[toRow][toCol])) {
      return false;
    } else {
      return ((fromRow + 2 == toRow && fromCol + 2 == toCol)
              && (((board[fromRow + 2][fromCol + 2] == SlotState.Empty)
              && (board[fromRow][fromCol] == SlotState.Marble)
              && (board[fromRow + 1][fromCol + 1] == SlotState.Marble))));


    }
  }

  /**
   * Helper that lets move method know that a move diagonally Up and left is valid.
   * @param fromRow From row
   * @param fromCol From column
   * @param toRow To row
   * @param toCol To column
   * @return Truw is the move is valid.
   */
  private boolean moveDiagonalUpLeft(int fromRow, int fromCol, int toRow, int toCol) {
    if (isOffBoard(toRow, toCol) || !isTaken(board[fromRow][fromCol])
            || !isEmpty(board[toRow][toCol])) {
      return false;
    } else {
      return ((fromRow - 2 == toRow && fromCol - 2 == toCol)
              && (((board[fromRow - 2][fromCol - 2] == SlotState.Empty)
              && (board[fromRow][fromCol] == SlotState.Marble)
              && (board[fromRow - 1][fromCol - 1] == SlotState.Marble))));
    }
  }

  /**
   * Helper that lets move method know that a move diagonally down and left is valid.
   * @param fromRow From row
   * @param fromCol From column
   * @param toRow To row
   * @param toCol To column
   * @return Truw is the move is valid.
   */
  private boolean moveDiagonalDownLeft(int fromRow, int fromCol, int toRow, int toCol) {
    if (isOffBoard(toRow, toCol) || !isTaken(board[fromRow][fromCol])
            || !isEmpty(board[toRow][toCol])) {
      return false;
    } else {
      return ((fromRow + 2 == toCol && fromCol - 2 == toCol)
              && (((board[fromRow + 2][fromCol - 2] == SlotState.Empty)
              && (board[fromRow][fromCol] == SlotState.Marble)
              && (board[fromRow + 1][fromCol - 1] == SlotState.Marble))));
    }
  }


  /**
   * Helper that lets move method know that a move diagonally up and right is valid.
   * @param fromRow From row
   * @param fromCol From column
   * @param toRow To row
   * @param toCol To column
   * @return Truw is the move is valid.
   */
  private boolean moveDiagonalUpRight(int fromRow, int fromCol, int toRow, int toCol) {
    if (isOffBoard(toRow, toCol) || !isTaken(board[fromRow][fromCol])
            || !isEmpty(board[toRow][toCol])) {
      return false;
    } else {
      return ((fromRow - 2 == toCol && fromCol + 2 == toCol)
              && (((board[fromRow - 2][fromCol + 2] == SlotState.Empty)
              && (board[fromRow][fromCol] == SlotState.Marble)
              && (board[fromRow - 1][fromCol + 1] == SlotState.Marble))));
    }
  }


  /**
   * Move method for triangle board. A little different from English and Euro boards because
   * diagonal moves are now valid if the conditions allow it to be.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (isValidDown(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow + 1][fromCol] = SlotState.Empty;
      board[fromRow + 2][fromCol] = SlotState.Marble;
    } else if (isValidUp(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow - 1][fromCol] = SlotState.Empty;
      board[fromRow - 2][fromCol] = SlotState.Marble;
    } else if (isValidLeft(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow][fromCol - 1] = SlotState.Empty;
      board[fromRow][fromCol - 2] = SlotState.Marble;
    } else if (isValidRight(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow][fromCol + 1] = SlotState.Empty;
      board[fromRow][fromCol + 2] = SlotState.Marble;
    } else if (moveDiagonalUpLeft(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow - 1][fromCol - 1] = SlotState.Empty;
      board[fromRow - 2][fromCol - 2] = SlotState.Marble;
    } else if (moveDiagonalDownRight(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow + 1][fromCol + 1] = SlotState.Empty;
      board[fromRow + 2][fromCol + 2] = SlotState.Marble;
    } else if (moveDiagonalDownLeft(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow + 1][fromCol - 1] = SlotState.Empty;
      board[fromRow + 2][fromCol - 2] = SlotState.Marble;
    } else if (moveDiagonalUpRight(fromRow, fromCol, toRow, toCol)) {
      board[fromRow][fromCol] = SlotState.Empty;
      board[fromRow - 1][fromCol + 1] = SlotState.Empty;
      board[fromRow - 2][fromCol + 2] = SlotState.Marble;
    } else {
      throw new IllegalArgumentException("This move is invalid");
    }
  }


}
