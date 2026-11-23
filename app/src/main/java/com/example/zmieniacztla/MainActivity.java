package com.example.zmieniacztla;

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

    String[] texts = {"Tekst 1", "Tekst 2", "Tekst 3"};
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvText = findViewById(R.id.tvText);
        Button btnChangeText = findViewById(R.id.btnChangeText);

        tvText.setText(texts[0]);

        btnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if (index == texts.length) {
                    index = 0;
                }
                tvText.setText(texts[index]);
            }
        });
    }
}