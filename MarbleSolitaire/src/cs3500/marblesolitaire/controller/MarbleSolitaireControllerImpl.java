package cs3500.marblesolitaire.controller;

import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Marble solitaire controller implementation class.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable r;

  /**
   * Marble solitaire controller constructor.
   *
   * @param model Marble solitaire model.
   * @param view  View class.
   * @param r     Readable passed in.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable r) {
    if (model == null || view == null || r == null) {
      throw new IllegalArgumentException("Null argument(s)");
    }
    this.model = model;
    this.view = view;
    this.r = r;
  }

  /**
   * Checks if in inputted string can be Integer.ParseInt and not null.
   *
   * @param s Inputted
   * @return true if the String can be parsed into an int and is a valid num.
   */
  private boolean isNum(String s) {
    int num;
    if (s == null) {
      return false;
    }
    try {
      num = Integer.parseInt(s);
    } catch (Exception e) {
      return false;
    }
    return (num > 0 || num <= model.getBoardSize());

  }

  /**
   * Renders message that is given into the console.
   *
   * @param s String given that is rendered.
   */
  private void renderMessage(String s) {
    try {
      view.renderMessage(s);
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Renders board.
   */
  private void board() {
    try {
      view.renderBoard();
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }


  /**
   * This method plays a new game of Marble Solitaire.
   *
   * @throws IllegalStateException throw an IllegalStateException only if the controller
   *                               is unable to successfully read input or transmit output.
   */
  @Override
  public void playGame() throws IllegalStateException {
    board();
    renderMessage("\nScore: " + model.getScore());
    Scanner scan = new Scanner(r);
    int[] input = new int[4];


    while (!model.isGameOver()) {

      String in;
      boolean over = false;
      boolean valInput = false;


      for (int i = 0; i < input.length; i++) {
        while (!valInput) {
          if (scan.hasNext()) {
            in = scan.next();
          } else {
            throw new IllegalStateException("no next val");
          }
          if (in.equals("q") || in.equals("Q")) {
            renderMessage("\nGame quit!\n");
            renderMessage("State of game when quit:\n");
            board();
            renderMessage("\nScore: " + model.getScore());
            over = true;
            break;
          } else {
            if (!isNum(in)) {
              renderMessage("Invalid input " + in + ". Try another input (in positive number "
                      + "that's less that the size of the board or Q/q:");
            } else {
              input[i] = Integer.parseInt(in);
              valInput = true;


            }
          }
        }
        if (over) {

          return;
        }

        valInput = false;

      }


      if (!over) {
        try {
          model.move(input[0] - 1, input[1] - 1, input[2] - 1, input[3] - 1);

        } catch (Exception e) {
          renderMessage("Not a valid move. Play again: ");
        }
        renderMessage("Current state of game \n");
        board();
        renderMessage("\nScore: " + model.getScore());


      }
    }


    if (model.isGameOver()) {
      renderMessage("\nGame over!\n");
      board();
      renderMessage("\nScore: " + model.getScore());
    }
  }
}

