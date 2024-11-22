package com.example.final2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ListDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form); // Ustaw układ dla tej aktywności

        // Pobranie danych z Intent
        String listName = getIntent().getStringExtra("listName");

        // Wyświetlenie nazwy listy w TextView
        TextView listNameDisplay = findViewById(R.id.List_Name); // Upewnij się, że id jest poprawne
        listNameDisplay.setText(listName); // Wyświetlenie nazwy listy
    }
}
