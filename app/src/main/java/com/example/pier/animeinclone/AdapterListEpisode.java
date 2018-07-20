package com.example.pier.animeinclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pier.animeinclone.models.AnimeCallback;
import com.example.pier.animeinclone.models.Episode;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterListEpisode extends RecyclerView.Adapter<AdapterListEpisode.MyViewHolder> {

    private List<Episode> episodeList;
    private Context context;
    private AnimeCallback animeCallback;

    public AdapterListEpisode(List<Episode> episodeList, Context context, AnimeCallback animeCallback) {
        this.episodeList = episodeList;
        this.context = context;
        this.animeCallback = animeCallback;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imgThumbnail)
        ImageView imgThumbnail;
        @BindView(R.id.txtTitle)
        TextView txtTitle;

        private MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_list_episode, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Episode episode = episodeList.get(position);
        Picasso.with(context).load(episode.getThumbnail()).into(holder.imgThumbnail);
        holder.txtTitle.setText(episode.getTitle());
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return episodeList.size();
    }


}
