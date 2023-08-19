package com.example.practicecode;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {
    private Button button;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        button = (Button) findViewById(R.id.buttonBlackJack);
        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        }));

        button1 = (Button) findViewById(R.id.buttonTicTacToe);
        button1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        }));

        button2 = (Button) findViewById(R.id.buttonTowersOfHanoi);
        button2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        }));

    }

    public void openActivity2() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this, TicTacToeScreen1.class);
        startActivity(intent);
    }
    public void openActivity4() {
        Intent intent = new Intent(this, TowersOfHanoi1.class);
        startActivity(intent);
    }
}