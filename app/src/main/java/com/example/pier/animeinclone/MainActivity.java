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
import android.view.View;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener,
        ScheduleFragment.OnFragmentInteractionListener{

    private Fragment homeFragment;
    private Fragment searchFragment;
    private Fragment scheduleFragment;
    private Fragment currentFragment;

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
