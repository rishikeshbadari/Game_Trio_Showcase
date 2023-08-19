package com.example.practicecode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TowersOfHanoi3 extends AppCompatActivity {

    // tower1 is first tower. Index 0 is the bottom. Index 2 is the top.
    // Fattest peg3 is 30. Medium peg2 is 20. Lowest peg1 is 10.
    ArrayList<Integer> tower1 = new ArrayList<>();
    ArrayList<Integer> tower2 = new ArrayList<>();
    ArrayList<Integer> tower3 = new ArrayList<>();
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towers_of_hanoi3);

        Intent intent = getIntent();
        int selectedImageResourceId = intent.getIntExtra("selectedImageResourceId", 0);
        String enteredText = intent.getStringExtra("enteredText");

        ((ImageView) findViewById(R.id.selectedImageView)).setImageResource(selectedImageResourceId);
        ((TextView) findViewById(R.id.nameTextView)).setText(enteredText);

        tower1.add(0, 30);
        tower1.add(1,20);
        tower1.add(2,10);
    }

    public void onOneToTwoClicked(View view) {
        count++;
        if (tower1.size() == 0) {
            return;
        }
        View peg = findViewById(R.id.peg1);
        if (tower1.get(tower1.size() - 1) == 10) {
            peg = findViewById(R.id.peg1);
        } else if (tower1.get(tower1.size() - 1) == 20) {
            peg = findViewById(R.id.peg2);
        } else if (tower1.get(tower1.size() - 1) == 30) {
            peg = findViewById(R.id.peg3);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) peg.getLayoutParams();
        if (tower2.size() == 0 && peg == findViewById(R.id.peg1)) {
            tower2.add(10);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 2, "Lowest");
        } else if (tower2.size() == 0 && peg == findViewById(R.id.peg2)) {
            tower2.add(20);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 2, "Lowest");
        } else if (tower2.size() == 0 && peg == findViewById(R.id.peg3)) {
            tower2.add(30);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 2, "Lowest");
        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg1) && 10 < tower2.get(0)) {
            tower2.add(10);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 2, "Middle");
        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg2) && 20 < tower2.get(0)) {
            tower2.add(20);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 2, "Middle");
//        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg1) && 10 < tower2.get(1)) {
            tower2.add(10);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 2, "Highest");
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg2)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        }
        peg.setLayoutParams(layoutParams);
        ((TextView) findViewById(R.id.moves)).setText("Moves: " + count);
        checkWin();
        updateCirclesColor();
    }

    public void onOneToThreeClicked(View view) {
        count++;
        if (tower1.size() == 0) {
            return;
        }
        View peg = findViewById(R.id.peg1);
        if (tower1.get(tower1.size() - 1) == 10) {
            peg = findViewById(R.id.peg1);
        } else if (tower1.get(tower1.size() - 1) == 20) {
            peg = findViewById(R.id.peg2);
        } else if (tower1.get(tower1.size() - 1) == 30) {
            peg = findViewById(R.id.peg3);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) peg.getLayoutParams();
        if (tower3.size() == 0 && peg == findViewById(R.id.peg1)) {
            tower3.add(10);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 3, "Lowest");
        } else if (tower3.size() == 0 && peg == findViewById(R.id.peg2)) {
            tower3.add(20);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 3, "Lowest");
        } else if (tower3.size() == 0 && peg == findViewById(R.id.peg3)) {
            tower3.add(30);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 3, "Lowest");
        } else if (tower3.size() == 1 && peg == findViewById(R.id.peg1) && 10 < tower3.get(0)) {
            tower3.add(10);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 3, "Middle");
        } else if (tower3.size() == 1 && peg == findViewById(R.id.peg2) && 20 < tower3.get(0)) {
            tower3.add(20);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 3, "Middle");
