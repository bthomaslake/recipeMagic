package com.example.recipemagic.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.presenter.SearchPresenter;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

/**
 * This class implements the search feature within the application.
 * It creates the initial view of the fragment and also displays
 * the recipes that are given based on the searched term.
 */
public class SearchFragment extends Fragment{

    private SearchFragment.OnListFragmentInteractionListener mListener;
    private SearchPresenter searchPresenter;
    private MainPresenter presenter;
    private RecyclerView searchRV;
    private Boolean clickedSearchRecipe;
    private Boolean clickedSearchMyRecipe;
    private SearchAdapter searchAdapterRecipes;
    private SearchAdapter searchAdapterMyRecipes;

    public SearchFragment() {
    }

    @SuppressWarnings("unused")
    public static SearchFragment newInstance(int columnCount) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = ((MainActivity) getActivity()).getPresenter();
        searchPresenter = new SearchPresenter(presenter);
        clickedSearchRecipe = false;
        clickedSearchMyRecipe = false;
    }

    /**
     * This function is designed to set the onClickListeners for the search buttons.
     * The recyclerview is cleared when the user clicks the search buttons so that
     * only the desired recipes are shown.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_list, container, false);
        Button searchRecipe = (Button) view.findViewById(R.id.button);
        Button searchMyRecipe = (Button) view.findViewById(R.id.button2);
        final EditText editText = (EditText) view.findViewById(R.id.editText);

        searchRecipe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (presenter.isBookReady()) {
                    String term = editText.getText().toString();
                    searchPresenter.searchDataBase(term);
                    if (!clickedSearchRecipe) {
                        searchAdapterRecipes = new SearchAdapter(searchPresenter.getRecipeTitles(), searchPresenter.getRecipeImages(),
                                searchPresenter.getRecipeIngredients(), searchPresenter.getRecipeDirections());
                        searchRV.setAdapter(searchAdapterRecipes);
                        clickedSearchRecipe = true;
                    } else {
                        searchRV.setAdapter(searchAdapterRecipes);
                        int count1 = searchAdapterRecipes.getItemCount();
                        int count2 = searchAdapterRecipes.getItemCount();
                        searchAdapterRecipes.clear();
                        for (int i = 0; i < count1; i++) {
                            searchAdapterRecipes.notifyItemRemoved(i);
                            searchAdapterRecipes.notifyItemRangeChanged(i, count2);
                            count2--;
                        }
                        searchAdapterRecipes.setTitles(searchPresenter.getRecipeTitles());
                        searchAdapterRecipes.setIngredients(searchPresenter.getRecipeIngredients());
                        searchAdapterRecipes.setImages(searchPresenter.getRecipeImages());
                        searchAdapterRecipes.setDirections(searchPresenter.getRecipeDirections());

                    }
                } else {
                    Toast.makeText(getContext(), "Cannot search database until all recipes are loaded!", Toast.LENGTH_LONG).show();
                }
            }
        });

        searchMyRecipe.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String term = editText.getText().toString();
                searchPresenter.searchMyrecipes(term);
                if (!clickedSearchMyRecipe){
                    searchAdapterMyRecipes = new SearchAdapter(searchPresenter.getMyRecipes());
                    clickedSearchMyRecipe = true;
                    searchRV.setAdapter(searchAdapterMyRecipes);
                }else{
                    searchRV.setAdapter(searchAdapterMyRecipes);
                    int count1 = searchAdapterMyRecipes.getItemCount();
                    int count2 = searchAdapterMyRecipes.getItemCount();
                    for (int i = 0; i < count1; i++) {
                        searchAdapterMyRecipes.notifyItemRemoved(i);
                        searchAdapterMyRecipes.notifyItemRangeChanged(i, count2);
                        count2--;
                    }
                    searchAdapterMyRecipes.setMyRecipes(searchPresenter.getMyRecipes());
                }
            }
        });

        searchRV = (RecyclerView) view.findViewById(R.id.recyclerview_search);
        searchRV.setLayoutManager(new GridLayoutManager(getContext(), 3));
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

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
