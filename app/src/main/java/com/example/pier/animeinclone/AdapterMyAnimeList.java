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
import com.example.pier.animeinclone.models.MALResult;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class AdapterMyAnimeList extends RecyclerView.Adapter<AdapterMyAnimeList.MyViewHolder> {



    private List<MALResult> myanimeList;
    private Context context;
    private AnimeCallback animeCallback;

    public AdapterMyAnimeList(List<MALResult> myanimeList, Context context, AnimeCallback animeCallback) {
        this.myanimeList = myanimeList;
        this.context = context;
        this.animeCallback = animeCallback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_myanimelist, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        MALResult mal = myanimeList.get(i);
        Picasso.with(context).load(mal.getImage_url()).into(myViewHolder.imgAnime);
        myViewHolder.txtTitle.setText(mal.getTitle());
        myViewHolder.txtScore.setText(mal.getScore()+"/10");
        String info = mal.getType()+", "+mal.getEpisodes().toString()+" Eps";
        myViewHolder.txtType.setText(info);
    }

    @Override
    public int getItemCount() {
        return myanimeList.size();
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
        @BindView(R.id.ratingBar)
        MaterialRatingBar ratingBar;
        @BindView(R.id.txtScore)
        TextView txtScore;
        @BindView(R.id.txtType)
        TextView txtType;

        private MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setMyanimeList(List<MALResult> myanimeList) {
        this.myanimeList = myanimeList;
    }
}
