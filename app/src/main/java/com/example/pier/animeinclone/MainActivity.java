package com.example.pier.animeinclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private  SliderLayout sliderShow;
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
    }

    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}
