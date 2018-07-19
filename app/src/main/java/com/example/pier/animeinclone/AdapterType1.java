package com.example.pier.animeinclone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pier.animeinclone.models.Anime;
import com.example.pier.animeinclone.models.Animes;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterType1 extends RecyclerView.Adapter<AdapterType1.MyViewHolder>{

    private List<Animes> animeList;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
       // public TextView title, year, genre;
        public ImageView imageView;
        public TextView title, txtViewsCount;

        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.img);
            title = view.findViewById(R.id.txtTitle);
            txtViewsCount = view.findViewById(R.id.txtViews);
        }
    }

    public AdapterType1(List<Animes> animeList, Context context) {
        this.animeList = animeList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_1_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Animes anime = animeList.get(position);
        Picasso.with(context).load(anime.getImage()).into(holder.imageView);
        holder.title.setText(anime.getTitle());
        holder.txtViewsCount.setText(anime.getView() + " views");
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }
}
