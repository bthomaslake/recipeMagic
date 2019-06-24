package com.example.recipemagic.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recipemagic.R;
import com.example.recipemagic.model.Category;
import com.example.recipemagic.model.CategoryList;
import com.example.recipemagic.presenter.CategoryPresenter;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

import java.util.List;

public class CategoryListFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private CategoryPresenter categoryPresenter;
    private List<Category> category;
    private RecyclerView myrv;
    private RecyclerView.Adapter myAdapter;
    private CategoryList categoryList;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CategoryListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CategoryListFragment newInstance(int columnCount) {
        CategoryListFragment fragment = new CategoryListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        categoryList = new CategoryList();
        category = categoryList.getCategories();
        myrv = (RecyclerView) view.findViewById(R.id.recyclerview_category);
        myAdapter = new MyCategoryListRecyclerViewAdapter(getContext(), category);
        myrv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        myrv.setAdapter(myAdapter);
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
