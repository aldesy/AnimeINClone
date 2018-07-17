package com.example.pier.animeinclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.pier.animeinclone.models.Anime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  SliderLayout sliderShow;

    private List<Anime> animeList = new ArrayList<>();
    private List<Anime> animeList2 = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterType1 mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderShow = findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<>();
        url_maps.put("Sword Art Online", "https://ae01.alicdn.com/kf/HTB16Xa3jCfD8KJjSszhq6zIJFXaw/DIY-frame-Sword-Art-Online-Light-Novel-Japan-Hot-Comics-Anime-Poster-Landscape-Fabric-Silk-Posters.jpg_640x640.jpg");
        url_maps.put("Bleach", "https://ae01.alicdn.com/kf/HTB1KwuvjBDH8KJjSspnq6zNAVXac/DIY-frame-Bleach-Japan-Classic-Comics-Anime-Poster-Moon-Landscape-Fabric-Silk-Posters-And-Prints-For.jpg_640x640.jpg");

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
                //    .setOnSliderClickListener(this);

            //add your extra information
         //   textSliderView.bundle(new Bundle());
         //   textSliderView.getBundle()
          //          .putString("extra",name);

            sliderShow.addSlider(textSliderView);
        }

        recycleOne();
        recycleTwo();
    }

    private void recycleTwo() {
        RecyclerView recyclerView2 = findViewById(R.id.recyclerview2);
        recyclerView2.setNestedScrollingEnabled(false);
        AdapterType2 mAdapter2 = new AdapterType2(animeList, this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
       // GridLayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(mLayoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(mAdapter2);

        Anime anime = new Anime("https://i.pinimg.com/736x/80/a7/c8/80a7c89a089f14bca45ef79af56e2eac--one-piece--one-piece-manga.jpg");
        animeList2.add(anime);

        anime = new Anime("https://i.pinimg.com/736x/5f/0e/1e/5f0e1ee14de1815649b12dcd3901f577--book-expo-manga-books.jpg");
        animeList2.add(anime);

        anime = new Anime("https://vignette.wikia.nocookie.net/naruto/images/f/fc/Boruto_Vol_1.png/revision/latest?cb=20160807110342");
        animeList2.add(anime);

        mAdapter2.notifyDataSetChanged();
    }

    private void recycleOne() {
        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView.setNestedScrollingEnabled(false);
        mAdapter = new AdapterType1(animeList, this);
       // LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        Anime anime = new Anime("https://i.pinimg.com/736x/80/a7/c8/80a7c89a089f14bca45ef79af56e2eac--one-piece--one-piece-manga.jpg");
        animeList.add(anime);

        anime = new Anime("https://i.pinimg.com/736x/5f/0e/1e/5f0e1ee14de1815649b12dcd3901f577--book-expo-manga-books.jpg");
        animeList.add(anime);

        anime = new Anime("https://vignette.wikia.nocookie.net/naruto/images/f/fc/Boruto_Vol_1.png/revision/latest?cb=20160807110342");
        animeList.add(anime);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
