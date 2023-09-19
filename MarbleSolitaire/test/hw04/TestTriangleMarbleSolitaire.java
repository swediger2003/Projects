package hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Test class for Marble Solitaire Game with Triangle model.
 */
public class TestTriangleMarbleSolitaire {


  @Test
  public void ViewTest() {
    MarbleSolitaireModel testBoard1 = new TriangleSolitaireModel(6);
    MarbleSolitaireView model1 = new TriangleSolitaireTextView(testBoard1);
    String test1 = "" +
            "     _\n" +
            "    O O\n" +
            "   O O O\n" +
            "  O O O O\n" +
            " O O O O O\n" +
            "O O O O O O";
    assertEquals(test1, model1.toString());


    TriangleSolitaireModel testBoard2 = new TriangleSolitaireModel(3, 3);
    MarbleSolitaireView model2 = new TriangleSolitaireTextView(testBoard2);
    String test2 = "" +
            "    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O O";
    assertEquals(test2, model2.toString());

    TriangleSolitaireModel testBoard3 = new TriangleSolitaireModel(1);
    MarbleSolitaireView model3 = new TriangleSolitaireTextView(testBoard3);
    String test3 = "_";
    assertEquals(test3, model3.toString());

    TriangleSolitaireModel testBoard4 = new TriangleSolitaireModel(3, 1, 1);
    MarbleSolitaireView model4 = new TriangleSolitaireTextView(testBoard4);
    String test4 = "" +
            "  O\n" +
            " O _\n" +
            "O O O";
    assertEquals(test4, model4.toString());

    TriangleSolitaireModel testBoard5 = new TriangleSolitaireModel(3, 2, 0);
    MarbleSolitaireView model5 = new TriangleSolitaireTextView(testBoard5);
    String test5 = "" +
            "  O\n" +
            " O O\n" +
            "_ O O";
    assertEquals(test5, model5.toString());


    TriangleSolitaireModel testBoard6 = new TriangleSolitaireModel(10, 5, 1);
    MarbleSolitaireView model6 = new TriangleSolitaireTextView(testBoard6);
    String test6 = "" +
            "         O\n" +
            "        O O\n" +
            "       O O O\n" +
            "      O O O O\n" +
            "     O O O O O\n" +
            "    O _ O O O O\n" +
            "   O O O O O O O\n" +
            "  O O O O O O O O\n" +
            " O O O O O O O O O\n" +
            "O O O O O O O O O O";
    assertEquals(test6, model6.toString());


    TriangleSolitaireModel testBoard7 = new TriangleSolitaireModel(6, 5, 3);
    MarbleSolitaireView model7 = new TriangleSolitaireTextView(testBoard7);
    String test7 = "" +
            "     O\n" +
            "    O O\n" +
            "   O O O\n" +
            "  O O O O\n" +
            " O O O O O\n" +
            "O O O _ O O";
    assertEquals(test7, model7.toString());


  }

