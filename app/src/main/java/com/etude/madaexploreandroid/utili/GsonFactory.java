package com.etude.madaexploreandroid.utili;

import com.etude.madaexploreandroid.utili.jsonAdapter.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

public class GsonFactory {
    public static Gson create() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        return gson;
    }
}
