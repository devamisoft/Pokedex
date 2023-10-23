package com.devamisoft.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

public class PokemonParcelable implements Parcelable {
    private int id;
    private String name;
    private String url;
    private String imageUrl;


    protected PokemonParcelable(Parcel in) {
        id = in.readInt();
        name = in.readString();
        url = in.readString();
        imageUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PokemonParcelable> CREATOR = new Creator<PokemonParcelable>() {
        @Override
        public PokemonParcelable createFromParcel(Parcel in) {
            return new PokemonParcelable(in);
        }

        @Override
        public PokemonParcelable[] newArray(int size) {
            return new PokemonParcelable[size];
        }
    };

}
