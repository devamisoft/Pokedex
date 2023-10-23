package com.devamisoft.pokedex;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface PokemonService {
    @GET("pokemon?limit=40")
    Call<PokemonResponse> getPokemonList(@Query("limit") int limit);
}
