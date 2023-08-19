package com.example.practicecode;


import org.junit.Assert;
import org.junit.Test;

public class Sprint4Test {

    @Test
    public void testOnOneToTwoClicked() {
        TowersLogic game = new TowersLogic();
        game.onOneToTwoClicked();
        Assert.assertEquals(1, game.getCount());
    }

    @Test
    public void testOnOneToThreeClicked() {
        TowersLogic game = new TowersLogic();
        game.onOneToThreeClicked();
        Assert.assertEquals(1, game.getCount());
    }

    @Test
    public void testOnTwoToOneClicked() {
        TowersLogic game = new TowersLogic();
        game.onOneToTwoClicked();
        game.onTwoToOneClicked();
        Assert.assertEquals(2, game.getCount());
    }

    @Test
    public void testOnTwoToThreeClicked() {
        TowersLogic game = new TowersLogic();
        game.onOneToTwoClicked();
        game.onTwoToThreeClicked();
        Assert.assertEquals(2, game.getCount());
    }

    @Test
    public void testOnThreeToTwoClicked() {
        TowersLogic game = new TowersLogic();
        game.onOneToThreeClicked();
        game.onThreeToTwoClicked();
        Assert.assertEquals(2, game.getCount());
    }

    @Test
    public void testOnThreeToOneClicked() {
        TowersLogic game = new TowersLogic();
        game.onOneToThreeClicked();
        game.onThreeToOneClicked();
        Assert.assertEquals(2, game.getCount());
    }

    @Test
    public void testMoveBetweenTowers() {
        TowersLogic game = new TowersLogic();
        game.onOneToTwoClicked();
        game.onTwoToThreeClicked();
        game.onThreeToTwoClicked();
        game.onTwoToOneClicked();
        game.onOneToThreeClicked();
        Assert.assertEquals(5, game.getCount());
    }

    @Test
    public void testMoveInvalidDisk() {
        TowersLogic game = new TowersLogic();
        game.onTwoToOneClicked();
        Assert.assertEquals(0, game.getCount());
    }

    @Test
    public void testMoveOnEmptyTower() {
        TowersLogic game = new TowersLogic();
        game.onTwoToThreeClicked();
        Assert.assertEquals(1, game.getCount());
    }

    @Test
    public void testCheckWin() {
        TowersLogic game = new TowersLogic();
        game.onOneToThreeClicked();
        game.onTwoToThreeClicked();
        game.onOneToTwoClicked();
        game.onThreeToOneClicked();
        game.onThreeToTwoClicked();
        game.onOneToThreeClicked();
        Assert.assertEquals(6, game.getCount());
    }

    @Test
    public void testCheckWinWithoutMoves() {
        TowersLogic game = new TowersLogic();
        game.onOneToThreeClicked();
        Assert.assertEquals(1, game.getCount());
    }

    @Test
    public void testMultipleMovesToWin() {
        TowersLogic game = new TowersLogic();
        game.onOneToThreeClicked();
        game.onOneToTwoClicked();
        game.onThreeToTwoClicked();
        game.onOneToThreeClicked();
        game.onTwoToOneClicked();
        game.onTwoToThreeClicked();
        game.onOneToThreeClicked();
        Assert.assertEquals(7, game.getCount());
    }
    @Test
    public void testGameEnds_Win() {
        TowersLogic logic = new TowersLogic();

        logic.onOneToThreeClicked();
        logic.onOneToTwoClicked();
        logic.onThreeToTwoClicked();
        logic.onOneToThreeClicked();
        logic.onTwoToOneClicked();
        logic.onTwoToThreeClicked();
        logic.onOneToThreeClicked();
        logic.onOneToTwoClicked();
        logic.onThreeToTwoClicked();
        logic.onThreeToOneClicked();
        logic.onTwoToOneClicked();
        logic.onThreeToOneClicked();
        Assert.assertEquals(12, logic.getCount());
    }
}
