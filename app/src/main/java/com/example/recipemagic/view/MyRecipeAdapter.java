package com.example.recipemagic.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
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
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRecipeAdapter extends RecyclerView.Adapter<MyRecipeAdapter.ViewHolder> {

    private final List<File> pictureFiles;
    ImageView imageView;

    public MyRecipeAdapter(List<File> pictureFiles, MainPresenter mainPresenter) {
        /*pictures = new ArrayList<>();
        pictureNames = new ArrayList<>();
        for (String key : pictureFiles.keySet()) {
            pictures.add(pictureFiles.get(key));
            pictureNames.add(key);
        }*/
        this.pictureFiles = pictureFiles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_myrecipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        String fileName = pictureFiles.get(i).getName();
        Picasso
                .get()
                .load(pictureFiles.get(i))
                .fit()
                .into(holder.recipePicture);

        holder.recipeName.setText(fileName.substring(0, fileName.length() - 4));
        //holder.recipePicture.setImageBitmap(pictures.get(i));

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

    @Override
    public int getItemCount() {
        return pictureFiles.size();
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
