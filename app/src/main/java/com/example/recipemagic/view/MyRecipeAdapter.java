package com.example.recipemagic.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.view.MyRecipesFragment.OnListFragmentInteractionListener;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

/**
 * This class handles the presentation of as many recipes as are available in a grid list.
 */
public class MyRecipeAdapter extends RecyclerView.Adapter<MyRecipeAdapter.ViewHolder> {

    private final List<File> pictureFiles;
    private Context context;

    /**
     *
     * @param pictureFiles All of the pictures in the picture directory
     * @param mainPresenter Potentially used for a local MyRecipe presenter
     */
    public MyRecipeAdapter(List<File> pictureFiles, MainPresenter mainPresenter) {
        this.pictureFiles = pictureFiles;
        context = mainPresenter.getContext();
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_myrecipe, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Handles each of the recipes that need to be presented. Picasso does the heavy lifting
     * and only pulls a small thumbnail for this list using fit() so the memory won't be
     * swamped.
     * @param holder
     * @param i
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
            String fileName = pictureFiles.get(i).getName();
            Picasso.get()
                    .load(pictureFiles.get(i))
                    .fit()
                    .into(holder.recipePicture);
            holder.recipeName.setText(fileName.substring(0, fileName.length() - 4));

        /**
         * Handles the action of clicking on a recipe. Passes information to the MyRecipe
         * fragment to display a single recipe.
         */
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Passing data to MyRecipe fragment
                Bundle bundle = new Bundle();
                bundle.putString("Recipe", pictureFiles.get(i).getPath());
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

    /**
     * This allows the fragment to find the number of recipes that need to be presented.
     * @return The number of recipes to be presented
     */
    @Override
    public int getItemCount() {
        if (pictureFiles != null) {
            return pictureFiles.size();
        }
        else{
            return 0;
        }
    }

    /**
     * Manages the data of a single view and attaches each
     * piece of data to the right part of the layout.
     */
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
