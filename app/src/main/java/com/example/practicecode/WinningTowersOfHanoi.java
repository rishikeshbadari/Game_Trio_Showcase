package com.example.practicecode;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//import com.example.practicecode.databinding.Activity2Binding;

import java.text.BreakIterator;

public class WinningTowersOfHanoi extends AppCompatActivity {

    private Button button;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_towers_of_hanoi);
        button = (Button) findViewById(R.id.buttonSubmit);
        TextView playerScoreView = findViewById(R.id.textView);
        Intent intent = getIntent();
        int player1Score = intent.getIntExtra("moves", 0);
        playerScoreView.setText(String.valueOf(player1Score));
        button = (Button) findViewById(R.id.quit);
        button.setOnClickListener(v -> openActivity3());
        button1 = (Button) findViewById(R.id.buttonSubmit);
        button1.setOnClickListener(v -> openActivity4());
    }


    public void openActivity3() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(this, TowersOfHanoi3.class);
        startActivity(intent);
    }
}