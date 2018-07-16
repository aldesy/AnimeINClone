package com.example.pier.animeinclone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pier.animeinclone.models.Anime;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterType1 extends RecyclerView.Adapter<AdapterType1.MyViewHolder>{

    private List<Anime> animeList;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
       // public TextView title, year, genre;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.img);
        }
    }

    public AdapterType1(List<Anime> animeList, Context context) {
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
        Anime anime = animeList.get(position);
        Picasso.with(context).load(anime.getImagelink()).into(holder.imageView);
      //  holder.title.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }
}
