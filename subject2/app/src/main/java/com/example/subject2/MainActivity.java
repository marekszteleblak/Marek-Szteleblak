package com.example.subject2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.firstactivity1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button secondActivityButton = findViewById(R.id.secondactivity);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), secondActivity.class);
                startIntent.putExtra("org.mentorshools.quicklancher.SOMETHING", "HELLO WORLD!");
                startActivity(startIntent);

            }
        });

        Button google =(Button) findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webaddress = Uri.parse(google);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                // This part of code is not working
               /* if (gotoGoogle.resolveActivity(getPackageManager()) != null) {
                   startActivity(gotoGoogle);
                }*/
                try {
                    startActivity(gotoGoogle);
                } catch (Exception e) {
                    TextView debuger = (TextView) findViewById(R.id.debuger);
                    debuger.setText("something went wrong");

                }
            }
            });
    }
}