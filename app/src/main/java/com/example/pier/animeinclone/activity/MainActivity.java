package com.example.pier.animeinclone.activity;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.pier.animeinclone.R;
import com.example.pier.animeinclone.fragment.HomeFragment;
import com.example.pier.animeinclone.fragment.RequestFragment;
import com.example.pier.animeinclone.fragment.ScheduleFragment;
import com.example.pier.animeinclone.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener,
        ScheduleFragment.OnFragmentInteractionListener,
        RequestFragment.OnFragmentInteractionListener{

    private Fragment homeFragment;
    private Fragment searchFragment;
    private Fragment scheduleFragment;
    private Fragment currentFragment;
    private Fragment requestFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        homeFragment = HomeFragment.newInstance("","");
        loadFragment(homeFragment);
    }

    public void SedangHangat(View view)
    {
        ((HomeFragment)homeFragment).OnClickListItem(3);
    }

    public void BaruDirilis(View view)
    {
        ((HomeFragment)homeFragment).OnClickListItem(3);
    }

    public void AnimeHariIni(View view)
    {
        ((HomeFragment)homeFragment).OnClickListItem(3);
    }

    public void Populer(View view)
    {
        ((HomeFragment)homeFragment).OnClickListItem(3);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(!fragment.isAdded())
        {
            transaction.add(R.id.frame_container, fragment);
        }
        else
        {
            transaction.show(fragment);
        }
        if(currentFragment != null && currentFragment != fragment) transaction.hide(currentFragment);
        transaction.commit();
        currentFragment = fragment;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    if(homeFragment == null)  homeFragment = HomeFragment.newInstance("","");
                    loadFragment(homeFragment);
                    return true;
                case R.id.navigation_cari:
                    if(searchFragment == null) searchFragment = SearchFragment.newInstance("","");
                    loadFragment(searchFragment);
                    return true;
                case R.id.navigation_request:
                    if(requestFragment == null) requestFragment = RequestFragment.newInstance("","");
                    loadFragment(requestFragment);
                    return true;
                case R.id.navigation_profile:
                    if(searchFragment == null) searchFragment = SearchFragment.newInstance("","");
                    loadFragment(searchFragment);
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
