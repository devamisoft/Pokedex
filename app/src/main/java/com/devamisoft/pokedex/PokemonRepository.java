package com.devamisoft.pokedex;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devamisoft.pokedex.models.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PokemonRepository {
    private PokemonService service;

    public PokemonRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PokemonService.class);
    }

    public LiveData<List<Pokemon>> getPokemonList(int limit) {
        MutableLiveData<List<Pokemon>> data = new MutableLiveData<>();

        service.getPokemonList(limit).enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body().getResults());
                    Log.d("PokemonRepository", "Solicitud exitosa. Datos recibidos: " + response.body().getResults());
                } else {
                    Log.e("PokemonRepository", "Error en la solicitud: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e("PokemonRepository", "Error en la solicitud: " + t.getMessage());
            }
        });

        return data;
    }
}

