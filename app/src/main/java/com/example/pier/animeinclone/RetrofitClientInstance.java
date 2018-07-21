package com.example.pier.animeinclone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofitAnime;
    private static Retrofit retrofitMAL;
   // private static final String BASE_URL = "https://api.anime.aldesy.me/app2/API/";

    public static Retrofit getRetrofitInstance(String BASE_URL) {
        if (retrofitAnime == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofitAnime = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofitAnime;
    }

    public static Retrofit getRetrofitMALInstance(String BASE_URL) {
        if (retrofitMAL == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofitMAL = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofitMAL;
    }
}