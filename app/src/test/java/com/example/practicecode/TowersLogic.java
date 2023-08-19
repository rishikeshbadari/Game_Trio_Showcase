package com.example.practicecode;

import java.util.ArrayList;

public class TowersLogic {
    private ArrayList<Integer> tower1 = new ArrayList<>();
    private ArrayList<Integer> tower2 = new ArrayList<>();
    private ArrayList<Integer> tower3 = new ArrayList<>();
    private int count = 0;

    public TowersLogic() {
        tower1.add(0, 30);
        tower1.add(1, 20);
        tower1.add(2, 10);
    }

    public void onOneToTwoClicked() {
        count++;
        if (tower1.size() == 0) {
            return;
        }
        if (tower1.get(tower1.size() - 1) == 10) {
            tower2.add(10);
        } else if (tower1.get(tower1.size() - 1) == 20) {
            tower2.add(20);
        } else if (tower1.get(tower1.size() - 1) == 30) {
            tower2.add(30);
        }
        tower1.remove(tower1.size() - 1);
        checkWin();
    }

    public void onOneToThreeClicked() {
        count++;
        if (tower1.size() == 0) {
            return;
        }
        if (tower1.get(tower1.size() - 1) == 10) {
            tower3.add(10);
        } else if (tower1.get(tower1.size() - 1) == 20) {
            tower3.add(20);
        } else if (tower1.get(tower1.size() - 1) == 30) {
            tower3.add(30);
        }
        tower1.remove(tower1.size() - 1);
        checkWin();
    }

    public void onTwoToOneClicked() {
        if (tower2.size() == 0) {
            return;
        }
        count++;
        if (tower2.get(tower2.size() - 1) == 10) {
            tower1.add(10);
        } else if (tower2.get(tower2.size() - 1) == 20) {
            tower1.add(20);
        } else if (tower2.get(tower2.size() - 1) == 30) {
            tower1.add(30);
        }
        tower2.remove(tower2.size() - 1);
        checkWin();
    }

    public void onTwoToThreeClicked() {
        count++;
        if (tower2.size() == 0) {
            return;
        }
        if (tower2.get(tower2.size() - 1) == 10) {
            tower3.add(10);
        } else if (tower2.get(tower2.size() - 1) == 20) {
            tower3.add(20);
        } else if (tower2.get(tower2.size() - 1) == 30) {
            tower3.add(30);
        }
        tower2.remove(tower2.size() - 1);
        checkWin();
    }

    public void onThreeToTwoClicked() {
        count++;
        if (tower3.size() == 0) {
            return;
        }
        if (tower3.get(tower3.size() - 1) == 10) {
            tower2.add(10);
        } else if (tower3.get(tower3.size() - 1) == 20) {
            tower2.add(20);
        } else if (tower3.get(tower3.size() - 1) == 30) {
            tower2.add(30);
        }
        tower3.remove(tower3.size() - 1);
        checkWin();
    }

    public void onThreeToOneClicked() {
        count++;
        if (tower3.size() == 0) {
            return;
        }
        if (tower3.get(tower3.size() - 1) == 10) {
            tower1.add(10);
        } else if (tower3.get(tower3.size() - 1) == 20) {
            tower1.add(20);
        } else if (tower3.get(tower3.size() - 1) == 30) {
            tower1.add(30);
        }
        tower3.remove(tower3.size() - 1);
        checkWin();
    }

    private void checkWin() {
        if (tower3.size() == 3) {
            System.out.println("You win!");
        }
    }

    public int getCount() {
        return count;
    }
}
