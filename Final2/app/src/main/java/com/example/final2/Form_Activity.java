package com.example.final2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Form_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Pobranie referencji do pola tekstowego i przycisku
        EditText listNameField = findViewById(R.id.List_Name); // id pola tekstowego
        Button submitButton = findViewById(R.id.submit_button); // id przycisku (dodaj w XML, jeśli nie istnieje)

        // Obsługa kliknięcia przycisku
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pobranie wartości z pola tekstowego
                String listName = listNameField.getText().toString();

                // Przekazanie danych do ListDetailActivity
                Intent intent = new Intent(Form_Activity.this, ListDetailActivity.class);
                intent.putExtra("listName", listName); // Dodanie danych do Intent
                startActivity(intent);
            }
        });
    }
}