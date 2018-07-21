package com.example.pier.animeinclone.interfaces;

import com.example.pier.animeinclone.models.MALResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyAnimeListAPI {
    @GET("search/anime/{query}/{page}")
    Call<MALResponse> searchAnime(
            @Path("query") String query,
            @Path("page") int page);
}
