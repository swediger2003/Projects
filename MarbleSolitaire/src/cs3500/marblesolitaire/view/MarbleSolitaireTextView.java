package cs3500.marblesolitaire.view;

import java.io.IOException;
import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;


/**
 * Rendering class for the English Marble Solitaire and Euro Board.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  protected MarbleSolitaireModelState model;

  protected Appendable object;


  /**
   * This constructor creates a not null MarbleSolitaireModelState.
   *
   * @param model MarbleSolitaireModelState
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) {
    this.model = Objects.requireNonNull(model);
    this.object = System.out;

  }


  /**
   * Constrictor makes sure the model and Appendable passed through are not
   * null.
   *
   * @param model  MarbleSolitaireModelState.
   * @param object Appendable passed through.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable object) {
    if (model == null || object == null) {
      throw new IllegalArgumentException("Appendable or model null");
    }
    this.model = model;
    this.object = object;
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

    for (int i = 0; i < model.getBoardSize(); i++) {
      for (int j = 0; j < model.getBoardSize(); j++) {
        if (model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
          s += "O ";
        }
        if (model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid) {
          s += "  ";
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

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderBoard() throws IOException {
    try {
      object.append(toString());
    } catch (Exception e) {
      throw new IOException(e);
    }


  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  @Override
  public void renderMessage(String message) throws IOException {
    try {
      object.append(message);
    } catch (IOException e) {
      throw new IOException(e);
    }

  }
}
