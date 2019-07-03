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


import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.presenter.SearchPresenter;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

public class SearchFragment extends Fragment{

    private SearchFragment.OnListFragmentInteractionListener mListener;
    private SearchPresenter searchPresenter;
    private MainPresenter presenter;
    private RecyclerView searchRV;
    private Boolean clickedSearchRecipe;
    private SearchAdapter searchAdapter;
    private String compare;

    public SearchFragment() {
    }

    // TODO: Customize parameter initialization
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
        compare = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_list, container, false);
        Button searchRecipe = (Button) view.findViewById(R.id.button);
        Button searchMyRecipe = (Button) view.findViewById(R.id.button2);
        final EditText editText = (EditText) view.findViewById(R.id.editText);

        searchRecipe.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String term = editText.getText().toString();
                if (compare == null){
                    compare = term;
                }
                searchPresenter.searchDataBase(term);

                if (!clickedSearchRecipe){
                    searchAdapter = new SearchAdapter(searchPresenter.getRecipeTitles(), searchPresenter.getRecipeImages(),
                            searchPresenter.getRecipeIngredients(), searchPresenter.getRecipeDirections());
                    clickedSearchRecipe = true;
                    searchRV.setAdapter(searchAdapter);
                }else if (compare.equals(term)) {
                    int count1 = searchAdapter.getItemCount();
                    int count2 = searchAdapter.getItemCount();
                    searchAdapter.clear();
                    for (int i = 0; i < count1; i++) {
                        searchAdapter.notifyItemRemoved(i);
                        searchAdapter.notifyItemRangeChanged(i, count2);
                        count2--;
                    }
                        searchAdapter.setTitles(searchPresenter.getRecipeTitles());
                        searchAdapter.setImages(searchPresenter.getRecipeImages());
                        searchAdapter.setDirections(searchPresenter.getRecipeDirections());
                        searchAdapter.setIngredients(searchPresenter.getRecipeIngredients());
                        compare = term;
                }
            }
        });

        searchMyRecipe.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String term = editText.getText().toString();
                searchPresenter.searchDataBase(term);
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
