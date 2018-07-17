package com.example.pier.animeinclone;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener,
        ScheduleFragment.OnFragmentInteractionListener{

    private Fragment homeFragment;
    private Fragment searchFragment;
    private Fragment scheduleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        homeFragment = HomeFragment.newInstance("","");
        searchFragment = SearchFragment.newInstance("","");
        scheduleFragment = ScheduleFragment.newInstance("","");

        loadFragment(homeFragment);
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
                    fragment = homeFragment;
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cari:
                    fragment = searchFragment;
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_schedule:
                    fragment = scheduleFragment;
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    fragment = searchFragment;
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
    }


}
