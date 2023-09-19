package src.controller;

/**
 * features interfrace.
 */
public interface Features {

  /**
   * Method that executes the commands within the list of commands in the controller.
   * @param s name of command given to the controller via the view.
   */
  void doAction(String s);

  /**
   * Exit protocol for the program.
   */
  void exitProgram();

  /**
   * Opens a command select menu within the view and allows for the user to choose a command.
   */
  void commandSelect();

}
