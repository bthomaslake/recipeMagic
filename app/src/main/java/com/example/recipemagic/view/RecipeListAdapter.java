package com.example.recipemagic.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipemagic.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * This function helps display all the recipes in a given category.
 */
public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {

    private List<String>titles;
    private List<String>images;
    private List<String>ingredients;
    private List<String>directions;

    RecipeListAdapter(List<String> titles, List<String> images, List<String> directions, List<String> ingredients) {
        this.titles = titles;
        this.images = images;
        this.directions = directions;
        this.ingredients = ingredients;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recipelist, parent, false);
        return new ViewHolder(view);
    }

    /**
     * This function is designed to set all the titles and images into the cardview
     * in the recipeListFragment. It then bundles the title, ingredients, image, and
     * directions of the clicked on card and sends it to the recipeFragment so that
     * all the information can be displayed
     * @param holder
     * @param i
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        holder.recipe_title.setText(titles.get(i));
        Picasso.get().load(images.get(i)).into(holder.recipe_image);
        holder.cardview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Bundle bundle = new Bundle();
                bundle.putString("Title", titles.get(i));
                bundle.putString("Ingredient", ingredients.get(i));
                bundle.putString("Direction", directions.get(i));
                bundle.putString("Image", images.get(i));
                Fragment myFragment = new RecipeFragment();
                myFragment.setArguments(bundle);

                //start Fragment
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, myFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipe_title;
        ImageView recipe_image;
        CardView cardview;

        ViewHolder(View view) {
            super(view);
            recipe_title = (TextView) itemView.findViewById(R.id.recipe);
            recipe_image = (ImageView) itemView.findViewById(R.id.recipe_Img);
            cardview = (CardView) itemView.findViewById(R.id.cardview_recipe);
        }
    }
}
