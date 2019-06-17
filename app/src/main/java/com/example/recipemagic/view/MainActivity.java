package com.example.recipemagic.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.R;
import androidx.appcompat.app.ActionBar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.R;
import com.example.recipemagic.view.dummy.DummyContent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements AddRecipe.OnFragmentInteractionListener,
        FavoritesFragment.OnListFragmentInteractionListener,
        Timer.OnFragmentInteractionListener {


    private ViewPager viewPager;
    private CollectionPagerAdapter adapter;
    private MainPresenter presenter;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();

        presenter = new MainPresenter();
        adapter = new CollectionPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.fragment);
        viewPager.setAdapter(adapter);

        loadFragment(R.id.menu_search);

        BottomNavigationView bnv = findViewById(R.id.navigation);

        bnv.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                loadFragment(item.getItemId());
                return true;
            }
        });
    }


    private void loadFragment(int menuId) {
        switch (menuId) {
            case R.id.menu_search :
                viewPager.setCurrentItem(0);
                actionBar.setTitle("Search Recipes");
                break;
        }
    }

    public MainPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        /* This function must be implemented in every
         * class that wants to use a fragment. It does not need to be
         * used, but it can make it possible to communicate between fragments.
         * Information from
         * https://stackoverflow.com/questions/24777985/how-to-implement-onfragmentinteractionlistener#27666001
         */

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        // I think this can be gotten rid of when we have all fragments implemented.
    }

    private class CollectionPagerAdapter extends FragmentPagerAdapter {

        public CollectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment;

        switch(i) {
            case 0:
                fragment = new AddRecipe();
                break;
            case 1:
                fragment = new FavoritesFragment();
                break;
            case 2:
                fragment = new Timer();
                break;

            default:
                fragment = null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

}