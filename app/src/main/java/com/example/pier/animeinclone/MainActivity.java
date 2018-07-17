package com.example.pier.animeinclone;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.pier.animeinclone.models.Anime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener{

    private  SliderLayout sliderShow;

    private List<Anime> animeList = new ArrayList<>();
    private List<Anime> animeList2 = new ArrayList<>();
    private List<Anime> animeList3 = new ArrayList<>();
    private List<Anime> animeList4 = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterType1 mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        loadFragment(HomeFragment.newInstance("",""));
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    fragment = HomeFragment.newInstance("","");
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cari:
                    fragment = SearchFragment.newInstance("","");
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                    fragment = SearchFragment.newInstance("","");
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    fragment = SearchFragment.newInstance("","");
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onStop() {
        try
        {
            sliderShow.stopAutoCycle();
        }catch (NullPointerException e)
        {

        }
        super.onStop();
    }
}
