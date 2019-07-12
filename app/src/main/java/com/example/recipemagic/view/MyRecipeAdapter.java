package com.example.recipemagic.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.presenter.MyRecipePresenter;
import com.example.recipemagic.view.MyRecipesFragment.OnListFragmentInteractionListener;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRecipeAdapter extends RecyclerView.Adapter<MyRecipeAdapter.ViewHolder> {

    private final List<Bitmap> pictures;
    private final List<String> pictureNames;
    ImageView imageView;

    public MyRecipeAdapter(Map<String, Bitmap> pictureFiles, MainPresenter mainPresenter) {
        pictures = new ArrayList<>();
        pictureNames = new ArrayList<>();
        for (String key : pictureFiles.keySet()) {
            pictures.add(pictureFiles.get(key));
            pictureNames.add(key);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_myrecipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        holder.recipePicture.setImageBitmap(pictures.get(i));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Passing data to MyRecipe fragment
                Bundle bundle = new Bundle();
                bundle.putString("Recipe", pictureNames.get(i));

                Fragment fragment = new MyRecipe();
                fragment.setArguments(bundle);

                // Start Fragment
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;
        ImageView recipePicture;
        CardView cardView;

        public ViewHolder(View view) {
            super(view);
            recipeName = itemView.findViewById(R.id.myRecipe_title);
            recipePicture = itemView.findViewById(R.id.myRecipe_Img);
            cardView = itemView.findViewById(R.id.cardview_myRecipe);
        }
    }
}
