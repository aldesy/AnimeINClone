package com.example.pier.animeinclone;

import com.example.pier.animeinclone.models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface AnimeInterface {
    @Headers("Content-Type: application/json")
    @GET("GetAnimes")
    Call<Result> getResultInfo();

    @GET("GetAnime/{animeid}")
    Call<Result> getAnimeByID(@Path("animeid") int animeid);
}
