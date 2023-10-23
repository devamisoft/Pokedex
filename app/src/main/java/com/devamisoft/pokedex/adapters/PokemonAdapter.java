package com.devamisoft.pokedex.adapters;
import com.devamisoft.pokedex.R;
import androidx.recyclerview.widget.RecyclerView;

import com.devamisoft.pokedex.models.Pokemon;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private List<Pokemon> pokemonList = new ArrayList<>();

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public void setData(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder {
        private ImageView pokemonImage;
        private TextView pokemonName;

        PokemonViewHolder(View itemView) {
            super(itemView);
            pokemonImage = itemView.findViewById(R.id.pokemonImage);
            pokemonName = itemView.findViewById(R.id.pokemonName);
        }

        void bind(Pokemon pokemon) {
            String imageUrl = pokemon.getImageUrl();
            Picasso.get().load(imageUrl).into(pokemonImage);
            pokemonName.setText(pokemon.getName());
        }
    }
}
