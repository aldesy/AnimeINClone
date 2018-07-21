package com.example.pier.animeinclone.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.example.pier.animeinclone.AdapterTopAnimeList;
import com.example.pier.animeinclone.RetrofitClientInstance;
import com.example.pier.animeinclone.fragment.RequestFragment;
import com.example.pier.animeinclone.interfaces.MyAnimeListAPI;
import com.example.pier.animeinclone.models.AnimeCallback;
import com.example.pier.animeinclone.models.MALTopAnimeResponse;
import com.example.pier.animeinclone.models.TopAnimeResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopAnimeHelper implements AnimeCallback{

    private RequestFragment rf;
    private Context context;
    private List<TopAnimeResult> listTopAnime;
    private AdapterTopAnimeList mAdapter;

    public TopAnimeHelper(Context context, RequestFragment requestFragment) {
        this.rf = requestFragment;
        this.context = context;
    }

    public void showTopAnime()
    {
        if(rf.isBusy)
            return;
        rf.isBusy = true;
        rf.txtLoading.setVisibility(View.VISIBLE);
        rf.recyclerMal.setVisibility(View.GONE);
        rf.progressBar.setVisibility(View.VISIBLE);
        String BASE_URL = "https://api.jikan.moe/";
        MyAnimeListAPI service = RetrofitClientInstance.getRetrofitTopAnime(BASE_URL).create(MyAnimeListAPI.class);

        Call<MALTopAnimeResponse> responseCall = service.getTopAnime(1);
        responseCall.enqueue(new Callback<MALTopAnimeResponse>() {
            @Override
            public void onResponse(@NonNull Call<MALTopAnimeResponse> call, @NonNull Response<MALTopAnimeResponse> response) {
                try {
                    MALTopAnimeResponse res = response.body();
                    if (res.getRequest_hash() != null && res.getTop().size() > 0) {
                        rf.txtLoading.setVisibility(View.GONE);
                        rf.progressBar.setVisibility(View.GONE);
                        listTopAnime = new ArrayList<>(res.getTop());
                        recycle();
                        rf.isBusy = false;
                    }
                } catch (Exception e) {
                    rf.txtLoading.setVisibility(View.GONE);
                    rf.progressBar.setVisibility(View.GONE);
                    rf.isBusy = false;
                    showTopAnime();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MALTopAnimeResponse> call, @NonNull Throwable t) {
                rf.txtLoading.setVisibility(View.GONE);
                rf.progressBar.setVisibility(View.GONE);
                rf.isBusy = false;
                t.printStackTrace();
            }
        });

    }

    private void recycle() {
        if (mAdapter == null || rf.mLayoutManager == null) {
            mAdapter = new AdapterTopAnimeList(listTopAnime, context, this);
            rf.mLayoutManager = new GridLayoutManager(context, 3);
            rf.recyclerMal.setLayoutManager(rf.mLayoutManager);
            rf.recyclerMal.setItemAnimator(new DefaultItemAnimator());
        }
        rf.recyclerMal.setAdapter(mAdapter);
        mAdapter.setTopAnimeList(listTopAnime);
        mAdapter.notifyDataSetChanged();

        rf.recyclerMal.setVisibility(View.VISIBLE);
        rf.mLayoutManager.smoothScrollToPosition(rf.recyclerMal, null, 0);
    }

    @Override
    public void OnClickListItem(Object data) {

    }
}
