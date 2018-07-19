package com.example.pier.animeinclone.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pier.animeinclone.AnimeInterface;
import com.example.pier.animeinclone.R;
import com.example.pier.animeinclone.RetrofitClientInstance;
import com.example.pier.animeinclone.models.Animes;
import com.example.pier.animeinclone.models.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeDetail extends AppCompatActivity {

    private Animes anime;

    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);

        txtTitle = findViewById(R.id.txtTitle);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        getAnimeByID(bundle.getInt("animeid"));
    }

    private void getAnimeByID(final int animeid) {

        AnimeInterface service = RetrofitClientInstance.getRetrofitInstance().create(AnimeInterface.class);

        Call<Result> result = service.getAnimeByID(animeid);
        result.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                try {
                    Result res = response.body();
                    if(res.getSuccess() && res.getData().size() > 0)
                    {
                        anime = res.getData().get(0);
                        txtTitle.setText(anime.getTitle());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
