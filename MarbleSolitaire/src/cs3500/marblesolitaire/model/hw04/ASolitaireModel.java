package cs3500.marblesolitaire.model.hw04;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Abstract class for each of the models. Contains all the methods that are used for
 * EnglishSolitaire model.
 */
public abstract class ASolitaireModel implements MarbleSolitaireModel {

  protected SlotState[][] board;

  protected int size;

  protected int armThickness;


  /**
   * This method creates the board and assigns SlotStates to each place.
   *
   * @param sRow         The row where the empty slot is
   * @param sCol         THe column where the empty slot is
   * @param armThickness The arm thickness of the board
   * @return A board of type SlotState.
   * @throws IllegalArgumentException If the empty slot placement is invalid
   */
  protected SlotState[][] makeBoard(int sRow, int sCol, int armThickness)
          throws IllegalArgumentException {
    int size;
    SlotState[][] b;
    if (armThickness == 1) {
      size = 3;
      b = new SlotState[size][size];
      b[0][0] = SlotState.Invalid;
      b[0][1] = SlotState.Marble;
      b[0][2] = SlotState.Invalid;
      b[1][0] = SlotState.Marble;
      b[1][1] = SlotState.Marble;
      b[1][2] = SlotState.Marble;
      b[2][0] = SlotState.Invalid;
      b[2][1] = SlotState.Marble;
      b[2][2] = SlotState.Invalid;

      if (!(b[sRow][sCol].equals(SlotState.Marble))) {
        throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", "
                + sCol + ")");
      } else {
        b[sRow][sCol] = SlotState.Empty;
      }
    } else {

      size = armThickness + (2 * (armThickness - 1));

      b = new SlotState[size][size];


      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          if (isValid(i, j, armThickness)) {
            b[i][j] = SlotState.Marble;
          } else {
            b[i][j] = SlotState.Invalid;
          }
        }

      }

      if (isOffBoard(sRow, sCol)) {
        throw new IllegalArgumentException("Given point is off the board ");
      }

      if (!(b[sRow][sCol].equals(SlotState.Marble))) {
        throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", "
                + sCol + ")");
      } else {
        b[sRow][sCol] = SlotState.Empty;
      }


    }

    return b;
  }


  /**
   * This method determins if the specific coordinates on the board is invalid or valid.
   *
   * @param row          The row of the coordinate given
   * @param column       The column of the coordinate given
   * @param armThickness THe thickness of the arm
   * @return Whether the piece is va;id pt not (bool)
   */
  protected boolean isValid(int row, int column, int armThickness) {
    if (row < (armThickness - 1) && column < (armThickness - 1)) {
      return false;
    }
    if (row < (armThickness - 1) && (column > (armThickness + (armThickness - 2)))) {
      return false;
    }
    if (row > (armThickness + (armThickness - 2)) &&
            (column > (armThickness + (armThickness - 2)))) {
      return false;
    }
    return column >= (armThickness - 1) || (row <= (armThickness + (armThickness - 2)));
  }


  /**
   * Determines whether a SlotState is empty.
   *
   * @param slotState Given a SlotState on the board to determine if it is empty
   * @return True if the Slot state is empty
   */
  protected boolean isEmpty(SlotState slotState) {
    return (slotState == MarbleSolitaireModelState.SlotState.Empty);
  }

  /**
   * Determines whether a SlotState is taken.
   *
   * @param slotState Given a SlotState on the board to determine if it is empty
   * @return True if the Slot State has a marble
   */
  protected boolean isTaken(SlotState slotState) {
    return (slotState == MarbleSolitaireModelState.SlotState.Marble);
  }

  /**
   * Determine if the given point on the board is on the board.
   *
   * @param row Row of wanted slot
   * @param col Coplumn of given slot
   * @return True if the given coordinate is off the board
   */
  protected boolean isOffBoard(int row, int col) {
    return (row < 0 || col < 0 || row > size - 1 || col > size - 1);
  }


  /**
   * Determines if a move up is possible from a given coordinate to another given coordinate.
   *
   * @param fromRow THe row of the from coordinate
   * @param fromCol The column of the from coordinate
   * @param toRow   The row of the to coordinate
   * @param toCol   The column of the to coordinate
   * @return True if the move is a valid up movement
   */
  protected boolean isValidUp(int fromRow, int fromCol, int toRow, int toCol) {
    if (isOffBoard(toRow, toCol) || (getSlotAt(fromRow, fromCol) != SlotState.Marble)
            || !isEmpty(board[toRow][toCol])) {
      return false;
    } else {
      return ((fromCol == toCol) && (fromRow - 2 == toRow)
              && (board[fromRow - 2][fromCol] == SlotState.Empty)
              && (board[fromRow][fromCol] == SlotState.Marble)
              && (board[fromRow - 1][fromCol] == SlotState.Marble));
    }
  }

  /**
   * Determines if a move down is possible from a given coordinate to another given coordinate.
   *
   * @param fromRow THe row of the from coordinate
   * @param fromCol The column of the from coordinate
   * @param toRow   The row of the to coordinate
   * @param toCol   The column of the to coordinate
   * @return True if the move is a valid down movement
   */
  protected boolean isValidDown(int fromRow, int fromCol, int toRow, int toCol) {
    if (isOffBoard(toRow, toCol) || !isTaken(board[fromRow][fromCol])
            || !isEmpty(board[toRow][toCol])) {
      return false;
    } else {
      return ((fromCol == toCol) && (fromRow + 2 == toRow)
              && (board[fromRow + 2][fromCol] == SlotState.Empty)
              && (board[fromRow][fromCol] == SlotState.Marble)
              && (board[fromRow + 1][fromCol] == SlotState.Marble));
    }
  }


  /**
   * Determines if a move left is possible from a given coordinate to another given coordinate.
   *
   * @param fromRow THe row of the from coordinate
   * @param fromCol The column of the from coordinate
   * @param toRow   The row of the to coordinate
   * @param toCol   The column of the to coordinate
   * @return True if the move is a valid left movement
   */
  protected boolean isValidLeft(int fromRow, int fromCol, int toRow, int toCol) {
    if (isOffBoard(toRow, toCol) || !isTaken(board[fromRow][fromCol])
            || !isEmpty(board[toRow][toCol])) {
      return false;
    } else {
      return ((fromCol - 2 == toCol) && (fromRow == toRow)
              && (board[fromRow][fromCol - 2] == SlotState.Empty)
              && (board[fromRow][fromCol] == SlotState.Marble)
              && (board[fromRow][fromCol - 1] == SlotState.Marble));
    }
  }


  /**
   * Determines if a move right is possible from a given coordinate to another given coordinate.
   *
   * @param fromRow THe row of the from coordinate
   * @param fromCol The column of the from coordinate
   * @param toRow   The row of the to coordinate
   * @param toCol   The column of the to coordinate
   * @return True if the move is a valid right movement
   */
  protected boolean isValidRight(int fromRow, int fromCol, int toRow, int toCol) {
    if (isOffBoard(toRow, toCol) || !isTaken(board[fromRow][fromCol])
            || !isEmpty(board[toRow][toCol])) {
      return false;
    } else {
      return ((fromCol + 2 == toCol) && (fromRow == toRow)
              && (board[fromRow][fromCol + 2] == SlotState.Empty)
              && (board[fromRow][fromCol] == SlotState.Marble)
              && (board[fromRow][fromCol + 1] == SlotState.Marble));
    }
  }


  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
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
    } else {
      throw new IllegalArgumentException("This move is invalid");
    }

  }

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    Boolean bool = true;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (isValidRight(i, j, i, j + 2) || isValidLeft(i, j, i, j - 2)
                || isValidDown(i, j, i + 2, j) || isValidUp(i, j, i - 2, j)) {

          bool = false;
        }

      }


    }
    return bool;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {

    return this.size;
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public MarbleSolitaireModelState.SlotState getSlotAt(int row, int col) throws
          IllegalArgumentException {
    if (isOffBoard(row, col)) {
      throw new IllegalArgumentException("Off Board");


    } else if (board[row][col] == SlotState.Marble) {
      return SlotState.Marble;
    } else if (board[row][col] == SlotState.Empty) {
      return SlotState.Empty;
    } else {
      return SlotState.Invalid;
    }
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    int s = 0;
    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size; j++) {

        if (isTaken(board[i][j])) {
          s += 1;
        }
      }
    }
    return s;
  }

}
