package com.example.practicecode;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//import com.example.practicecode.databinding.Activity2Binding;

import java.text.BreakIterator;

public class TowersOfHanoi2 extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private int selectedImageResourceId;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towers_of_hanoi2);
        button = (Button) findViewById(R.id.buttonSubmit);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        EditText editText = findViewById(R.id.editTextText);

        /**
         button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        openActivity2();
        //openSecondActivity();
        }
        });
         }

         private void openActivity2() {
         EditText editText = findViewById(R.id.editTextText);
         String name = editText.getText().toString();
         if (name.matches("")) {
         Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
         return;
         }

         int selectedImageResourceId = 0;

         if (imageButton1.isSelected()) {
         selectedImageResourceId = R.drawable.krabs;
         } else if (imageButton2.isSelected()) {
         selectedImageResourceId = R.drawable.plankton;
         } else if (imageButton3.isSelected()) {
         selectedImageResourceId = R.drawable.larrylobster;
         }

         Intent intent = new Intent(this, Activity3.class);
         intent.putExtra("name", name);
         intent.putExtra("selectedImageResourceId", selectedImageResourceId);
         startActivity(intent);
         **/


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageResourceId = R.drawable.krabs;
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageResourceId = R.drawable.plankton;
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImageResourceId = R.drawable.larrylobster;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                /**
                 if (name.matches("")) {
                 Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
                 return;
                 }
                 **/
                openActivity2();
            }
        });
        button = (Button) findViewById(R.id.quit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }

    private void openActivity2() {
        //name = editText.getText().toString();
        if (name.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(TowersOfHanoi2.this, TowersOfHanoi3.class);
        intent.putExtra("selectedImageResourceId", selectedImageResourceId);
        intent.putExtra("enteredText", name);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}