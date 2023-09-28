package com.example.climaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LanguageActivity extends AppCompatActivity {

    private RadioGroup languageRadioGroup;
    private Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        languageRadioGroup = findViewById(R.id.languageRadioGroup);
        applyButton = findViewById(R.id.buttonApply);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = languageRadioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);

                if (radioButton != null) {
                    String languageCode = radioButton.getTag().toString();
                    LanguageManager.setAppLanguage(LanguageActivity.this, languageCode);

                    // Reinicie a atividade atual para aplicar as configurações de idioma
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }
        });

    }
}