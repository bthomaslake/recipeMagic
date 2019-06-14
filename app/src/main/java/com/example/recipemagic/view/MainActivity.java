package com.example.recipemagic.view;

import android.content.Context;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MainPresenter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private ViewPager;
    private CollactionPagerAdapter adapter;
    private MainPresenter presenter;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();

        presenter = new MainPresenter(this);

        adapter = new CollectionPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.fragment);
        loadFragment(R.id.menu_browse);

        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.navigation);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                loadFragment(item.getItemId());
                return true;
            }
        });
    }


    private void loadFragment(int menuId) {
        switch (menuId) {
            case R.id.menu_browse :
                viewPager.setCurrentItem(0);
                actionBar.setTitle("Browse Scriptures");
                break;
            case R.id.menu_search :
                viewPager.setCurrentItem(1);
                actionBar.setTitle("Search Scriptures");
                break;
            case R.id.menu_favorites :
                viewPager.setCurrentItem(2);
                actionBar.setTitle("Favorite Scriptures");
                break;
        }
    }

    public MainPresenter getPresenter() {
        return presenter;
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