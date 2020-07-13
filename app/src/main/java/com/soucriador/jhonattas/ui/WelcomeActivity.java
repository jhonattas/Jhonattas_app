package com.soucriador.jhonattas.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;

import com.soucriador.jhonattas.Config;
import com.soucriador.jhonattas.R;


public class WelcomeActivity extends AppCompatActivity {

    // nome da classe que aparece no log
    private final String TAG = WelcomeActivity.class.getSimpleName();

    // A tela de welcome verifica se o usuário está abrindo o app pela primeira vez ou não.
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        startActivity(new Intent(this, SectionsActivity.class));
        finish();
    }

    // não exibe o menu na tela inicial
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public boolean loadPreferences(){
        sharedPreferences = getSharedPreferences(Config.PREFS_PRIVATE, Context.MODE_PRIVATE);
        boolean firstSee = sharedPreferences.getBoolean("firstSee", true);
        return firstSee;
    }

}
