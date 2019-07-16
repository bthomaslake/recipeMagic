package com.example.recipemagic.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.recipemagic.R;
import com.squareup.picasso.Picasso;

import java.io.File;


/**
 * This class is designed to display the recipes that are
 * added into the app by the user.
 */
public class MyRecipe extends Fragment {

    private OnFragmentInteractionListener mListener;

    public MyRecipe() {
        // Required empty public constructor
    }

    @SuppressWarnings("unused")
    public static MyRecipe newInstance() { ;
        MyRecipe fragment = new MyRecipe();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_recipe, container, false);
        Bundle bundle = this.getArguments();
        if(bundle != null) {
            File image = new File(bundle.getString("Recipe"));
             Picasso
                     .get()
                     .load(image)
                     .fit()
                     .into((ImageView) view.findViewById(R.id.my_recipe_picture));
        }

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @SuppressWarnings("unused")
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
