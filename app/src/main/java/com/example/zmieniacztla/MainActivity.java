package com.example.zmieniacztla;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    String[] texts;
    int index = 0;

    int[] styles = {
            Typeface.NORMAL,
            Typeface.BOLD,
            Typeface.ITALIC,
            Typeface.BOLD_ITALIC
    };
    int styleIndex = 0;

    int[] colors = {R.color.text_color, R.color.text_opt2, R.color.text_opt3};
    int colorIndex = 0;

    int[] backgrounds = {R.drawable.tlo1, R.drawable.tlo2, R.drawable.tlo3};
    int bgIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texts = getResources().getStringArray(R.array.texts);

        TextView tvText = findViewById(R.id.tvText);
        Button btnChangeText = findViewById(R.id.btnChangeText);
        Button btnChangeColor = findViewById(R.id.btnChangeColor);
        Button btnChangeBg = findViewById(R.id.btnChangeBg);
        ImageView bgImage = findViewById(R.id.bglmage);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        colorIndex = prefs.getInt("color", 0);

        tvText.setText(texts[index]);
        tvText.setTypeface(null, styles[styleIndex]);
        tvText.setTextColor(ContextCompat.getColor(this, colors[colorIndex]));
        bgImage.setImageResource(backgrounds[bgIndex]);

        btnChangeText.setOnClickListener(v -> {
            index++;
            if (index == texts.length) {
                index = 0;
            }
            tvText.setText(texts[index]);

            styleIndex++;
            if (styleIndex == styles.length) {
                styleIndex = 0;
            }
            tvText.setTypeface(null, styles[styleIndex]);
        });

        btnChangeColor.setOnClickListener(v -> {
            colorIndex++;
            if (colorIndex == colors.length) {
                colorIndex = 0;
            }
            tvText.setTextColor(ContextCompat.getColor(this, colors[colorIndex]));
            prefs.edit().putInt("color", colorIndex).apply();
        });

        btnChangeBg.setOnClickListener(v -> {
            bgIndex++;
            if (bgIndex == backgrounds.length) {
                bgIndex = 0;
            }
            bgImage.setImageResource(backgrounds[bgIndex]);
        });
    }
}