package com.example.practicecode;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private int selectedImageResourceId;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ((ImageButton) findViewById(R.id.imageButton1)).setOnClickListener(v -> selectedImageResourceId = R.drawable.krabs);
        ((ImageButton) findViewById(R.id.imageButton2)).setOnClickListener(v -> selectedImageResourceId = R.drawable.plankton);
        ((ImageButton) findViewById(R.id.imageButton3)).setOnClickListener(v -> selectedImageResourceId = R.drawable.larrylobster);
        ((Button) findViewById(R.id.buttonSubmit)).setOnClickListener(v -> {
            name = ((EditText) findViewById(R.id.editTextText)).getText().toString();
            openActivity2();
        });
        ((Button) findViewById(R.id.quit)).setOnClickListener(v -> openActivity3());
    }

    private void openActivity2() {
         if (name.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
         }
        Intent intent = new Intent(Activity2.this, BlackJack.class);
        intent.putExtra("selectedImageResourceId", selectedImageResourceId);
        intent.putExtra("enteredText", name);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}