//        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        } else if (tower3.size() == 2 && peg == findViewById(R.id.peg1) && 10 < tower3.get(1)) {
            tower3.add(10);
            tower1.remove(tower1.size() - 1);
            updatePegLayoutParams(peg, 3, "Highest");
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg2)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        }
        peg.setLayoutParams(layoutParams);
        ((TextView) findViewById(R.id.moves)).setText("Moves: " + count);
        checkWin();
        updateCirclesColor();
    }

    public void onTwoToOneClicked(View view) {
        count++;
        if (tower2.size() == 0) {
            return;
        }
        View peg = findViewById(R.id.peg1);
        if (tower2.get(tower2.size() - 1) == 10) {
            peg = findViewById(R.id.peg1);
        } else if (tower2.get(tower2.size() - 1) == 20) {
            peg = findViewById(R.id.peg2);
        } else if (tower2.get(tower2.size() - 1) == 30) {
            peg = findViewById(R.id.peg3);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) peg.getLayoutParams();
        if (tower1.size() == 0 && peg == findViewById(R.id.peg1)) {
            tower1.add(10);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 1, "Lowest");
        } else if (tower1.size() == 0 && peg == findViewById(R.id.peg2)) {
            tower1.add(20);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 1, "Lowest");
        } else if (tower1.size() == 0 && peg == findViewById(R.id.peg3)) {
            tower1.add(30);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 1, "Lowest");
        } else if (tower1.size() == 1 && peg == findViewById(R.id.peg1) && 10 < tower1.get(0)) {
            tower1.add(10);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 1, "Middle");
        } else if (tower1.size() == 1 && peg == findViewById(R.id.peg2) && 20 < tower1.get(0)) {
            tower1.add(20);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 1, "Middle");
//        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        } else if (tower1.size() == 2 && peg == findViewById(R.id.peg1) && 10 < tower1.get(1)) {
            tower1.add(10);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 1, "Highest");
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg2)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        }
        peg.setLayoutParams(layoutParams);
        ((TextView) findViewById(R.id.moves)).setText("Moves: " + count);
        checkWin();
        updateCirclesColor();
    }

    public void onTwoToThreeClicked(View view) {
        count++;
        if (tower2.size() == 0) {
            return;
        }
        View peg = findViewById(R.id.peg1);
        if (tower2.get(tower2.size() - 1) == 10) {
            peg = findViewById(R.id.peg1);
        } else if (tower2.get(tower2.size() - 1) == 20) {
            peg = findViewById(R.id.peg2);
        } else if (tower2.get(tower2.size() - 1) == 30) {
            peg = findViewById(R.id.peg3);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) peg.getLayoutParams();
        if (tower3.size() == 0 && peg == findViewById(R.id.peg1)) {
            tower3.add(10);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 3, "Lowest");
        } else if (tower3.size() == 0 && peg == findViewById(R.id.peg2)) {
            tower3.add(20);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 3, "Lowest");
        } else if (tower3.size() == 0 && peg == findViewById(R.id.peg3)) {
            tower3.add(30);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 3, "Lowest");
        } else if (tower3.size() == 1 && peg == findViewById(R.id.peg1) && 10 < tower3.get(0)) {
            tower3.add(10);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 3, "Middle");
        } else if (tower3.size() == 1 && peg == findViewById(R.id.peg2) && 20 < tower3.get(0)) {
            tower3.add(20);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 3, "Middle");
//        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        } else if (tower3.size() == 2 && peg == findViewById(R.id.peg1) && 10 < tower3.get(1)) {
            tower3.add(10);
            tower2.remove(tower2.size() - 1);
            updatePegLayoutParams(peg, 3, "Highest");
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg2)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        }
        peg.setLayoutParams(layoutParams);
        ((TextView) findViewById(R.id.moves)).setText("Moves: " + count);
        checkWin();
        updateCirclesColor();
    }

    public void onThreeToTwoClicked(View view) {
        count++;
        if (tower3.size() == 0) {
            return;
        }
        View peg = findViewById(R.id.peg1);
        if (tower3.get(tower3.size() - 1) == 10) {
            peg = findViewById(R.id.peg1);
        } else if (tower3.get(tower3.size() - 1) == 20) {
            peg = findViewById(R.id.peg2);
        } else if (tower3.get(tower3.size() - 1) == 30) {
            peg = findViewById(R.id.peg3);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) peg.getLayoutParams();
        if (tower2.size() == 0 && peg == findViewById(R.id.peg1)) {
            tower2.add(10);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 2, "Lowest");
        } else if (tower2.size() == 0 && peg == findViewById(R.id.peg2)) {
            tower2.add(20);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 2, "Lowest");
        } else if (tower2.size() == 0 && peg == findViewById(R.id.peg3)) {
            tower2.add(30);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 2, "Lowest");
        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg1) && 10 < tower2.get(0)) {
            tower2.add(10);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 2, "Middle");
        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg2) && 20 < tower2.get(0)) {
            tower2.add(20);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 2, "Middle");
