package com.devamisoft.pokedex;

import com.devamisoft.pokedex.models.PokemonDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonDetailService {
    @GET("pokemon/{id}/")
    Call<PokemonDetail> getPokemonDetails(@Path("id") int pokemonId);
}

