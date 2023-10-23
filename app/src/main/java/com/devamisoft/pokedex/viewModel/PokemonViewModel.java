package com.devamisoft.pokedex.viewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;

import com.devamisoft.pokedex.PokemonRepository;
import com.devamisoft.pokedex.models.Pokemon;
import java.util.List;

public class PokemonViewModel extends ViewModel {
    private PokemonRepository repository;
    private LiveData<List<Pokemon>> pokemonList;

    public PokemonViewModel() {
        repository = new PokemonRepository();
        pokemonList = repository.getPokemonList(40);
    }

    public LiveData<List<Pokemon>> getPokemonList() {
        return pokemonList;
    }
}

