package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button addBtn = (Button) findViewById(R.id.button);
        addBtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          EditText firstNumberText1 = (EditText) findViewById(R.id.editTextNumber1);
                                          EditText firstNumberText2 = (EditText) findViewById(R.id.editTextNumber2);
                                          TextView result = (TextView) findViewById(R.id.textView1);

                                          int firstNumber = Integer.parseInt(firstNumberText1.getText().toString());
                                          int secondNumber = Integer.parseInt(firstNumberText2.getText().toString());
                                          int sum = firstNumber + secondNumber;
                                          result.setText(String.valueOf(sum));

                                      }
                                  });
    }
}