  @Test
  public void testConstructorExceptions0() {

    try {
      MarbleSolitaireModel offBoard = new TriangleSolitaireModel(6, 5);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (6, 5)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(-1, 3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-1, 3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions1() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(1, -3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (1, -3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions2() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(-1, -3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-1, -3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions3() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(100, 3);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (100, 3)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions4() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(4, 100);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (4, 100)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions5() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(7, 7);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (7, 7)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions6() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(-2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Dimension of triangle not positive")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions7() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(-1);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Dimension of triangle not positive")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions8() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(-3, 2, 2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Dimension of triangle not positive")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptionsAfterSelfEval() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(5, 8, 2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (8, 2)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions9() {

    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(7, -2, 2);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-2, 2)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions10() {


    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(100, 30, 8);
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (30, 8)")) {
        fail("wrong error message");
      }
    }
  }

  @Test
  public void testConstructorExceptions11() {


    try {
      TriangleSolitaireModel offBoard = new TriangleSolitaireModel(7, -1, -1);
      fail();
    } catch (IllegalArgumentException e) {

      if (!e.getMessage().equals("Invalid empty cell position (-1, -1)")) {
        fail("wrong error message");
      }
    }
  }


  @Test
  public void MoveTest() {

    MarbleSolitaireModel testBoard1 = new TriangleSolitaireModel();
    MarbleSolitaireView model1 = new TriangleSolitaireTextView(testBoard1);
    testBoard1.move(2, 2, 0, 0);

    String test1 = "" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O";
    assertEquals(test1, model1.toString());


    testBoard1.move(4, 2, 2, 2);
    String test2 = "" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "O O _ O O";
    assertEquals(test2, model1.toString());

    testBoard1.move(4, 0, 4, 2);
    String test3 = "" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "_ _ O O O";
    assertEquals(test3, model1.toString());

    // PlayThough
    testBoard1.move(3, 0, 3, 2);
    testBoard1.move(3, 3, 3, 1);
    testBoard1.move(2, 1, 4, 1);
    testBoard1.move(1, 0, 3, 0);
    testBoard1.move(4, 2, 4, 0);
    testBoard1.move(4, 4, 4, 2);
    testBoard1.move(4, 0, 2, 0);


    String testGameOver = "" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " _ _ _ _\n" +
            "_ _ O _ _";
    assertEquals(testGameOver, model1.toString());

  }


  @Test
  public void TestExceptionMove() {
    TriangleSolitaireModel testBoard = new TriangleSolitaireModel(1);
    try {
      testBoard.move(1, 0, 1, 2);
      fail("testBoard.move(1,0,1, 2) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }

  }

  @Test
  public void TestExceptionMove2() {
    TriangleSolitaireModel testBoard2 = new TriangleSolitaireModel();
    try {
      testBoard2.move(1, 1, 3, 2);
      fail("testBoard.move(1,3,3, 4) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove3() {
    TriangleSolitaireModel testBoard2 = new TriangleSolitaireModel();
    try {
      testBoard2.move(1, 1, 1, 1);
      fail("testBoard.move(1,1,1, 1) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }


  @Test
  public void TestExceptionMove4() {
    TriangleSolitaireModel testBoard2 = new TriangleSolitaireModel(7, 4, 3);
    try {
      testBoard2.move(3, 3, 5, 3);
      fail("testBoard.move(3,3,5, 3) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove5() {
    TriangleSolitaireModel testBoard2 = new TriangleSolitaireModel();
    try {
      testBoard2.move(0, 0, 0, -2);
      fail("testBoard.move(0, 0, 0, -2) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove6() {
    TriangleSolitaireModel testBoard2 = new TriangleSolitaireModel(11, 10, 10);
    try {
      testBoard2.move(5, 10, 10, 10);
      fail("testBoard.move(5, 10,10,10) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void TestExceptionMove7() {
    TriangleSolitaireModel testBoard2 = new TriangleSolitaireModel(10);
    try {
      testBoard2.move(4, 4, 6, 6);
      fail("testBoard.move(5, 10,10,10) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("This move is invalid", re.getMessage());
    }
  }

  @Test
  public void getBoardSizeTest() {
    TriangleSolitaireModel testBoard = new TriangleSolitaireModel(1);
    assertEquals(1, testBoard.getBoardSize());

    TriangleSolitaireModel testBoard1 = new TriangleSolitaireModel();
    assertEquals(5, testBoard1.getBoardSize());


    TriangleSolitaireModel testBoard2 = new TriangleSolitaireModel(1, 1);
    assertEquals(5, testBoard2.getBoardSize());

    TriangleSolitaireModel testBoard3 = new TriangleSolitaireModel(5);
    TriangleSolitaireModel testBoard4 = new TriangleSolitaireModel(7);
    assertEquals(5, testBoard3.getBoardSize());
    assertEquals(7, testBoard4.getBoardSize());

    TriangleSolitaireModel testBoard5 = new TriangleSolitaireModel(100, 7, 5);
    TriangleSolitaireModel testBoard6 = new TriangleSolitaireModel(2);
    assertEquals(100, testBoard5.getBoardSize());
    assertEquals(2, testBoard6.getBoardSize());

  }

  @Test
  public void getScoreTest() {
    MarbleSolitaireModel testBoard1 = new TriangleSolitaireModel();
    MarbleSolitaireView model1 = new TriangleSolitaireTextView(testBoard1);
    assertEquals(14, testBoard1.getScore());
    testBoard1.move(2, 2, 0, 0);
    assertEquals(13, testBoard1.getScore());
    testBoard1.move(4, 2, 2, 2);

    String test2 = "" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "O O _ O O";
    assertEquals(test2, model1.toString());
    assertEquals(12, testBoard1.getScore());

    testBoard1.move(4, 0, 4, 2);
    String test3 = "" +
            "    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "_ _ O O O";
    assertEquals(test3, model1.toString());
    assertEquals(11, testBoard1.getScore());
    // PlayThough
    testBoard1.move(3, 0, 3, 2);
    testBoard1.move(3, 3, 3, 1);
    testBoard1.move(2, 1, 4, 1);
    testBoard1.move(1, 0, 3, 0);
    testBoard1.move(4, 2, 4, 0);
    testBoard1.move(4, 4, 4, 2);
    testBoard1.move(4, 0, 2, 0);


    String testGameOver = "" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " _ _ _ _\n" +
            "_ _ O _ _";
    assertEquals(testGameOver, model1.toString());
    assertEquals(4, testBoard1.getScore());


    MarbleSolitaireModel testBoard2 = new TriangleSolitaireModel(1);
    assertEquals(0, testBoard2.getScore());

    MarbleSolitaireModel testBoard3 = new TriangleSolitaireModel(7);
    assertEquals(27, testBoard3.getScore());

    MarbleSolitaireModel testBoard4 = new TriangleSolitaireModel(7, 1, 1);
    assertEquals(27, testBoard4.getScore());

    MarbleSolitaireModel testBoard5 = new TriangleSolitaireModel(3, 2, 2);
    assertEquals(5, testBoard5.getScore());

    MarbleSolitaireModel testBoard6 = new TriangleSolitaireModel(4, 2);
    assertEquals(14, testBoard6.getScore());
  }


  @Test
  public void IsGameOverTest() {
    TriangleSolitaireModel board = new TriangleSolitaireModel();
    assertFalse(board.isGameOver());

    TriangleSolitaireModel testBoard = new TriangleSolitaireModel(3);
    assertFalse(testBoard.isGameOver());


    // Play though game until no more moves are valid
    TriangleSolitaireModel testBoard1 = new TriangleSolitaireModel();
    MarbleSolitaireView model1 = new TriangleSolitaireTextView(testBoard1);

    // Playthrough
    testBoard1.move(2, 2, 0, 0);
    testBoard1.move(4, 2, 2, 2);
    testBoard1.move(4, 0, 4, 2);
    testBoard1.move(3, 0, 3, 2);
    testBoard1.move(3, 3, 3, 1);
    testBoard1.move(2, 1, 4, 1);
    testBoard1.move(1, 0, 3, 0);
    testBoard1.move(4, 2, 4, 0);
    testBoard1.move(4, 4, 4, 2);
    testBoard1.move(4, 0, 2, 0);
    String testGameOver = "" +
            "    O\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " _ _ _ _\n" +
            "_ _ O _ _";
    assertEquals(testGameOver, model1.toString());
    assertTrue(testBoard1.isGameOver());


    TriangleSolitaireModel armThickness1 = new TriangleSolitaireModel(1);
    assertTrue(armThickness1.isGameOver());


  }


  @Test
  public void getSlotAtTest() {
    MarbleSolitaireModel testBoard = new TriangleSolitaireModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard.getSlotAt(1, 1));

    MarbleSolitaireModel testBoard2 = new TriangleSolitaireModel(3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard2.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard2.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard2.getSlotAt(4, 0));


    MarbleSolitaireModel testBoard3 = new TriangleSolitaireModel(7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard3.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard3.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard3.getSlotAt(4, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard3.getSlotAt(6, 6));

    MarbleSolitaireModel testBoard4 = new TriangleSolitaireModel(6, 4, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, testBoard4.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, testBoard4.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, testBoard4.getSlotAt(4, 2));

  }

  @Test
  public void TestExceptionGetSlotAt() {
    MarbleSolitaireModel testBoard = new TriangleSolitaireModel(5);
    try {
      testBoard.getSlotAt(0, -1);
      fail("testBoard.move(0, -1) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }


  @Test
  public void TestExceptionGetSlotAt2() {
    MarbleSolitaireModel testBoard = new TriangleSolitaireModel(5);
    try {
      testBoard.getSlotAt(-1, 0);
      fail("testBoard.move(-1, 0) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

  @Test
  public void TestExceptionGetSlotAt3() {
    MarbleSolitaireModel testBoard = new TriangleSolitaireModel(5);
    try {
      testBoard.getSlotAt(13, 9);
      fail("testBoard.move(13, 9) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

  @Test
  public void TestExceptionGetSlotAt4() {
    MarbleSolitaireModel testBoard = new TriangleSolitaireModel(5);
    try {
      testBoard.getSlotAt(8, 100);
      fail("testBoard.move(8, 100) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

  @Test
  public void TestExceptionGetSlotAt5() {
    MarbleSolitaireModel testBoard = new TriangleSolitaireModel(5);
    try {
      testBoard.getSlotAt(-1, 100);
      fail("testBoard.move(13, 9) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }


  @Test
  public void TestExceptionGetSlotAt7() {
    MarbleSolitaireModel testBoard = new TriangleSolitaireModel();
    try {
      testBoard.getSlotAt(0, 55);
      fail("testBoard.move(13, 9) did not throw an exception");
    } catch (RuntimeException re) {
      assertEquals("Off Board", re.getMessage());
    }
  }

}

