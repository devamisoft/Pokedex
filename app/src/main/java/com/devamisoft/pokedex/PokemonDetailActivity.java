package com.devamisoft.pokedex;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.devamisoft.pokedex.models.PokemonDetail;
import com.devamisoft.pokedex.PokemonRepository;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PokemonDetailActivity extends AppCompatActivity {
    private ImageView pokemonImage;
    private TextView pokemonName;
    private TextView pokemonType;
    private TextView pokemonWeight;

    private PokemonRepository repository;
    private int pokemonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        pokemonImage = findViewById(R.id.pokemonImage);
        pokemonName = findViewById(R.id.pokemonName1);
        pokemonType = findViewById(R.id.pokemonType);
        pokemonWeight = findViewById(R.id.pokemonWeight);

        repository = new PokemonRepository();

        pokemonId = getIntent().getIntExtra("pokemonId", -1);

        if (pokemonId != -1) {
            loadPokemonDetails();
        } else {
        }
    }

    private void loadPokemonDetails() {
        Call<PokemonDetail> call = repository.getPokemonDetails(pokemonId);

        call.enqueue(new Callback<PokemonDetail>() {
            @Override
            public void onResponse(Call<PokemonDetail> call, Response<PokemonDetail> response) {
                if (response.isSuccessful()) {
                    PokemonDetail pokemonDetail = response.body();

                    Log.d("PokemonDetailActivity", "Nombre del Pokémon: " + pokemonDetail.getName());
                    Log.d("PokemonDetailActivity", "Tipo de Pokémon: " + pokemonDetail.getTypes());

                    pokemonName.setText(pokemonDetail.getName());
                    pokemonType.setText(TextUtils.join(", ", pokemonDetail.getTypes()));
                    pokemonWeight.setText("Weight: " + pokemonDetail.getWeight());
                } else {
                    Log.e("PokemonDetailActivity", "Error en la respuesta: " + response.message());
                }
            }


            @Override
            public void onFailure(Call<PokemonDetail> call, Throwable t) {
            }
        });
    }
}
