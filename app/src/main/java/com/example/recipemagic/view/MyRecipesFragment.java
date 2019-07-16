package com.example.recipemagic.view;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MyRecipePresenter;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

import java.util.Objects;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MyRecipesFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private MyRecipePresenter myRecipePresenter;
    private MainPresenter mainPresenter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MyRecipesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = ((MainActivity) Objects.requireNonNull(getActivity())).getPresenter();
        myRecipePresenter = new MyRecipePresenter(mainPresenter);
    }

    @SuppressWarnings("unused")
    public static MyRecipesFragment newInstance(int columnCount) {
        MyRecipesFragment fragment = new MyRecipesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Code is adapted from
     * https://stackoverflow.com/questions/1016896/get-screen-dimensions-in-pixels#1016941
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myrecipe_list, container, false);
        WindowManager windowManager = (WindowManager) container.getContext().
                getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        RecyclerView myRecipeRecyclerView = view.findViewById(R.id.recyclerview_recipe);
        myRecipeRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        myRecipeRecyclerView.setAdapter(
                new MyRecipeAdapter(myRecipePresenter.readPictureFiles(), mainPresenter));
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
        void onListFragmentInteraction(DummyItem item);
    }
}
