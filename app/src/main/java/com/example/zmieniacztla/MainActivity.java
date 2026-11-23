package com.example.zmieniacztla;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    String[] texts = {"Tekst 1", "Tekst 2", "Tekst 3"};
    int index = 0;

    int[] colors = {R.color.text_color, R.color.text_opt2, R.color.text_opt3};
    int colorIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvText = findViewById(R.id.tvText);
        Button btnChangeText = findViewById(R.id.btnChangeText);
        Button btnChangeColor = findViewById(R.id.btnChangeColor);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        colorIndex = prefs.getInt("color", 0);

        tvText.setText(texts[index]);
        tvText.setTextColor(ContextCompat.getColor(this, colors[colorIndex]));

        btnChangeText.setOnClickListener(v -> {
            index++;
            if (index == texts.length) index = 0;
            tvText.setText(texts[index]);
        });

        btnChangeColor.setOnClickListener(v -> {
            colorIndex++;
            if (colorIndex == colors.length) colorIndex = 0;
            tvText.setTextColor(ContextCompat.getColor(this, colors[colorIndex]));
            prefs.edit().putInt("color", colorIndex).apply();
        });
    }
}