package hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Test class for Euro Marble Solitaire Game.
 */
public class TestEuroMarbleSolitaire {


  @Test
  public void ViewTest() {
    MarbleSolitaireModel testBoard1 = new EuropeanSolitaireModel();
    MarbleSolitaireView model1 = new MarbleSolitaireTextView(testBoard1);
    String test1 = "" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test1, model1.toString());

    MarbleSolitaireModel testBoard2 = new EuropeanSolitaireModel(0, 3);
    MarbleSolitaireView model2 = new MarbleSolitaireTextView(testBoard2);
    String test2 = "" +
            "    O _ O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test2, model2.toString());

    EuropeanSolitaireModel testBoard3 = new EuropeanSolitaireModel(1);
    MarbleSolitaireView model3 = new MarbleSolitaireTextView(testBoard3);
    String test3 = "  O\nO _ O\n  O";
    assertEquals(test3, model3.toString());

    EuropeanSolitaireModel testBoard4 = new EuropeanSolitaireModel(3, 1, 1);
    MarbleSolitaireView model4 = new MarbleSolitaireTextView(testBoard4);
    String test4 = "" +
            "    O O O\n" +
            "  _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test4, model4.toString());

    EuropeanSolitaireModel testBoard5 = new EuropeanSolitaireModel(3, 1, 5);
    MarbleSolitaireView model5 = new MarbleSolitaireTextView(testBoard5);
    String test5 = "" +
            "    O O O\n" +
            "  O O O O _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test5, model5.toString());


    EuropeanSolitaireModel testBoard6 = new EuropeanSolitaireModel(3, 5, 1);
    MarbleSolitaireView model6 = new MarbleSolitaireTextView(testBoard6);
    String test6 = "" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  _ O O O O\n" +
            "    O O O";
    assertEquals(test6, model6.toString());


