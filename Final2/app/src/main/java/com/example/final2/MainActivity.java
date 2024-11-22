package com.example.final2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newListButton = findViewById(R.id.newList);
        newListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tworzenie AlertDialog z polem tekstowym
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Utwórz nową listę");

                // Dodanie pola tekstowego do dialogu
                final EditText input = new EditText(MainActivity.this);
                input.setHint("Wpisz nazwę listy");
                builder.setView(input);

                builder.setPositiveButton("Utwórz", (dialog, which) -> {
                    String listName = input.getText().toString().trim();
                    if (!listName.isEmpty()) {
                        // Przejście do nowej aktywności
                        Intent intent = new Intent(MainActivity.this, Form_Activity.class);
                        startActivity(intent);
                        intent.putExtra("LIST_NAME", listName);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Anuluj", (dialog, which) -> dialog.cancel());

                builder.show();
            }
        });
    }
}