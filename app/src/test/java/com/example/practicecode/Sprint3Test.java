package com.example.practicecode;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Sprint3Test extends BlackJackLogic {
    private BlackJackLogic game;

    @Before
    public void setUp() {
        game = new BlackJackLogic();
        game.startNewGame();
    }

    @Test
    public void testStartNewGame() {
        assertNotNull(game.getPlayerHand());
        assertNotNull(game.getDealerHand());
        assertEquals(0, game.getBustCount());
        assertEquals(2, game.getPlayerHand().size());
        assertEquals(1, game.getDealerHand().size());
    }

    @Test
    public void testHit() {
        int initialPlayerScore = game.getPlayerScore();
        int initialPlayerHandSize = game.getPlayerHand().size();
        game.hit();
        assertTrue(game.getPlayerScore() > initialPlayerScore);
        assertEquals(initialPlayerHandSize + 1, game.getPlayerHand().size());
    }

    @Test
    public void testDealCardToDealer() {
        int initialDealerScore = game.getDealerScore();
        int initialDealerHandSize = game.getDealerHand().size();
        game.dealCardToDealer();
        assertTrue(game.getDealerScore() > initialDealerScore);
        assertEquals(initialDealerHandSize + 1, game.getDealerHand().size());
    }

    @Test
    public void testIsPlayerBusted() {
        assertFalse(game.isPlayerBusted());
        game.startNewGame();
        game.getPlayerHand().clear();
        game.setPlayerScore(0);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(2);
        game.addToPlayerScore(22);
        assertTrue(game.isPlayerBusted());
    }

    @Test
    public void testIsDealerBusted() {
        game.startNewGame();
        game.getDealerHand().clear();
        game.setDealerScore(0);
        game.getDealerHand().add(10);
        game.getDealerHand().add(10);
        game.getDealerHand().add(2);
        game.addToDealerScore(22);
        assertTrue(game.isDealerBusted());
    }

    @Test
    public void testIsPlayerWin() {
        game.startNewGame();
        game.getPlayerHand().clear();
        game.setPlayerScore(0);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(10);
        game.addToPlayerScore(20);
        game.getDealerHand().clear();
        game.setDealerScore(0);
        game.getDealerHand().add(9);
        game.addToDealerScore(9);
        assertTrue(game.isPlayerWin());
    }

    @Test
    public void testIsDealerWin() {
        game.startNewGame();
        game.getPlayerHand().clear();
        game.setPlayerScore(0);
        game.setDealerScore(0);
        game.getPlayerHand().add(10);
        game.addToPlayerScore(10);
        game.getDealerHand().clear();
        game.getDealerHand().add(10);
        game.getDealerHand().add(10);
        game.addToDealerScore(20);
        assertTrue(game.isDealerWin());
    }

    @Test
    public void testIsTie() {
        game.startNewGame();
        game.getPlayerHand().clear();
        game.getPlayerHand().add(10);
        game.setPlayerScore(0);
        game.setDealerScore(0);
        game.addToPlayerScore(10);
        game.getDealerHand().clear();
        game.getDealerHand().add(10);
        game.getDealerHand().add(10);
        game.addToDealerScore(20);
        assertFalse(game.isTie());
    }
    @Test
    public void testIsGameOver() {
        game.startNewGame();
        game.getPlayerHand().clear();
        game.setPlayerScore(0);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(2);
        game.addToPlayerScore(22);
        game.addToBustCount();
        game.getPlayerHand().clear();
        game.setPlayerScore(0);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(2);
        game.addToPlayerScore(22);
        game.addToBustCount();
        game.getPlayerHand().clear();
        game.setPlayerScore(0);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(2);
        game.addToPlayerScore(22);
        game.addToBustCount();
        assertTrue(game.isGameOver());
    }


    @Test
    public void testIsBlackJackCorrect() {
        game.startNewGame();
        game.getPlayerHand().clear();
        game.setPlayerScore(0);
        game.getPlayerHand().add(2);
        game.getPlayerHand().add(10);
        game.getPlayerHand().add(10);
        game.addToPlayerScore(22);
        assertFalse(game.isBlackjack());
    }

    @Test
    public void testIsEndScreenDealerWin() {
        game.startNewGame();
        game.getPlayerHand().clear();
        game.setPlayerScore(0);
        game.setDealerScore(0);
        game.getPlayerHand().add(10);
        game.addToPlayerScore(10);
        game.getDealerHand().clear();
        game.getDealerHand().add(10);
        game.getDealerHand().add(10);
        game.addToDealerScore(20);
        assertTrue(game.isEndGame());
    }
    @Test
    public void testIsEndScreenTie() {
        game.startNewGame();
        game.getPlayerHand().clear();
        game.getPlayerHand().add(10);
        game.setPlayerScore(0);
        game.setDealerScore(0);
        game.addToPlayerScore(10);
        game.getDealerHand().clear();
        game.getDealerHand().add(10);
        game.addToDealerScore(10);
        assertFalse(game.isEndGame());
    }
}


