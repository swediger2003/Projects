import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Test class for English Marble Solitaire Game.
 */
public class TestMarbleSolitaire {


  @Test
  public void ViewTest() {
    MarbleSolitaireModel testBoard1 = new EnglishSolitaireModel();
    MarbleSolitaireView model1 = new MarbleSolitaireTextView(testBoard1);
    String test1 = "    O O O\n    O O O\nO O O O O O O\nO O O _ O O O\nO O O O O O O\n    O O O\n"
            + "  " + "  O O O";
    assertEquals(test1, model1.toString());

    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel(0, 3);
    MarbleSolitaireView model2 = new MarbleSolitaireTextView(testBoard2);
    String test2 = "    O _ O\n    O O O\nO O O O O O O\nO O O O O O O\nO O O O O O O\n    O O O"
            + "\n " + "   O O O";
    assertEquals(test2, model2.toString());

    EnglishSolitaireModel testBoard3 = new EnglishSolitaireModel(1);
    MarbleSolitaireView model3 = new MarbleSolitaireTextView(testBoard3);
    String test3 = "  O\nO _ O\n  O";
    assertEquals(test3, model3.toString());

    EnglishSolitaireModel testBoard4 = new EnglishSolitaireModel(3, 0, 2);
    MarbleSolitaireView model4 = new MarbleSolitaireTextView(testBoard4);
    String test4 = "    _ O O\n    O O O\nO O O O O O O\nO O O O O O O\nO O O O O O O\n    " +
            "O O O\n" + "    O O O";
    assertEquals(test4, model4.toString());


  }

