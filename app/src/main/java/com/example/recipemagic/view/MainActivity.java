package com.example.recipemagic.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import android.preference.PreferenceManager;
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
        Timer.OnFragmentInteractionListener,
        CategoryList.OnFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener {

    private ViewPager viewPager;
    private CollectionPagerAdapter adapter;
    private MainPresenter presenter;
    private ActionBar actionBar;
    private int currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();

        presenter = new MainPresenter();
        adapter = new CollectionPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.fragment);
        viewPager.setAdapter(adapter);
        SharedPreferences fragmentSave = PreferenceManager.getDefaultSharedPreferences(this);
        currentFragment = fragmentSave.getInt("currentFragment", 0);
        switch (currentFragment) {
            case 0 :
                viewPager.setCurrentItem(0);
                actionBar.setTitle("Categories");
                break;
            case 1 :
                viewPager.setCurrentItem(1);
                actionBar.setTitle("Timer");
                break;
            case 2 :
                viewPager.setCurrentItem(2);
                actionBar.setTitle("Favorites");
                break;
            case 3 :
                viewPager.setCurrentItem(3);
                actionBar.setTitle("Search");
                break;
            case 4 :
                viewPager.setCurrentItem(4);
                actionBar.setTitle("Add Recipe");
                break;
        }
        //loadFragment(R.id.menu_category);

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

    protected void onStop() {
        super.onStop();

        SharedPreferences fragmentSave = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor fragmentEdit = fragmentSave.edit();

        fragmentEdit.putInt("currentFragment", currentFragment);
        fragmentEdit.apply();
    }


    private void loadFragment(int menuId) {
        switch (menuId) {
            case R.id.menu_category :
                viewPager.setCurrentItem(0);
                actionBar.setTitle("Categories");
                currentFragment = 0;
                break;
            case R.id.menu_timer :
                viewPager.setCurrentItem(1);
                actionBar.setTitle("Timer");
                currentFragment = 1;
                break;
            case R.id.menu_favorites :
                viewPager.setCurrentItem(2);
                actionBar.setTitle("Favorites");
                currentFragment = 2;
                break;
            case R.id.menu_search :
                viewPager.setCurrentItem(3);
                actionBar.setTitle("Search");
                currentFragment = 3;
                break;
            case R.id.menu_add :
                viewPager.setCurrentItem(4);
                actionBar.setTitle("Add Recipe");
                currentFragment = 4;
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
        /* This function must be implemented in every
         * class that wants to use a fragment. It does not need to be
         * used, but it can make it possible to communicate between fragments.
         * Information from
         * https://stackoverflow.com/questions/24777985/how-to-implement-onfragmentinteractionlistener#27666001
         */
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
                    fragment = new CategoryList();
                    break;
                case 1:
                    fragment = new Timer();
                    break;
                case 2:
                    fragment = new FavoritesFragment();
                    break;
                case 3:
                    fragment = new SearchFragment();
                    break;
                case 4:
                    fragment = new AddRecipe();
                    break;
                default:
                    fragment = null;
            }
        return fragment;
        }


    /*
     * This is the number of fragments that will be seen by the activity. The order
     * is determined by the getItem() function above.
     */
    @Override
    public int getCount() {
        return 5;
    }
}

}