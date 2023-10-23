package com.devamisoft.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.devamisoft.pokedex.adapters.PokemonAdapter;
import com.devamisoft.pokedex.viewModel.PokemonViewModel;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;


public class PokemonListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new PokemonAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        PokemonViewModel viewModel = new ViewModelProvider(this).get(PokemonViewModel.class);
        viewModel.getPokemonList().observe(this, pokemonList -> {
            adapter.setData(pokemonList);
        });
    }
}
