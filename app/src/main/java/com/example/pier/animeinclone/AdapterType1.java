package com.example.pier.animeinclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.pier.animeinclone.models.AnimeCallback;
import com.example.pier.animeinclone.models.Animes;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterType1 extends RecyclerView.Adapter<AdapterType1.MyViewHolder> {
    private List<Animes> animeList;
    private Context context;
    private AnimeCallback animeCallback;

    private class MyViewHolder extends RecyclerView.ViewHolder {
        // public TextView title, year, genre;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.txtStatus)
        TextView txtStatus;
        @BindView(R.id.txtGenre)
        TextView txtGenre;
        @BindView(R.id.txtTitle)
        TextView txtTitle;
        @BindView(R.id.txtViews)
        TextView txtViews;

        private MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private AdapterType1(List<Animes> animeList, Context context, AnimeCallback callback) {
        this.animeList = animeList;
        this.context = context;
        this.animeCallback = callback;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_1_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Animes anime = animeList.get(position);
        Picasso.with(context).load(anime.getImage()).into(holder.img);
        holder.txtTitle.setText(anime.getTitle());
        String viewcount = anime.getView() + " views";
        holder.txtViews.setText(viewcount);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animeCallback.OnClickItem(Integer.parseInt(anime.getAnimeid()));
            }
        };
        holder.img.setOnClickListener(clickListener);
        holder.txtTitle.setOnClickListener(clickListener);
        holder.txtViews.setOnClickListener(clickListener);
        holder.txtStatus.setOnClickListener(clickListener);

        if (anime.getStatus().equals("1")) {
            holder.txtStatus.setBackgroundColor(context.getResources().getColor(R.color.anime_status_pos));
            holder.txtStatus.setText("ONGOING");
        } else {
            holder.txtStatus.setBackgroundColor(context.getResources().getColor(R.color.anime_status_neg));
            holder.txtStatus.setText("FINISHED");
        }

        holder.ratingBar.setRating(anime.getRating());

    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }


}
