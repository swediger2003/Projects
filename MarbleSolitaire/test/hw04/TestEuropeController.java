package hw04;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.ConfirmInput;
import cs3500.marblesolitaire.controller.FakeAppendable;
import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test MarbleSolitaireController class with Euro model.
 */
public class TestEuropeController {


  @Test(expected = IllegalArgumentException.class)
  public void testNull() {
    Readable defaultReadable = new StringReader("string");
    MarbleSolitaireModel m = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, builder);

    MarbleSolitaireController controllerNullModel = new MarbleSolitaireControllerImpl(null,
            view, defaultReadable);


  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullView() {
    Readable defaultReadable = new StringReader("string");
    MarbleSolitaireModel m = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, builder);

    MarbleSolitaireController controllerNullView = new MarbleSolitaireControllerImpl(m,
            null, defaultReadable);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullController() {
    Readable defaultReadable = new StringReader("string");
    MarbleSolitaireModel m = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(m, builder);

    MarbleSolitaireController controllerNullReader = new MarbleSolitaireControllerImpl(m,
            view, null);
  }

  @Test
  public void testRenderMessage() throws IOException {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    view.renderMessage("message");

    assertEquals("message", log.toString());
  }


  @Test
  public void testRenderboard() throws IOException {
    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable log = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);


    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", view.toString());
  }


  @Test
  public void testJustQ() {
    Readable quitFirstLowerCase = new StringReader("q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitFirstLowerCase);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", builder.toString());
  }

  @Test
  public void testJustQ2() {
    Readable quitFirstLowerCase = new StringReader("Q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitFirstLowerCase);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", builder.toString());
  }


  @Test
  public void testQuit() {
    Readable quitFirstLowerCase = new StringReader("q 1 2 3 4");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitFirstLowerCase);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", builder.toString());
  }

  @Test
  public void testQuit2() {
    Readable quitFirstQ = new StringReader("Q 2 4 4 4");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitFirstQ);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", builder.toString());
  }

  @Test
  public void testQuit3() {
    Readable quitAfterInput = new StringReader("2 q 4 4 4");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", builder.toString());
  }

  @Test
  public void testQuit4() {
    Readable quitAfterInput = new StringReader("2 4 Q 4 4");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", builder.toString());
  }

  @Test
  public void testQuit5() {
    Readable quitAfterInput = new StringReader("2 4 4 q 4 q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", builder.toString());
  }

  @Test
  public void testQuit6() {
    Readable quitAfterInput = new StringReader("2 4 4 Q 4");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", builder.toString());
  }

  @Test
  public void testQuitAfterValidMove() {
    Readable quitAfterInput = new StringReader("2 4 4 4 Q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36Current state of game \n" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35", builder.toString());
  }

  @Test
  public void testQuitAfterValidMoveLowerCase() {
    Readable quitAfterInput = new StringReader("2 4 4 4 q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36Current state of game \n" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35", builder.toString());
  }

  @Test
  public void testValidMove() {
    Readable quitAfterInput = new StringReader("2 4 4 4 q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36Current state of game \n" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 35", builder.toString());
  }

  @Test
  public void testQuitAfterInvalid() {
    Readable quitAfterInput = new StringReader("invalid q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36" +
            "Invalid input invalid. Try another input " +
            "(in positive number that's less that the size of the board or Q/q:\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n" +
            "Score: 36", builder.toString());
  }


  @Test
  public void testPlayThrough() {
    Readable playThrough = new StringReader("2 4 4 4 3 2 3 4 3 5 3 3 5 4 3 4 " +
            "5 5 3 5 7 5 5 5 7 3 7 5 6 3 6 5 5 6 5 4 7 5 5 5 5 4 5 6 5 7 5 5 5 2 5 4 " +
            "5 5 5 3 4 3 6 3 3 4 3 2 3 1 3 3 2 3 4 3 4 2 4 4 5 1 3 1 " +
            "3 6 3 4 4 7 4 5 1 5 3 5 1 3 1 5 4 5 2 5 1 5 3 5 3 4 3 6 3 7 3 5 6 2 6 4 q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, playThrough);
    assertFalse(model.isGameOver());

    controllerQuit.playGame();


    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 34Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 33Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O _ O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 32Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O _ _ O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 31Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O _ O O O\n" +
                    "  O O O _ O\n" +
                    "    O O _\n" +
                    "Score: 30Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O _ O O O\n" +
                    "  O O O _ O\n" +
                    "    _ _ O\n" +
                    "Score: 29Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O _ O O O\n" +
                    "  O _ _ O O\n" +
                    "    _ _ O\n" +
                    "Score: 28Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O O _ _ O\n" +
                    "  O _ _ O O\n" +
                    "    _ _ O\n" +
                    "Score: 27Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O O O _ O\n" +
                    "  O _ _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 26Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O _ _ O O\n" +
                    "  O _ _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 25Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O _ O _ _\n" +
                    "  O _ _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 24Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O _ _ O O _ _\n" +
                    "  O _ _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 23Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O _ O _ _ _ _\n" +
                    "  O _ _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 22Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O _ O O O O O\n" +
                    "O O _ _ _ O O\n" +
                    "O _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 21Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O _ _ O O O\n" +
                    "O O _ _ _ O O\n" +
                    "O _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 20Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "_ _ O _ O O O\n" +
                    "O O _ _ _ O O\n" +
                    "O _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 19Current state of game \n" +
                    "    O O O\n" +
                    "  O _ _ O O\n" +
                    "_ _ _ _ O O O\n" +
                    "O O O _ _ O O\n" +
                    "O _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 18Current state of game \n" +
                    "    O O O\n" +
                    "  O _ _ O O\n" +
                    "_ _ _ _ O O O\n" +
                    "O _ _ O _ O O\n" +
                    "O _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 17Current state of game \n" +
                    "    O O O\n" +
                    "  O _ _ O O\n" +
                    "O _ _ _ O O O\n" +
                    "_ _ _ O _ O O\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 16Current state of game \n" +
                    "    O O O\n" +
                    "  O _ _ O O\n" +
                    "O _ _ O _ _ O\n" +
                    "_ _ _ O _ O O\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 15Current state of game \n" +
                    "    O O O\n" +
                    "  O _ _ O O\n" +
                    "O _ _ O _ _ O\n" +
                    "_ _ _ O O _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 14Current state of game \n" +
                    "    O O _\n" +
                    "  O _ _ _ O\n" +
                    "O _ _ O O _ O\n" +
                    "_ _ _ O O _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 13Current state of game \n" +
                    "    _ _ O\n" +
                    "  O _ _ _ O\n" +
                    "O _ _ O O _ O\n" +
                    "_ _ _ O O _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 12Current state of game \n" +
                    "    _ _ O\n" +
                    "  O _ _ O O\n" +
                    "O _ _ O _ _ O\n" +
                    "_ _ _ O _ _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 11Current state of game \n" +
                    "    _ _ _\n" +
                    "  O _ _ _ O\n" +
                    "O _ _ O O _ O\n" +
                    "_ _ _ O _ _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 10Current state of game \n" +
                    "    _ _ _\n" +
                    "  O _ _ _ O\n" +
                    "O _ _ _ _ O O\n" +
                    "_ _ _ O _ _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 9Current state of game \n" +
                    "    _ _ _\n" +
                    "  O _ _ _ O\n" +
                    "O _ _ _ O _ _\n" +
                    "_ _ _ O _ _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  O O _ _ O\n" +
                    "    _ _ _\n" +
                    "Score: 8Current state of game \n" +
                    "    _ _ _\n" +
                    "  O _ _ _ O\n" +
                    "O _ _ _ O _ _\n" +
                    "_ _ _ O _ _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  _ _ O _ O\n" +
                    "    _ _ _\n" +
                    "Score: 7\n" +
                    "Game over!\n" +
                    "    _ _ _\n" +
                    "  O _ _ _ O\n" +
                    "O _ _ _ O _ _\n" +
                    "_ _ _ O _ _ _\n" +
                    "_ _ _ _ _ _ _\n" +
                    "  _ _ O _ O\n" +
                    "    _ _ _\n" +
                    "Score: 7"
            , builder.toString());

    assertTrue(model.isGameOver());
  }

  @Test
  public void testStringInput() {
    Readable invalidInput = new StringReader("invalid q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, invalidInput);
    controllerQuit.playGame();

    assertEquals("" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36" +
                    "Invalid input invalid. Try another input " +
                    "(in positive number that's less that the size of the board or Q/q:\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36"
            , builder.toString());
  }


  @Test
  public void testStringInput2() {
    Readable quitAfterInput = new StringReader("2 4 4 4 invalid q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35" +
                    "Invalid input invalid. " +
                    "Try another input " +
                    "(in positive number that's less that the size of the board or Q/q:\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , builder.toString());
  }

  @Test
  public void testStringInput3() {
    Readable quitAfterInput = new StringReader("2 invalid 4 4 4 q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36" +
                    "Invalid input invalid. Try another input " +
                    "(in positive number that's less that the size of the board or Q/q:" +
                    "Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , builder.toString());
  }

  @Test
  public void testStringInput4() {
    Readable quitAfterInput = new StringReader("nope invalid 2 4 4 4 q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36Invalid input nope. Try another input " +
                    "(in positive number that's less that the size of the board or Q/q:" +
                    "Invalid input invalid. " +
                    "Try another input" +
                    " (in positive number that's less that the size of the board or Q/q:" +
                    "Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , builder.toString());

  }


  @Test
  public void testStringInput5() {
    Readable quitAfterInput = new StringReader("2 nope 4 invalid 4 4 q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);

    MarbleSolitaireController controllerQuit = new MarbleSolitaireControllerImpl(model,
            view, quitAfterInput);
    controllerQuit.playGame();

    assertEquals("    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36Invalid input nope. " +
                    "Try another input " +
                    "(in positive number that's less that the size of the board or Q/q:" +
                    "Invalid input invalid. Try another input " +
                    "(in positive number that's less that the size of the board or Q/q:" +
                    "Current state of game \n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35"
            , builder.toString());
  }


  @Test
  public void testInput() {
    Readable r = new StringReader("2 4 4 4 q");

    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable builder = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, builder);


    StringBuilder log = new StringBuilder();
    ConfirmInput mock = new ConfirmInput(log);

    MarbleSolitaireControllerImpl controller2 = new MarbleSolitaireControllerImpl(mock,
            view, r);
    controller2.playGame();
    assertEquals("1 3 3 3 ", log.toString());


    StringBuilder log2 = new StringBuilder();
    Readable r2 = new StringReader("1 3 2 a 5 q");
    ConfirmInput mock2 = new ConfirmInput(log2);
    MarbleSolitaireControllerImpl controller3 = new MarbleSolitaireControllerImpl(mock2,
            view, r2);
    controller3.playGame();
    assertEquals("0 2 1 4 ", log2.toString());

  }

  @Test(expected = IllegalStateException.class)
  public void testCrashAppendable() {
    Readable readable = new StringReader("1 2 3 4");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable crashAppendable = new FakeAppendable();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, crashAppendable);

    MarbleSolitaireController crashController = new MarbleSolitaireControllerImpl(model,
            view, readable);
    crashController.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testCrashAppendable2() {
    Readable readable = new StringReader("I really dont 12 4 4 4 4 q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable crashAppendable = new FakeAppendable();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, crashAppendable);

    MarbleSolitaireController crashController = new MarbleSolitaireControllerImpl(model,
            view, readable);
    crashController.playGame();
  }


  @Test(expected = IllegalStateException.class)
  public void testCrashAppendable3() {
    Readable readable = new StringReader("q");


    MarbleSolitaireModel model = new EuropeanSolitaireModel();
    Appendable crashAppendable = new FakeAppendable();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, crashAppendable);

    MarbleSolitaireController crashController = new MarbleSolitaireControllerImpl(model,
            view, readable);
    crashController.playGame();
  }


}
