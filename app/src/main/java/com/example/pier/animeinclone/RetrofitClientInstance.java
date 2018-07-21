package com.example.pier.animeinclone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofitAnime;
    private static Retrofit retrofitMAL;
    private static Retrofit retrofitTopAnime;
   // private static final String BASE_URL = "https://api.anime.aldesy.me/app2/API/";
    public static Retrofit getRetrofitTopAnime(String BASE_URL)
    {
        if(retrofitTopAnime == null) retrofitTopAnime = init(BASE_URL);
        return retrofitTopAnime;
    }
    public static Retrofit getRetrofitInstance(String BASE_URL) {
        if(retrofitAnime == null) retrofitAnime = init(BASE_URL);
        return retrofitAnime;
    }
    public static Retrofit getRetrofitMALInstance(String BASE_URL) {
        if(retrofitMAL == null) retrofitMAL = init(BASE_URL);
        return retrofitMAL;
    }

    private static Retrofit init(String BASE_URL) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit newRetro = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return newRetro;
    }
}