package com.example.recipemagic.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.presenter.RecipeListPresenter;
import com.example.recipemagic.view.MainActivity;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

public class RecipeFragment extends Fragment implements MainPresenter.Listener{

    private com.example.recipemagic.view.RecipeListFragment.OnListFragmentInteractionListener mListener;
    private RecipeListPresenter recipePresenter;
    private MainPresenter presenter;
    private RecyclerView recipeRV;
    private String title;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecipeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = ((MainActivity) getActivity()).getPresenter();
        recipePresenter = new RecipeListPresenter(presenter);
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static com.example.recipemagic.view.RecipeListFragment newInstance(int columnCount) {
        com.example.recipemagic.view.RecipeListFragment fragment = new com.example.recipemagic.view.RecipeListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        Bundle bundle = this.getArguments();
        if(bundle != null) {
            title = bundle.get("Title").toString();
        }
        recipeRV = (RecyclerView) view.findViewById(R.id.recyclerview_recipe);
        recipeRV.setLayoutManager(new GridLayoutManager(getContext(), 3));
        presenter.registerDataUser(this);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof com.example.recipemagic.view.RecipeListFragment.OnListFragmentInteractionListener) {
            mListener = (com.example.recipemagic.view.RecipeListFragment.OnListFragmentInteractionListener) context;
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
        recipeRV.setAdapter(new RecipeAdapter(recipePresenter.getValidTitles(title),
                recipePresenter.getValidImages(title),
                recipePresenter.getValidIngredients(title),
                recipePresenter.getValidDirections(title)));
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
