package com.example.pier.animeinclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pier.animeinclone.models.AnimeCallback;
import com.example.pier.animeinclone.models.TopAnimeResult;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdapterTopAnimeList extends RecyclerView.Adapter<AdapterTopAnimeList.MyViewHolder> {



    private List<TopAnimeResult> topAnimeList;
    private Context context;
    private AnimeCallback animeCallback;

    public AdapterTopAnimeList(List<TopAnimeResult> myanimeList, Context context, AnimeCallback animeCallback) {
        this.topAnimeList = myanimeList;
        this.context = context;
        this.animeCallback = animeCallback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_top_anime_list, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        TopAnimeResult mal = topAnimeList.get(i);
        Picasso.with(context).load(mal.getImage_url()).into(myViewHolder.imgAnime);
        myViewHolder.txtTitle.setText(mal.getTitle());
    }

    @Override
    public int getItemCount() {
        return topAnimeList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        @OnClick(R.id.mainLayout)
        public void onViewClicked() {
            animeCallback.OnClickListItem(0);
        }
        @BindView(R.id.mainLayout)
        ConstraintLayout mainLayout;
        @BindView(R.id.imgAnime)
        ImageView imgAnime;
        @BindView(R.id.txtTitle)
        TextView txtTitle;

        private MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setTopAnimeList(List<TopAnimeResult> topAnimeList) {
        this.topAnimeList = topAnimeList;
    }
}
