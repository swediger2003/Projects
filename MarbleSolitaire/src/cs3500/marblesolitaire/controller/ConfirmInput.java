package cs3500.marblesolitaire.controller;

import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;


/**
 * Marble solitaire class that is only used to check the inputs that get put into
 * the move function.
 */
public class ConfirmInput implements MarbleSolitaireModel {
  final StringBuilder log;

  /**
   * Constructor of my fake marble solitaire model.
   *
   * @param log StringBuilder that is used to append the inputs to.
   */
  public ConfirmInput(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * Move function that just appends each of the inputs to the stringBuilder.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException Doesn't ever throw illegalArgumentException.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    this.log.append(fromRow + " " + fromCol + " " + toRow + " " + toCol + " ");
  }

  /**
   * dummy isGameOver.
   *
   * @return false.
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Dummy getBoardSize.
   *
   * @return 0.
   */
  @Override
  public int getBoardSize() {
    return 0;
  }

  /**
   * Dummy getSLotAt.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return null
   * @throws IllegalArgumentException Does not throw exception.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  /**
   * Dummy getScore.
   *
   * @return 0.
   */
  @Override
  public int getScore() {
    return 0;
  }
}

