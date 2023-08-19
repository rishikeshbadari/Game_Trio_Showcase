package com.example.practicecode;

import android.widget.ImageView;

public interface Display {
    void updateCirclesColor();
    void showGameOverScreen();
    void displayCardSuit(ImageView imageViewCard, int suitDrawable);
}

