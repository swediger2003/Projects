package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * View class for triangle Board.
 */
public class TriangleSolitaireTextView extends MarbleSolitaireTextView
        implements MarbleSolitaireView {


  /**
   * This constructor creates a not null MarbleSolitaireModelState.
   *
   * @param model MarbleSolitaireModelState
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    super(model);
    this.object = System.out;
  }


  /**
   * Constrictor makes sure the model and Appendable passed through are not
   * null.
   *
   * @param model  MarbleSolitaireModelState.
   * @param object Appendable passed through.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable object) {
    super(model, object);


  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  public String toString() {

    String s = "";
    String spaces = "";

    while (spaces.length() < model.getBoardSize() - 1 && spaces.length() >= 0) {
      spaces += " ";

    }

    for (int i = 0; i < model.getBoardSize(); i++) {
      s += spaces;
      if (spaces.length() > 0) {
        spaces = spaces.substring(0, spaces.length() - 1);
      }
      for (int j = 0; j < model.getBoardSize(); j++) {
        if (model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {

          s += "O ";


        }
        if (model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid) {
          s += "";
        }
        if (model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          s += "_ ";
        }


      }
      s = s.stripTrailing();
      s = s + "\n";
    }

    s = s.substring(0, s.length() - 1);


    return s;
  }


}
