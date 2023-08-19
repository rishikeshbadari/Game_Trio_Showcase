package com.example.practicecode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//import com.example.practicecode.databinding.Activity3Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TicTacToeScreen3 extends AppCompatActivity {
    private Button button;
    private Button restartButton;

    private String player1Name = "Player 1";
    private String player2Name = "Player 2";
    private int player1Score = 0;
    private int player2Score = 0;
    private TextView player1ScoreTextView;
    private TextView player2ScoreTextView;
    String currentlyPlaying = "Yes";
    String currentPlayer = "X";
    HashMap<String, String> boxes = new HashMap<String, String>(){
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

    public HashMap<String, String> getBoxes() {
        return boxes;
    }

    String[][] winningStates = {{"Top Left", "Top Center", "Top Right"},
            {"Middle Left", "Middle Center", "Middle Right"},
            {"Bottom Left", "Bottom Center", "Bottom Right"},
            {"Top Left", "Middle Left", "Bottom Left"},
            {"Top Center", "Middle Center", "Bottom Center"},
            {"Top Right", "Middle Right", "Bottom Right"},
            {"Top Left", "Middle Center", "Bottom Right"},
            {"Top Right", "Middle Center", "Bottom Left"}};
    public static int numSelected = 0;
    public void click(View newView) {
        ImageView image = (ImageView) newView; // base grid
        String boxClicked = "";
        boolean won = false;
        switch (image.getTag().toString()) {
            case "0":
                boxClicked = "Top Left";
                break;
            case "1":
                boxClicked = "Top Center";
                break;
            case "2":
                boxClicked = "Top Right";
                break;
            case "3":
                boxClicked = "Middle Left";
                break;
            case "4":
                boxClicked = "Middle Center";
                break;
            case "5":
                boxClicked = "Middle Right";
                break;
            case "6":
                boxClicked = "Bottom Left";
                break;
            case "7":
                boxClicked = "Bottom Center";
                break;
            case "8":
                boxClicked = "Bottom Right";
                break;
        }
        if (currentlyPlaying.equals("No")) {
            gameReset(newView);
        }
        if (boxes.get(boxClicked).equals("Not pressed")) {
            boxes.put(boxClicked, currentPlayer);
            if (currentPlayer.equals("O")) {
                image.setImageResource(R.drawable.o);
                currentPlayer = "X";
                ((TextView) findViewById(R.id.status)).setText("X (PLayer 1) to Play");
            } else {
                image.setImageResource(R.drawable.xx);
                currentPlayer = "O";
                ((TextView) findViewById(R.id.status)).setText("O (Player 2) to Play");
            }
            numSelected++;
            if (numSelected == 9) {
                currentlyPlaying = "No";
            }
        }
        for (String[] winningState : winningStates) {
            if (boxes.get(winningState[0]).equals(boxes.get(winningState[1])) &&
                    boxes.get(winningState[1]).equals(boxes.get(winningState[2])) &&
                    !boxes.get(winningState[0]).equals("Not pressed")) {
                won = true;
                currentlyPlaying = "No";
                if(boxes.get(winningState[0]).equals("O")) {
                    ((TextView) findViewById(R.id.status)).setText("O (Player 2) has won");
                    player2Score++;
                } else {
                    ((TextView) findViewById(R.id.status)).setText("X (Player 1) has won");
                    player1Score++;
                }
                // Update circle colors here
                updateCirclesColor();
            }
        }
        if (numSelected == 9 && won == false) {
            ((TextView) findViewById(R.id.status)).setText("Tied game! Try again");
        }
    }

    public void gameReset(View view) {
        currentlyPlaying = "Yes";
        currentPlayer = "X";
        boxes = new HashMap<String, String>(){
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
        View image0 = findViewById(R.id.imageView0);
        ImageView imageNew0 = (ImageView) (image0);
        imageNew0.setImageResource(0);

        View image1 = findViewById(R.id.imageView1);
        ImageView imageNew1 = (ImageView) (image1);
        imageNew1.setImageResource(0);

        View image2 = findViewById(R.id.imageView2);
        ImageView imageNew2 = (ImageView) (image2);
        imageNew2.setImageResource(0);

        View image3 = findViewById(R.id.imageView3);
        ImageView imageNew3 = (ImageView) (image3);
        imageNew3.setImageResource(0);

        View image4 = findViewById(R.id.imageView4);
        ImageView imageNew4 = (ImageView) (image4);
        imageNew4.setImageResource(0);

        View image5 = findViewById(R.id.imageView5);
        ImageView imageNew5 = (ImageView) (image5);
        imageNew5.setImageResource(0);

        View image6 = findViewById(R.id.imageView6);
        ImageView imageNew6 = (ImageView) (image6);
        imageNew6.setImageResource(0);

        View image7 = findViewById(R.id.imageView7);
        ImageView imageNew7 = (ImageView) (image7);
        imageNew7.setImageResource(0);

        View image8 = findViewById(R.id.imageView8);
        ImageView imageNew8 = (ImageView) (image8);
        imageNew8.setImageResource(0);

        View image9 = findViewById(R.id.status);
        TextView imageNew9 = (TextView) (image9);
        imageNew9.setText("X (Player 1) make a move");
        numSelected = 0;
        // Update score TextViews
        player1ScoreTextView.setText(String.valueOf(player1Score));
        player2ScoreTextView.setText(String.valueOf(player2Score));
    }

    public boolean checkWinningState() {
        for (String[] winningState : winningStates) {
            if (boxes.get(winningState[0]).equals(boxes.get(winningState[1])) &&
                    boxes.get(winningState[1]).equals(boxes.get(winningState[2])) &&
                    !boxes.get(winningState[0]).equals("Not pressed")) {
                return true;
            }
        }
        return false;
    }


//    public void computerTurn() {
//        List<Integer> availablePositions = new ArrayList<>();
//        for (int i = 0; i < gameState.length; i++) {
//            if (gameState[i] == 2) {
//                availablePositions.add(i);
//            }
//        }
//
//        if (!availablePositions.isEmpty()) {
//            Random random = new Random();
//            int randomIndex = random.nextInt(availablePositions.size());
//            int position = availablePositions.get(randomIndex);
//
//            gameState[position] = 0;
//
//            // find the corresponding ImageView for the selected position
//            ImageView img = findViewById(getResources().getIdentifier("imageView" + position, "id", getPackageName()));
//            img.setTranslationY(-1000f);
//            img.setImageResource(R.drawable.oo);
//            img.animate().translationYBy(1000f).setDuration(300);
//
//            activePlayer = 0;
//            TextView status = findViewById(R.id.status);
//            status.setText("X's Turn - Tap to play");
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_screen3);

        player1ScoreTextView = findViewById(R.id.player1ScoreTextView);
        player2ScoreTextView = findViewById(R.id.player2ScoreTextView);

        ImageView selectedImageView = findViewById(R.id.selectedImageView);
        TextView transferredTextView = findViewById(R.id.nameTextView);

        Intent intent = getIntent();
        int selectedImageResourceId = intent.getIntExtra("selectedImageResourceId", 0);
        String enteredText = intent.getStringExtra("enteredText");

        selectedImageView.setImageResource(selectedImageResourceId);
        transferredTextView.setText(enteredText);


        button = (Button) findViewById(R.id.quit);
        restartButton = (Button) findViewById(R.id.quit2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { resetScores(v); }
        });


    }

    private void resetScores(View newView) {
        player1Score = 0;
        player2Score = 0;
        player1ScoreTextView.setText(String.valueOf(player1Score));
        player2ScoreTextView.setText(String.valueOf(player2Score));
        gameReset(newView);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }




    /**
    public void updateCirclesColor() {
        if (player1Score == 1) {
            ((ImageView) findViewById(R.id.imageView11)).setColorFilter(Color.RED);
        } else if (player1Score == 2) {
            ((ImageView) findViewById(R.id.imageView10)).setColorFilter(Color.RED);
        } else if (player1Score == 3) {
            ((ImageView) findViewById(R.id.imageView9)).setColorFilter(Color.RED);
            //Intent intent = new Intent(this, GameOverForTowers.class);
            //intent.putExtra("moves", count);
            //startActivity(intent);
        } else if (player2Score == 1) {
            ((ImageView) findViewById(R.id.imageView15)).setColorFilter(Color.RED);
        } else if (player2Score == 2) {
            ((ImageView) findViewById(R.id.imageView13)).setColorFilter(Color.RED);
        } else if (player2Score == 3) {
            ((ImageView) findViewById(R.id.imageView12)).setColorFilter(Color.RED);
            //Intent intent = new Intent(this, GameOverForTowers.class);
            //intent.putExtra("moves", count);
            //startActivity(intent);
        }
    }
     **/



    public void updateCirclesColor() {
        if (player1Score == 1) {
            ((ImageView) findViewById(R.id.imageView11)).setColorFilter(Color.RED);
        } else if (player1Score == 2) {
            ((ImageView) findViewById(R.id.imageView10)).setColorFilter(Color.RED);
        } else if (player1Score == 3) {
            ((ImageView) findViewById(R.id.imageView9)).setColorFilter(Color.RED);
            Intent intent = new Intent(this, GameOverTic2.class);
            //intent.putExtra("moves", count);
            startActivity(intent);
        } else {
            // Reset the color filter if no condition is met
            ((ImageView) findViewById(R.id.imageView11)).setColorFilter(null);
            ((ImageView) findViewById(R.id.imageView10)).setColorFilter(null);
            ((ImageView) findViewById(R.id.imageView9)).setColorFilter(null);
        }
        if (player2Score == 1) {
            ((ImageView) findViewById(R.id.imageView15)).setColorFilter(Color.RED);
        } else if (player2Score == 2) {
            ((ImageView) findViewById(R.id.imageView13)).setColorFilter(Color.RED);
        } else if (player2Score == 3) {
            ((ImageView) findViewById(R.id.imageView12)).setColorFilter(Color.RED);
            Intent intent = new Intent(this, GameOverTic1.class);
            //intent.putExtra("moves", count);
            startActivity(intent);
        } else {
            // Reset the color filter if no condition is met
            ((ImageView) findViewById(R.id.imageView15)).setColorFilter(null);
            ((ImageView) findViewById(R.id.imageView13)).setColorFilter(null);
            ((ImageView) findViewById(R.id.imageView12)).setColorFilter(null);
        }
    }
}
