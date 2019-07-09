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
import com.example.recipemagic.presenter.CategoryPresenter;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

/**
 * This class is designed to create a fragment view from the list of
 * categories obtained from the API. The needed information is
 * obtained from the CategoryPresenter.
 */
public class CategoryListFragment extends Fragment implements MainPresenter.Listener{

    private OnListFragmentInteractionListener mListener;
    private CategoryPresenter categoryPresenter;
    private MainPresenter presenter;
    private RecyclerView categoryRV;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CategoryListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = ((MainActivity) getActivity()).getPresenter();
        categoryPresenter = new CategoryPresenter(presenter);
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CategoryListFragment newInstance(int columnCount) {
        CategoryListFragment fragment = new CategoryListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * This function creates the view of the fragment. When it is called it
     * inflates, or displays, the fragment_category_list layout into the
     * RecyclerView.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        categoryRV = (RecyclerView) view.findViewById(R.id.recyclerview_category);
        categoryRV.setLayoutManager(new GridLayoutManager(getContext(), 3));
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
     * After the app is done downloading the recipes and categories, this
     * function is called in order to set the adapter.
     */
    @Override
    public void notifyDataReady() {
        categoryRV.setAdapter(new CategoryListAdapter(categoryPresenter.getValidTitles(), categoryPresenter.getValidImages(), presenter));
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}