//        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg1) && 10 < tower2.get(1)) {
            tower2.add(10);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 2, "Highest");
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg2)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        }
        peg.setLayoutParams(layoutParams);
        ((TextView) findViewById(R.id.moves)).setText("Moves: " + count);
        checkWin();
        updateCirclesColor();
    }

    public void onThreeToOneClicked(View view) {
        count++;
        if (tower3.size() == 0) {
            return;
        }
        View peg = findViewById(R.id.peg1);
        if (tower3.get(tower3.size() - 1) == 10) {
            peg = findViewById(R.id.peg1);
        } else if (tower3.get(tower3.size() - 1) == 20) {
            peg = findViewById(R.id.peg2);
        } else if (tower3.get(tower3.size() - 1) == 30) {
            peg = findViewById(R.id.peg3);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) peg.getLayoutParams();
        if (tower1.size() == 0 && peg == findViewById(R.id.peg1)) {
            tower1.add(10);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 1, "Lowest");
        } else if (tower1.size() == 0 && peg == findViewById(R.id.peg2)) {
            tower1.add(20);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 1, "Lowest");
        } else if (tower1.size() == 0 && peg == findViewById(R.id.peg3)) {
            tower1.add(30);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 1, "Lowest");
        } else if (tower1.size() == 1 && peg == findViewById(R.id.peg1) && 10 < tower1.get(0)) {
            tower1.add(10);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 1, "Middle");
        } else if (tower1.size() == 1 && peg == findViewById(R.id.peg2) && 20 < tower1.get(0)) {
            tower1.add(20);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 1, "Middle");
//        } else if (tower2.size() == 1 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        } else if (tower1.size() == 2 && peg == findViewById(R.id.peg1) && 10 < tower1.get(1)) {
            tower1.add(10);
            tower3.remove(tower3.size() - 1);
            updatePegLayoutParams(peg, 1, "Highest");
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg2)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
//        } else if (tower2.size() == 2 && peg == findViewById(R.id.peg3)) {
//            tower2.add(30);
//            tower1.remove(tower1.size() - 1);
//            layoutParams.horizontalBias = 0.5f;
//            layoutParams.verticalBias = 0.662f;
        }
        peg.setLayoutParams(layoutParams);
        ((TextView) findViewById(R.id.moves)).setText("Moves: " + count);
        checkWin();
        updateCirclesColor();
    }

    private void updatePegLayoutParams(View peg, int tower, String position) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) peg.getLayoutParams();
        if (peg == findViewById(R.id.peg1)) {
            if (tower == 1) {
                layoutParams.horizontalBias = 0.12f;
            } else if (tower == 2) {
                layoutParams.horizontalBias = 0.49f;
            } else if (tower == 3) {
                layoutParams.horizontalBias = 0.915f;
            }
        } else if (peg == findViewById(R.id.peg2)) {
            if (tower == 1) {
                layoutParams.horizontalBias = 0.10f;
            } else if (tower == 2) {
                layoutParams.horizontalBias = 0.49f;
            } else if (tower == 3) {
                layoutParams.horizontalBias = 0.94f;
            }
        } else if (peg == findViewById(R.id.peg3)) {
            if (tower == 1) {
                layoutParams.horizontalBias = 0.076f;
            } else if (tower == 2) {
                layoutParams.horizontalBias = 0.5f;
            } else if (tower == 3) {
                layoutParams.horizontalBias = 0.97f;
            }
        }
        if (position.equals("Lowest")) {
            layoutParams.verticalBias = 0.662f;
        } else if (position.equals("Middle")) {
            layoutParams.verticalBias = 0.637f;
        } else if (position.equals("Highest")) {
            layoutParams.verticalBias = 0.612f;
        }
        peg.setLayoutParams(layoutParams);
    }

    private void checkWin() {
        if (tower3.size() == 3) {
            Intent intent = new Intent(this, WinningTowersOfHanoi.class);
            intent.putExtra("moves", count);
            startActivity(intent);
        }
    }

    public void updateCirclesColor() {
        if (count == 8) {
            ((ImageView) findViewById(R.id.imageView3)).setColorFilter(Color.RED);
        } else if (count == 15) {
            ((ImageView) findViewById(R.id.imageView2)).setColorFilter(Color.RED);
        } else if (count == 22) {
            ((ImageView) findViewById(R.id.imageView)).setColorFilter(Color.RED);
            Intent intent = new Intent(this, GameOverForTowers.class);
            intent.putExtra("moves", count);
            startActivity(intent);
        }
    }
}