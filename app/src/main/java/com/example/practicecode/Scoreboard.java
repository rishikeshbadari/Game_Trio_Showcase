package com.example.practicecode;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Scoreboard extends AppCompatActivity implements Display {
    protected List<Integer> deck;
    protected List<Integer> playerHand;
    protected List<Integer> dealerHand;
    protected int playerScore;
    protected int dealerScore;
    protected int player1Score = 0;
    protected int bustCount;
    protected int[] suits = { R.drawable.club, R.drawable.diamond, R.drawable.heart, R.drawable.spade };
    protected HashSet<HashMap<Integer, Integer>> set = new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public int getCardScore(int cardValue) {
        if (cardValue == 1) {
            return 11;
        } else if (cardValue >= 11 && cardValue <= 13) {
            return 10;
        } else {
            return cardValue;
        }
    }
    public void updateScores() {
        ((TextView) findViewById(R.id.textViewPlayerScore)).setText("Player Score: " + playerScore);
        ((TextView) findViewById(R.id.textViewDealerScore)).setText("Dealer Score: " + dealerScore);
    }
    public void updateCirclesColor() {
        if (bustCount == 1) {
            ((ImageView) findViewById(R.id.imageView3)).setColorFilter(Color.RED);
        } else if (bustCount == 2) {
            ((ImageView) findViewById(R.id.imageView2)).setColorFilter(Color.RED);
        } else if (bustCount == 3) {
            ((ImageView) findViewById(R.id.imageView)).setColorFilter(Color.RED);
            showGameOverScreen();
        }
    }
    public void showGameOverScreen() {
        Intent intent = new Intent(this, GameOver.class);
        intent.putExtra("player1Score", player1Score);
        startActivity(intent);
    }
    public void displayCardSuit(ImageView imageViewCard, int suitDrawable) {
        imageViewCard.setImageResource(suitDrawable);
    }
}