    EuropeanSolitaireModel testBoard7 = new EuropeanSolitaireModel(3, 5, 5);
    MarbleSolitaireView model7 = new MarbleSolitaireTextView(testBoard7);
    String test7 = "" +
            "    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O _\n" +
            "    O O O";
    assertEquals(test7, model7.toString());


  }

  @Test
  public void testConstructorExceptions0() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(6, 5);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (6, 5)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(-1, 3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-1, 3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions1() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(1, -3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (1, -3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions2() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(-1, -3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-1, -3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions3() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(100, 3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (100, 3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions4() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(4, 100);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (4, 100)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions5() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(7, 7);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (7, 7)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions6() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid arm thickness")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions7() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(-1);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid arm thickness")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions8() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(2, 2, 2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid arm thickness")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptionsAfterSelfEval() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(-3, 2, 2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid arm thickness")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions9() {

    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(7, 2, 2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (2, 2)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions10() {


    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(7, 30, 8);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (30, 8)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions11() {


    try {
      EuropeanSolitaireModel offBoard = new EuropeanSolitaireModel(7, -1, -1);
      fail();
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-1, -1)")) {
        fail("wrong error message");
      }
    }
  }


  @Test
  public void MoveTest() {

    EuropeanSolitaireModel testBoard1 = new EuropeanSolitaireModel();
    testBoard1.move(1, 3, 3, 3);
    MarbleSolitaireView model1 = new MarbleSolitaireTextView(testBoard1);
    String test1 = "" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test1, model1.toString());


    testBoard1.move(2, 1, 2, 3);
    String test2 = "" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test2, model1.toString());

    testBoard1.move(2, 4, 2, 2);
    String test3 = "" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test3, model1.toString());

    // PlayThough
    testBoard1.move(4, 3, 2, 3);
    testBoard1.move(4, 4, 2, 4);
    testBoard1.move(6, 4, 4, 4);
    testBoard1.move(6, 2, 6, 4);
    testBoard1.move(5, 2, 5, 4);
    testBoard1.move(4, 5, 4, 3);
    testBoard1.move(6, 4, 4, 4);
    testBoard1.move(4, 3, 4, 5);
    testBoard1.move(4, 6, 4, 4);

    testBoard1.move(4, 1, 4, 3);

    testBoard1.move(4, 4, 4, 2);
    testBoard1.move(3, 2, 5, 2);
    testBoard1.move(2, 3, 2, 1);
    testBoard1.move(2, 0, 2, 2);

    testBoard1.move(1, 2, 3, 2);

    testBoard1.move(3, 1, 3, 3);
    testBoard1.move(4, 0, 2, 0);
    testBoard1.move(2, 5, 2, 3);
    testBoard1.move(3, 6, 3, 4);
    testBoard1.move(0, 4, 2, 4);
    testBoard1.move(0, 2, 0, 4);
    testBoard1.move(3, 4, 1, 4);
    testBoard1.move(0, 4, 2, 4);
    testBoard1.move(2, 3, 2, 5);
    testBoard1.move(2, 6, 2, 4);
    testBoard1.move(5, 1, 5, 3);
    String testGameOver = "" +
            "    _ _ _\n" +
            "  O _ _ _ O\n" +
            "O _ _ _ O _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  _ _ O _ O\n" +
            "    _ _ _";
    assertEquals(testGameOver, model1.toString());

  }


  @Test
  public void TestExceptionMove() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel(1);
    try {
      testBoard.move(1, 0, 1, 2);
      fail("testBoard.move(1,0,1, 2) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }

  }

  @Test
  public void TestExceptionMove2() {
    EuropeanSolitaireModel testBoard2 = new EuropeanSolitaireModel();
    try {
      testBoard2.move(1, 3, 3, 4);
      fail("testBoard.move(1,3,3, 4) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove3() {
    EuropeanSolitaireModel testBoard2 = new EuropeanSolitaireModel();
    try {
      testBoard2.move(1, 1, 1, 1);
      fail("testBoard.move(1,1,1, 1) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }


  @Test
  public void TestExceptionMove4() {
    EuropeanSolitaireModel testBoard2 = new EuropeanSolitaireModel();
    try {
      testBoard2.move(3, 3, 5, 3);
      fail("testBoard.move(3,3,5, 3) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove5() {
    EuropeanSolitaireModel testBoard2 = new EuropeanSolitaireModel();
    try {
      testBoard2.move(0, 0, 0, -2);
      fail("testBoard.move(0, 0, 0, -2) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove6() {
    EuropeanSolitaireModel testBoard2 = new EuropeanSolitaireModel(7, 10, 10);
    try {
      testBoard2.move(5, 10, 10, 10);
      fail("testBoard.move(5, 10,10,10) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove7() {
    EuropeanSolitaireModel testBoard2 = new EuropeanSolitaireModel(5);
    try {
      testBoard2.move(4, 4, 6, 6);
      fail("testBoard.move(5, 10,10,10) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void getBoardSizeTest() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel(1);
    assertEquals(3, testBoard.getBoardSize());

    EuropeanSolitaireModel testBoard1 = new EuropeanSolitaireModel();
    assertEquals(7, testBoard1.getBoardSize());


    EuropeanSolitaireModel testBoard2 = new EuropeanSolitaireModel(1, 1);
    assertEquals(7, testBoard2.getBoardSize());

    EuropeanSolitaireModel testBoard3 = new EuropeanSolitaireModel(5);
    EuropeanSolitaireModel testBoard4 = new EuropeanSolitaireModel(7);
    assertEquals(13, testBoard3.getBoardSize());
    assertEquals(19, testBoard4.getBoardSize());

    EuropeanSolitaireModel testBoard5 = new EuropeanSolitaireModel(5, 7, 5);
    EuropeanSolitaireModel testBoard6 = new EuropeanSolitaireModel(7);
    assertEquals(13, testBoard5.getBoardSize());
    assertEquals(19, testBoard6.getBoardSize());

  }

  @Test
  public void getScoreTest() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel();
    assertEquals(36, testBoard.getScore());

    testBoard.move(1, 3, 3, 3);
    testBoard.move(2, 1, 2, 3);
    assertEquals(34, testBoard.getScore());

    EuropeanSolitaireModel testBoard2 = new EuropeanSolitaireModel(3, 3);
    assertEquals(36, testBoard2.getScore());

    EuropeanSolitaireModel testBoard5 = new EuropeanSolitaireModel(5);
    assertEquals(128, testBoard5.getScore());

    EuropeanSolitaireModel testBoard3 = new EuropeanSolitaireModel(5, 5, 5);
    assertEquals(128, testBoard3.getScore());
    EuropeanSolitaireModel testBoard4 = new EuropeanSolitaireModel(7, 9, 9);
    assertEquals(276, testBoard4.getScore());

    EuropeanSolitaireModel testBoard6 = new EuropeanSolitaireModel(1);
    assertEquals(4, testBoard6.getScore());

    EuropeanSolitaireModel testBoard1 = new EuropeanSolitaireModel();
    testBoard1.move(1, 3, 3, 3);
    MarbleSolitaireView model1 = new MarbleSolitaireTextView(testBoard1);
    String test1 = "" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test1, model1.toString());
    assertEquals(35, testBoard1.getScore());


    testBoard1.move(2, 1, 2, 3);
    String test2 = "" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test2, model1.toString());

    testBoard1.move(2, 4, 2, 2);
    String test3 = "" +
            "    O O O\n" +
            "  O O _ O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O";
    assertEquals(test3, model1.toString());

    // PlayThough
    testBoard1.move(4, 3, 2, 3);
    testBoard1.move(4, 4, 2, 4);
    testBoard1.move(6, 4, 4, 4);
    testBoard1.move(6, 2, 6, 4);
    testBoard1.move(5, 2, 5, 4);
    testBoard1.move(4, 5, 4, 3);
    testBoard1.move(6, 4, 4, 4);
    testBoard1.move(4, 3, 4, 5);
    testBoard1.move(4, 6, 4, 4);

    testBoard1.move(4, 1, 4, 3);

    testBoard1.move(4, 4, 4, 2);
    testBoard1.move(3, 2, 5, 2);
    testBoard1.move(2, 3, 2, 1);
    testBoard1.move(2, 0, 2, 2);
    assertEquals(19, testBoard1.getScore());

    testBoard1.move(1, 2, 3, 2);

    testBoard1.move(3, 1, 3, 3);
    testBoard1.move(4, 0, 2, 0);
    testBoard1.move(2, 5, 2, 3);
    testBoard1.move(3, 6, 3, 4);
    testBoard1.move(0, 4, 2, 4);
    testBoard1.move(0, 2, 0, 4);
    testBoard1.move(3, 4, 1, 4);
    testBoard1.move(0, 4, 2, 4);
    testBoard1.move(2, 3, 2, 5);
    testBoard1.move(2, 6, 2, 4);
    testBoard1.move(5, 1, 5, 3);
    String testGameOver = "" +
            "    _ _ _\n" +
            "  O _ _ _ O\n" +
            "O _ _ _ O _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  _ _ O _ O\n" +
            "    _ _ _";
    assertEquals(testGameOver, model1.toString());
    assertEquals(7, testBoard1.getScore());
  }


  @Test
  public void IsGameOverTest() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel(3);
    assertFalse(testBoard.isGameOver());


    // Play though game until no more moves are valid
    EuropeanSolitaireModel testBoard1 = new EuropeanSolitaireModel();
    MarbleSolitaireView model1 = new MarbleSolitaireTextView(testBoard1);


    testBoard1.move(1, 3, 3, 3);
    testBoard1.move(2, 1, 2, 3);
    testBoard1.move(2, 4, 2, 2);
    testBoard1.move(4, 3, 2, 3);
    testBoard1.move(4, 4, 2, 4);
    testBoard1.move(6, 4, 4, 4);
    testBoard1.move(6, 2, 6, 4);
    testBoard1.move(5, 2, 5, 4);
    testBoard1.move(4, 5, 4, 3);
    testBoard1.move(6, 4, 4, 4);
    testBoard1.move(4, 3, 4, 5);
    assertFalse(testBoard1.isGameOver());
    testBoard1.move(4, 6, 4, 4);
    testBoard1.move(4, 1, 4, 3);
    testBoard1.move(4, 4, 4, 2);
    testBoard1.move(3, 2, 5, 2);
    testBoard1.move(2, 3, 2, 1);
    testBoard1.move(2, 0, 2, 2);
    testBoard1.move(1, 2, 3, 2);
    testBoard1.move(3, 1, 3, 3);
    testBoard1.move(4, 0, 2, 0);
    testBoard1.move(2, 5, 2, 3);
    testBoard1.move(3, 6, 3, 4);
    testBoard1.move(0, 4, 2, 4);
    testBoard1.move(0, 2, 0, 4);
    testBoard1.move(3, 4, 1, 4);
    testBoard1.move(0, 4, 2, 4);
    testBoard1.move(2, 3, 2, 5);
    testBoard1.move(2, 6, 2, 4);
    testBoard1.move(5, 1, 5, 3);
    String testGameOver = "" +
            "    _ _ _\n" +
            "  O _ _ _ O\n" +
            "O _ _ _ O _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "  _ _ O _ O\n" +
            "    _ _ _";
    assertEquals(testGameOver, model1.toString());

    assertTrue(testBoard1.isGameOver());

    EuropeanSolitaireModel armThickness1 = new EuropeanSolitaireModel(1);
    assertTrue(armThickness1.isGameOver());


  }


  @Test
  public void getSlotAtTest() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard.getSlotAt(0, 3));

    EuropeanSolitaireModel testBoard2 = new EuropeanSolitaireModel(3, 4);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard2.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard2.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard2.getSlotAt(5, 5));


    EuropeanSolitaireModel testBoard3 = new EuropeanSolitaireModel(7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard3.getSlotAt(9, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard3.getSlotAt(1, 13));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard3.getSlotAt(1, 14));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard3.getSlotAt(6, 7));

    EuropeanSolitaireModel testBoard4 = new EuropeanSolitaireModel(5, 0, 4);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard4.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard4.getSlotAt(0, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard4.getSlotAt(5, 6));

  }

  @Test
  public void TestExceptionGetSlotAt() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel(5);
    try {
      testBoard.getSlotAt(0, -1);
      fail("testBoard.move(0, -1) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }


  @Test
  public void TestExceptionGetSlotAt2() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel(5);
    try {
      testBoard.getSlotAt(-1, 0);
      fail("testBoard.move(-1, 0) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

  @Test
  public void TestExceptionGetSlotAt3() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel(5);
    try {
      testBoard.getSlotAt(13, 9);
      fail("testBoard.move(13, 9) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

  @Test
  public void TestExceptionGetSlotAt4() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel(5);
    try {
      testBoard.getSlotAt(8, 100);
      fail("testBoard.move(8, 100) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

  @Test
  public void TestExceptionGetSlotAt5() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel(5);
    try {
      testBoard.getSlotAt(-1, 100);
      fail("testBoard.move(13, 9) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }


  @Test
  public void TestExceptionGetSlotAt7() {
    EuropeanSolitaireModel testBoard = new EuropeanSolitaireModel();
    try {
      testBoard.getSlotAt(0, 55);
      fail("testBoard.move(13, 9) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

}

