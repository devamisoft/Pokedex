package com.devamisoft.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Carga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);
        final int DURACION = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentMain = new Intent(Carga.this, PokemonListActivity.class);
                startActivity(intentMain);
                finish();
            }
        }, DURACION);
    }
}
