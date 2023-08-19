package com.example.practicecode;

import java.util.HashMap;

public class TicTacToeGame {
    private String currentlyPlaying = "Yes";
    private String currentPlayer = "X";
    private HashMap<String, String> boxes;

    public TicTacToeGame() {
        boxes = new HashMap<String, String>() {
            {
                put("Top Left", "Not pressed");
                put("Top Center", "Not pressed");
                put("Top Right", "Not pressed");
                put("Middle Left", "Not pressed");
                put("Middle Center", "Not pressed");
                put("Middle Right", "Not pressed");
                put("Bottom Left", "Not pressed");
                put("Bottom Center", "Not pressed");
                put("Bottom Right", "Not pressed");
            }
        };
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isCurrentlyPlaying() {
        return currentlyPlaying.equals("Yes");
    }

    public HashMap<String, String> getBoxes() {
        return boxes;
    }

    public void makeMove(String boxClicked) {
        if (!isCurrentlyPlaying()) {
            return;
        }

        if (boxes.get(boxClicked).equals("Not pressed")) {
            boxes.put(boxClicked, currentPlayer);
            currentPlayer = currentPlayer.equals("O") ? "X" : "O";
        }
    }

    public boolean checkWinningState() {
        String[][] winningStates = {
                {"Top Left", "Top Center", "Top Right"},
                {"Middle Left", "Middle Center", "Middle Right"},
                {"Bottom Left", "Bottom Center", "Bottom Right"},
                {"Top Left", "Middle Left", "Bottom Left"},
                {"Top Center", "Middle Center", "Bottom Center"},
                {"Top Right", "Middle Right", "Bottom Right"},
                {"Top Left", "Middle Center", "Bottom Right"},
                {"Top Right", "Middle Center", "Bottom Left"}
        };

        for (String[] winningState : winningStates) {
            if (boxes.get(winningState[0]).equals(boxes.get(winningState[1])) &&
                    boxes.get(winningState[1]).equals(boxes.get(winningState[2])) &&
                    !boxes.get(winningState[0]).equals("Not pressed")) {
                return true;
            }
        }
        return false;
    }

    public boolean isTied() {
        return getNumSelected() == 9 && !checkWinningState();
    }

    public void gameReset() {
        currentlyPlaying = "Yes";
        currentPlayer = "X";
        boxes.clear();
        boxes.put("Top Left", "Not pressed");
        boxes.put("Top Center", "Not pressed");
        boxes.put("Top Right", "Not pressed");
        boxes.put("Middle Left", "Not pressed");
        boxes.put("Middle Center", "Not pressed");
        boxes.put("Middle Right", "Not pressed");
        boxes.put("Bottom Left", "Not pressed");
        boxes.put("Bottom Center", "Not pressed");
        boxes.put("Bottom Right", "Not pressed");
    }

    public int getNumSelected() {
        int numSelected = 0;
        for (String value : boxes.values()) {
            if (!value.equals("Not pressed")) {
                numSelected++;
            }
        }
        return numSelected;
    }
}
