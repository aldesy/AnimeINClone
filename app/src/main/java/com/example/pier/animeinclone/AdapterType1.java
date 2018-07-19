package com.example.pier.animeinclone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pier.animeinclone.models.AnimeCallback;
import com.example.pier.animeinclone.models.Animes;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterType1 extends RecyclerView.Adapter<AdapterType1.MyViewHolder>{

    private List<Animes> animeList;
    private Context context;
    private AnimeCallback animeCallback;
    public class MyViewHolder extends RecyclerView.ViewHolder {
       // public TextView title, year, genre;
        public ImageView imageView;
        public TextView title, txtViewsCount, txtStatus;

        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.img);
            title = view.findViewById(R.id.txtTitle);
            txtViewsCount = view.findViewById(R.id.txtViews);
            txtStatus = view.findViewById(R.id.txtStatus);
        }
    }

    public AdapterType1(List<Animes> animeList, Context context, AnimeCallback callback) {
        this.animeList = animeList;
        this.context = context;
        this.animeCallback = callback;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_1_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Animes anime = animeList.get(position);
        Picasso.with(context).load(anime.getImage()).into(holder.imageView);
        holder.title.setText(anime.getTitle());
        holder.txtViewsCount.setText(anime.getView() + " views");

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animeCallback.OnClickItem(Integer.parseInt(anime.getAnimeid()));
            }
        };
        holder.imageView.setOnClickListener(clickListener);
        holder.title.setOnClickListener(clickListener);
        holder.txtViewsCount.setOnClickListener(clickListener);
        holder.txtStatus.setOnClickListener(clickListener);

        if (anime.getStatus().equals("1"))
        {
            holder.txtStatus.setBackgroundColor(context.getResources().getColor(R.color.anime_status_pos));
            holder.txtStatus.setText("ONGOING");
        }
        else
        {
            holder.txtStatus.setBackgroundColor(context.getResources().getColor(R.color.anime_status_neg));
            holder.txtStatus.setText("FINISHED");
        }
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }
}