  @Test
  public void testConstructorExceptions0() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(5, 5);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (5, 5)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(-1, 3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-1, 3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions1() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(1, -3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (1, -3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions2() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(-1, -3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-1, -3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions3() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(100, 3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (100, 3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions4() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(4, 100);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (4, 100)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions5() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(7, 7);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (7, 7)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions6() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid arm thickness")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions7() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(-1);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid arm thickness")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions8() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(2, 2, 2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid arm thickness")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptionsAfterSelfEval() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(-3, 2, 2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid arm thickness")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions9() {

    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(7, 2, 2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (2, 2)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions10() {


    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(7, 30, 8);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (30, 8)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions11() {


    try {
      EnglishSolitaireModel offBoard = new EnglishSolitaireModel(7, -1, -1);
      fail();
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-1, -1)")) {
        fail("wrong error message");
      }
    }
  }


  @Test
  public void MoveTest() {

    EnglishSolitaireModel testBoard1 = new EnglishSolitaireModel();
    testBoard1.move(1, 3, 3, 3);
    MarbleSolitaireView model1 = new MarbleSolitaireTextView(testBoard1);
    String test1 = "    O O O\n    O _ O\nO O O _ O O O\nO O O O O O O\nO O O O O O O\n  "
            + "  O O O\n    O O O";
    assertEquals(test1, model1.toString());


    testBoard1.move(2, 1, 2, 3);
    String test2 = "    O O O\n    O _ O\nO _ _ O O O O\nO O O O O O O\nO O O O O O O\n "
            + "   O O O\n    O O O";
    assertEquals(test2, model1.toString());

    testBoard1.move(2, 4, 2, 2);
    String test3 = "    O O O\n    O _ O\nO _ O _ _ O O\nO O O O O O O\nO O O O O O O\n"
            + "    O O O\n    O O O";
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
    //assertEquals(test4, model1.toString());
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
    String testGameOver = "    _ _ _\n    _ _ _\nO _ _ _ O _ _\n_ _ _ O _ _ _\n_ _ _ _ _ _ _\n    "
            + "O _ _\n    _ _ _";
    assertEquals(testGameOver, model1.toString());

  }


  @Test
  public void TestExceptionMove() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel(1);
    try {
      testBoard.move(1, 0, 1, 2);
      fail("testBoard.move(1,0,1, 2) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }

  }

  @Test
  public void TestExceptionMove2() {
    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel();
    try {
      testBoard2.move(1, 3, 3, 4);
      fail("testBoard.move(1,3,3, 4) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove3() {
    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel();
    try {
      testBoard2.move(1, 1, 1, 1);
      fail("testBoard.move(1,1,1, 1) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }


  @Test
  public void TestExceptionMove4() {
    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel();
    try {
      testBoard2.move(3, 3, 5, 3);
      fail("testBoard.move(3,3,5, 3) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove5() {
    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel();
    try {
      testBoard2.move(0, 0, 0, -2);
      fail("testBoard.move(0, 0, 0, -2) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove6() {
    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel(7, 10, 10);
    try {
      testBoard2.move(5, 10, 10, 10);
      fail("testBoard.move(5, 10,10,10) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove7() {
    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel(5);
    try {
      testBoard2.move(4, 4, 6, 6);
      fail("testBoard.move(5, 10,10,10) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void getBoardSizeTest() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel(1);
    assertEquals(3, testBoard.getBoardSize());

    EnglishSolitaireModel testBoard1 = new EnglishSolitaireModel();
    assertEquals(7, testBoard1.getBoardSize());


    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel(3, 3);
    assertEquals(7, testBoard2.getBoardSize());

    EnglishSolitaireModel testBoard3 = new EnglishSolitaireModel(5);
    EnglishSolitaireModel testBoard4 = new EnglishSolitaireModel(7);
    assertEquals(13, testBoard3.getBoardSize());
    assertEquals(19, testBoard4.getBoardSize());

    EnglishSolitaireModel testBoard5 = new EnglishSolitaireModel(5, 7, 5);
    EnglishSolitaireModel testBoard6 = new EnglishSolitaireModel(7);
    assertEquals(13, testBoard5.getBoardSize());
    assertEquals(19, testBoard6.getBoardSize());

  }

  @Test
  public void getScoreTest() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel();
    assertEquals(32, testBoard.getScore());

    testBoard.move(1, 3, 3, 3);
    testBoard.move(2, 1, 2, 3);
    assertEquals(30, testBoard.getScore());

    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel(3, 3);
    assertEquals(32, testBoard2.getScore());

    EnglishSolitaireModel testBoard5 = new EnglishSolitaireModel(5);
    assertEquals(104, testBoard5.getScore());

    EnglishSolitaireModel testBoard3 = new EnglishSolitaireModel(5, 5, 5);
    assertEquals(104, testBoard3.getScore());
    EnglishSolitaireModel testBoard4 = new EnglishSolitaireModel(7, 9, 9);
    assertEquals(216, testBoard4.getScore());

    EnglishSolitaireModel testBoard6 = new EnglishSolitaireModel(1);
    assertEquals(4, testBoard6.getScore());

    EnglishSolitaireModel testBoard1 = new EnglishSolitaireModel();
    assertEquals(32, testBoard1.getScore());
    // Play-through
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
    testBoard1.move(4, 6, 4, 4);
    assertEquals(20, testBoard1.getScore());
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

    assertEquals(4, testBoard1.getScore());

  }


  @Test
  public void IsGameOverTest() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel(3);
    assertFalse(testBoard.isGameOver());


    // Play though game until no more moves are valid
    EnglishSolitaireModel testBoard1 = new EnglishSolitaireModel();
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
    String testGameOver = "    _ _ _\n    _ _ _\nO _ _ _ O _ _\n_ _ _ O _ _ _\n_ _ _ _ _ _ _\n"
            + "    O _ _\n    _ _ _";
    assertEquals(testGameOver, model1.toString());

    assertTrue(testBoard1.isGameOver());

    EnglishSolitaireModel armThickness1 = new EnglishSolitaireModel(1);
    assertTrue(armThickness1.isGameOver());


  }


  @Test
  public void getSlotAtTest() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard.getSlotAt(0, 3));

    EnglishSolitaireModel testBoard2 = new EnglishSolitaireModel(3, 4);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard2.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard2.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard2.getSlotAt(3, 3));


    EnglishSolitaireModel testBoard3 = new EnglishSolitaireModel(7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard3.getSlotAt(9, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard3.getSlotAt(1, 13));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard3.getSlotAt(6, 7));

    EnglishSolitaireModel testBoard4 = new EnglishSolitaireModel(5, 0, 4);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard4.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard4.getSlotAt(0, 10));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard4.getSlotAt(5, 6));

  }

  @Test
  public void TestExceptionGetSlotAt() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel(5);
    try {
      testBoard.getSlotAt(0, -1);
      fail("testBoard.move(0, -1) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }


  @Test
  public void TestExceptionGetSlotAt2() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel(5);
    try {
      testBoard.getSlotAt(-1, 0);
      fail("testBoard.move(-1, 0) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

  @Test
  public void TestExceptionGetSlotAt3() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel(5);
    try {
      testBoard.getSlotAt(13, 9);
      fail("testBoard.move(13, 9) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

  @Test
  public void TestExceptionGetSlotAt4() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel(5);
    try {
      testBoard.getSlotAt(8, 100);
      fail("testBoard.move(8, 100) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

  @Test
  public void TestExceptionGetSlotAt5() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel(5);
    try {
      testBoard.getSlotAt(-1, 100);
      fail("testBoard.move(13, 9) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }


  @Test
  public void TestExceptionGetSlotAt7() {
    EnglishSolitaireModel testBoard = new EnglishSolitaireModel();
    try {
      testBoard.getSlotAt(0, 55);
      fail("testBoard.move(13, 9) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

}
