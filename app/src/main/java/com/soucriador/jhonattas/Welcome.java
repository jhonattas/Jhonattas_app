package com.soucriador.jhonattas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;

import com.soucriador.jhonattas.ui.Introduction;


public class Welcome extends ActionBarActivity {

    // A tela de welcome verifica se o usuário está abrindo o app pela primeira vez ou não.
    private SharedPreferences sharedPreferences;
    public final String PREFS_PRIVATE = "CRIADOR_PREFS_PRIVATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_welcome);

        if(loadPreferences()){
            startActivity(new Intent(this, Introduction.class));
            finish();
        } else {
            startActivity(new Intent(this, Main.class));
            finish();
        }
    }

    // não exibe o menu na tela inicial
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public boolean loadPreferences(){
        boolean firstSee = true;
        sharedPreferences = getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        firstSee = sharedPreferences.getBoolean("firstSee", firstSee);
        // TODO return firstSee;
        return true;
    }

}
