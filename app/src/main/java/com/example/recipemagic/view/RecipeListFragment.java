package com.example.recipemagic.view;

import android.content.Context;
import android.os.Bundle;

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
        presenter = ((MainActivity) getActivity()).getPresenter();
        recipePresenter = new RecipeListPresenter(presenter);
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RecipeListFragment newInstance(int columnCount) {
        RecipeListFragment fragment = new RecipeListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipelist_list, container, false);
        Bundle bundle = this.getArguments();
        if(bundle != null) {
            category = bundle.get("Category").toString();
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

    @Override
    public void notifyDataReady() {
        recipeRV.setAdapter(new RecipeListAdapter(recipePresenter.getValidTitles(category),
                recipePresenter.getValidImages(category), recipePresenter.getValidDirections(category),
                recipePresenter.getValidIngredients(category)));
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}