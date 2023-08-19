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

public class BlackJack extends Scoreboard {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Intent intent = getIntent();
        ((ImageView) findViewById(R.id.selectedImageView)).setImageResource(intent.getIntExtra("selectedImageResourceId", 0));
        ((TextView) findViewById(R.id.nameTextView)).setText(intent.getStringExtra("enteredText"));
        ((Button) findViewById(R.id.buttonDeal)).setOnClickListener(v -> startNewGame());
        ((Button) findViewById(R.id.buttonHit)).setOnClickListener(v -> hit());
        ((Button) findViewById(R.id.buttonStand)).setOnClickListener(v -> stand());
        deck = new ArrayList<>();
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        bustCount = 0;
        startNewGame();
    }
    private void startNewGame() {
        deck.clear();
        playerHand.clear();
        dealerHand.clear();
        for (int i = 1; i <= 13; i++) {
            deck.add(i);
        }
        playerScore = 0;
        dealerScore = 0;
        hit();
        dealCardToDealer();
        hit();
        updateScores();
        ((TextView) findViewById(R.id.textViewResult)).setText("");
        ((Button) findViewById(R.id.buttonDeal)).setEnabled(false);
        ((Button) findViewById(R.id.buttonHit)).setEnabled(true);
        ((Button) findViewById(R.id.buttonStand)).setEnabled(true);
        if (playerScore == 21) {
            player1Score++;
            endGame("Blackjack! Player wins.");
        }
    }
    private void hit() {
        int randomIndex = new Random().nextInt(deck.size());
        int cardValue = deck.get(randomIndex);
        deck.remove(randomIndex);
        playerHand.add(cardValue);
        int score = getCardScore(cardValue);
        playerScore += score;
        updateScores();
        if (playerScore > 21) {
            bustCount++;
            updateCirclesColor();
            endGame("Player busts! Dealer wins.");
        }
        int randomSuitIndex = new Random().nextInt(suits.length);
        int suitDrawable = suits[randomSuitIndex];
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(randomSuitIndex, cardValue);
        if (set.add(hashmap)) {
            displayCardSuit(((ImageView) findViewById(R.id.imageViewCard)), suitDrawable);
        }
        ((TextView) findViewById(R.id.textViewCardNumber)).setText(String.valueOf(getCardScore(cardValue)));
    }
    private void dealCardToDealer() {
        int randomIndex = new Random().nextInt(deck.size());
        int cardValue = deck.get(randomIndex);
        deck.remove(randomIndex);
        dealerHand.add(cardValue);
        dealerScore += getCardScore(cardValue);
        updateScores();
        if (dealerScore > 21) {
            endGame("Dealer busts! Player wins.");
            player1Score++;
        }
    }
    private void stand() {
        while (dealerScore < 17) {
            dealCardToDealer();
        }
        if (dealerScore > 21) {
            player1Score--;
        }
        if (dealerScore <= 21 &&  dealerScore > playerScore) {
            bustCount++;
            updateCirclesColor();
            endGame("Dealer wins.");
        } else if (dealerScore < playerScore) {
            player1Score++;
            endGame("Player wins.");
        } else if (dealerScore > 21) {
            player1Score++;
            endGame("Dealer Busts! Player wins.");
        } else {
            endGame("It's a tie.");
        }
    }
    private void endGame(String message) {
        ((TextView) findViewById(R.id.textViewResult)).setText(message);
        ((Button) findViewById(R.id.buttonDeal)).setEnabled(true);
        ((Button) findViewById(R.id.buttonHit)).setEnabled(false);
        ((Button) findViewById(R.id.buttonStand)).setEnabled(false);
        ((TextView) findViewById(R.id.player1ScoreTextView)).setText(String.valueOf(player1Score));
    }
}



