package com.example.practicecode;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Sprint2Test {
    private TicTacToeGame ticTacToe;
    @Before
    public void setUp() {
        ticTacToe = new TicTacToeGame();
    }
    @Test
    public void topRowTest() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.getBoxes().put("Top Left", "X");
        ticTacToe.getBoxes().put("Top Center", "X");
        ticTacToe.getBoxes().put("Top Right", "X");
        assertTrue(ticTacToe.checkWinningState());
    }
    @Test
    public void midRowTest() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.getBoxes().put("Middle Left", "O");
        ticTacToe.getBoxes().put("Middle Center", "O");
        ticTacToe.getBoxes().put("Middle Right", "O");
        assertTrue(ticTacToe.checkWinningState());
    }
    @Test
    public void bottomRowTest() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.getBoxes().put("Bottom Left", "X");
        ticTacToe.getBoxes().put("Bottom Center", "X");
        ticTacToe.getBoxes().put("Bottom Right", "X");
        assertTrue(ticTacToe.checkWinningState());
    }
    @Test
    public void firstColumnTest() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.getBoxes().put("Top Left", "X");
        ticTacToe.getBoxes().put("Middle Left", "X");
        ticTacToe.getBoxes().put("Bottom Left", "X");
        assertTrue(ticTacToe.checkWinningState());
    }
    @Test
    public void secondColumnTest() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.getBoxes().put("Top Center", "X");
        ticTacToe.getBoxes().put("Middle Center", "X");
        ticTacToe.getBoxes().put("Bottom Center", "X");
        assertTrue(ticTacToe.checkWinningState());
    }
    @Test
    public void thirdColumnTest() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.getBoxes().put("Top Right", "X");
        ticTacToe.getBoxes().put("Middle Right", "X");
        ticTacToe.getBoxes().put("Bottom Right", "X");
        assertTrue(ticTacToe.checkWinningState());
    }
    @Test
    public void topLeftToBottomRightTest() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.getBoxes().put("Top Left", "X");
        ticTacToe.getBoxes().put("Middle Center", "X");
        ticTacToe.getBoxes().put("Bottom Right", "X");
        assertTrue(ticTacToe.checkWinningState());
    }
    @Test
    public void topRightToBottomLeftTest() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.getBoxes().put("Top Right", "X");
        ticTacToe.getBoxes().put("Middle Center", "X");
        ticTacToe.getBoxes().put("Bottom Left", "X");
        assertTrue(ticTacToe.checkWinningState());
    }
    @Test
    public void testNonWinningState() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.getBoxes().put("Top Left", "X");
        ticTacToe.getBoxes().put("Top Center", "O");
        ticTacToe.getBoxes().put("Top Right", "X");
        assertFalse(ticTacToe.checkWinningState());
    }
    @Test
    public void scoreIsTied() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.makeMove("Top Center"); // X
        ticTacToe.makeMove("Top Left"); // O
        ticTacToe.makeMove("Middle Left"); // X
        ticTacToe.makeMove("Top Right"); // O
        ticTacToe.makeMove("Middle Center"); // X
        ticTacToe.makeMove("Middle Right"); // 0
        ticTacToe.makeMove("Bottom Left"); // X
        ticTacToe.makeMove("Bottom Center"); // 0
        ticTacToe.makeMove("Bottom Right"); // X
        assertTrue(ticTacToe.isTied());
    }
    @Test
    public void scoreIsTied2() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.makeMove("Top Right"); // X
        ticTacToe.makeMove("Top Left"); // O
        ticTacToe.makeMove("Middle Center"); // X
        ticTacToe.makeMove("Top Center"); // O
        ticTacToe.makeMove("Middle Left"); // X
        ticTacToe.makeMove("Middle Right"); // 0
        ticTacToe.makeMove("Bottom Center"); // X
        ticTacToe.makeMove("Bottom Left"); // 0
        ticTacToe.makeMove("Bottom Right"); // X
        assertTrue(ticTacToe.isTied());
    }
    @Test
    public void scoreIsTied3() {
        ticTacToe.gameReset(); // Reset the game
        ticTacToe.makeMove("Top Left"); // X
        ticTacToe.makeMove("Middle Center"); // O
        ticTacToe.makeMove("Middle Left"); // X
        ticTacToe.makeMove("Bottom Left"); // O
        ticTacToe.makeMove("Top Right"); // X
        ticTacToe.makeMove("Top Center"); // 0
        ticTacToe.makeMove("Bottom Center"); // X
        ticTacToe.makeMove("Middle Right"); // 0
        ticTacToe.makeMove("Bottom Right"); // X
        assertTrue(ticTacToe.isTied());
    }
}