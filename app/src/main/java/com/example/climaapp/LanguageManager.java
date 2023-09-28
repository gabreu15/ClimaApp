package com.example.climaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class LanguageManager {
    private static final String PREF_LANG = "app_language";
    private static final String DEFAULT_LANG = "en"; // Idioma padrão (inglês)

    public static void setAppLanguage(Context context, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.setLocale(locale);

        // Atualizar a configuração global do aplicativo
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        // Salvar o idioma selecionado nas preferências compartilhadas
        SharedPreferences preferences = context.getSharedPreferences("MyApp", Context.MODE_PRIVATE);
        preferences.edit().putString(PREF_LANG, languageCode).apply();
    }

    public static String getAppLanguage(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("MyApp", Context.MODE_PRIVATE);
        return preferences.getString(PREF_LANG, DEFAULT_LANG);
    }
}
