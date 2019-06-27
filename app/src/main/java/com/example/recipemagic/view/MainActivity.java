package com.example.recipemagic.view;

import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.R;

import com.example.recipemagic.view.dummy.DummyContent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
        implements AddRecipe.OnFragmentInteractionListener,
        MyRecipesFragment.OnListFragmentInteractionListener,
        Timer.OnFragmentInteractionListener,
        CategoryListFragment.OnListFragmentInteractionListener,
        SearchFragment.OnFragmentInteractionListener,
        RecipeListFragment.OnListFragmentInteractionListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Standard beginning
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        loadFragment(new CategoryListFragment());
        BottomNavigationView bnv = findViewById(R.id.navigation);

        bnv.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        // switch fragment based on input
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public MainPresenter getPresenter() {
        return presenter;
    }


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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.menu_category:
                fragment = new CategoryListFragment();
                break;
            case R.id.menu_timer:
                fragment = new Timer();
                break;
            case R.id.menu_favorites:
                fragment = new MyRecipesFragment();
                break;
            case R.id.menu_search:
                fragment = new SearchFragment();
                break;
            case R.id.menu_add:
                fragment = new AddRecipe();
                break;
        }
        return loadFragment(fragment);
    }
}