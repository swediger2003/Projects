package cs3500.marblesolitaire.controller;


/**
 * Interface for controller of EnglishModelSolitaire.
 */
public interface MarbleSolitaireController {

  /**
   * This method plays a new game of Marble Solitaire.
   *
   * @throws IllegalStateException throw an IllegalStateException only if the controller
   *                               is unable to successfully read input or transmit output.
   */
  void playGame() throws IllegalStateException;
}
