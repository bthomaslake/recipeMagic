package com.example.recipemagic.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.presenter.RecipeListPresenter;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

import java.util.Objects;

/**
 * This function is used to display a list of recipes based on the category
 * that the user selects.
 */
public class RecipeListFragment extends Fragment implements MainPresenter.Listener{

    private OnListFragmentInteractionListener mListener;
    private RecipeListPresenter recipePresenter;
    private MainPresenter presenter;
    private RecyclerView recipeRV;
    private String category;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecipeListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = ((MainActivity) Objects.requireNonNull(getActivity())).getPresenter();
        recipePresenter = new RecipeListPresenter(presenter);
    }

    @SuppressWarnings("unused")
    public static RecipeListFragment newInstance(int columnCount) {
        RecipeListFragment fragment = new RecipeListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipelist_list, container, false);
        Bundle bundle = this.getArguments();
        if(bundle != null) {
            category = Objects.requireNonNull(bundle.get("Category")).toString();
        }
        recipeRV = (RecyclerView) view.findViewById(R.id.recyclerview_recipe);
        recipeRV.setLayoutManager(new GridLayoutManager(getContext(), 3));
        presenter.registerDataUser(this);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This function sets the recyclerview adapter after the app is done downloading
     * all of the recipes.
     */
    @Override
    public void notifyDataReady() {
        recipeRV.setAdapter(new RecipeListAdapter(recipePresenter.getValidTitles(category),
                recipePresenter.getValidImages(category), recipePresenter.getValidDirections(category),
                recipePresenter.getValidIngredients(category)));
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(DummyItem item);
    }
}