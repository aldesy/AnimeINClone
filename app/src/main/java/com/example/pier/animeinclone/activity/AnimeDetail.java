package com.example.pier.animeinclone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.pier.animeinclone.AnimeInterface;
import com.example.pier.animeinclone.R;
import com.example.pier.animeinclone.RetrofitClientInstance;
import com.example.pier.animeinclone.models.Animes;
import com.example.pier.animeinclone.models.Result;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeDetail extends AppCompatActivity {

    @BindView(R.id.imgBackground)
    ImageView imgBackground;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.txtJumlahRate)
    TextView txtJumlahRate;
    @BindView(R.id.txtSinopsis)
    TextView txtSinopsis;
    @BindView(R.id.txtSelengkapnya)
    TextView txtSelengkapnya;
    @BindView(R.id.txtJumlahView)
    TextView txtJumlahView;
    @BindView(R.id.recyclerEpisode)
    RecyclerView recyclerEpisode;
    @BindView(R.id.txtStatus)
    TextView txtStatus;
    private Animes anime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                    if (res.getSuccess() && res.getData().size() > 0) {
                        anime = res.getData().get(0);
                        txtTitle.setText(anime.getTitle());
                        txtSinopsis.setText(anime.getSinopsis());
                        txtJumlahView.setText(anime.getView()+" Views");

                        if (anime.getStatus().equals("1"))
                        {
                            txtStatus.setBackgroundColor(getResources().getColor(R.color.anime_status_pos));
                            txtStatus.setText("ONGOING");
                        }
                        else
                        {
                            txtStatus.setBackgroundColor(getResources().getColor(R.color.anime_status_neg));
                            txtStatus.setText("FINISHED");
                        }
                        Picasso.with(AnimeDetail.this).load(anime.getImgbackground()).into(imgBackground);
                        //setBackgroundActivity();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @OnClick(R.id.txtSelengkapnya)
    public void onViewClicked() {
    }
}
