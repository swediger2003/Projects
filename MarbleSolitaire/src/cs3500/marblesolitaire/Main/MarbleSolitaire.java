package cs3500.marblesolitaire.Main;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;


/**
 * MArble Solitaire class with main. Plays the game.
 */
public final class MarbleSolitaire {

  /**
   * Moin method, runs one of the marble solitaire games, depending on input.
   *
   * @param args The strings that the user input.
   */
  public static void main(String[] args) {


    int row = 0;
    int col = 0;
    int size = 0;

    String type = args[0];


    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-hole")) {
        row = Integer.parseInt(args[i + 1]);
        col = Integer.parseInt(args[i + 2]);
        i += 2;
      } else if (args[i].equals("-size")) {
        size = Integer.parseInt(args[i + 1]);
        i += 1;
      }
    }

    switch (type) {


      case "european": {

        if (size == 0 && row == 0 && col == 0) {
          size = 3;
          row = 3;
          col = 3;
        }

        if (size == 0 && row != 0 && col != 0) {
          size = 3;
        }
        if (size != 0 && row == 0 && col == 0) {
          int full = size + (2 * (size - 1));
          row = full / 2;
          col = full / 2;

        }

        Readable readable = new InputStreamReader(System.in);
        MarbleSolitaireModel modelEuro = new EuropeanSolitaireModel(size, row, col);
        MarbleSolitaireView viewEuro = new MarbleSolitaireTextView(modelEuro, System.out);
        MarbleSolitaireControllerImpl controllerEurp
                = new MarbleSolitaireControllerImpl(modelEuro, viewEuro, readable);
        controllerEurp.playGame();
        return;
      }
      case "english": {
        if (size == 0 && row != 0 && col != 0) {
          size = 3;
        }
        if (row == 0 && col == 0 && size != 0) {
          int full = size + (2 * (size - 1));
          row = full / 2;
          col = full / 2;
        }
        if (size == 0 && row == 0 && col == 0) {
          size = 3;
          row = 3;
          col = 3;
        }
        Readable readableEng = new InputStreamReader(System.in);
        MarbleSolitaireModel modelEng = new EnglishSolitaireModel(size, row, col);
        MarbleSolitaireView viewEng = new MarbleSolitaireTextView(modelEng, System.out);
        MarbleSolitaireControllerImpl controllerEng
                = new MarbleSolitaireControllerImpl(modelEng, viewEng, readableEng);
        controllerEng.playGame();
        return;
      }


      case "triangular": {
        if (size == 0 && row != 0 && col != 0) {
          size = 5;
        }
        if (row == 0 && col == 0 && size != 0) {
          row = 0;
          col = 0;
        }
        if (size == 0 && row == 0 && col == 0) {
          size = 5;
          row = 0;
          col = 0;
        }
        Readable readable = new InputStreamReader(System.in);
        MarbleSolitaireModel modelTriangle = new TriangleSolitaireModel(size, row, col);
        MarbleSolitaireView viewTriangle = new TriangleSolitaireTextView(modelTriangle, System.out);
        MarbleSolitaireControllerImpl controllerTriangle
                = new MarbleSolitaireControllerImpl(modelTriangle, viewTriangle, readable);
        controllerTriangle.playGame();
        return;
      }
      default:
        throw new IllegalArgumentException("Pick 'triangular', 'european', or 'english'");
    }
  }
}
