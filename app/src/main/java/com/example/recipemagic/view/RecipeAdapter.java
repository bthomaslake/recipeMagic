package com.example.recipemagic.view;

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

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private List<String>title;
    private List<Integer>image;
    private List<String>ingredients;
    private List<String>directions;
    public RecipeAdapter(List<String> title, List<Integer>image, List<String>ingredients, List<String>directions) {
        this.title = title;
        this.image = image;
        this.directions = directions;
        this.ingredients = ingredients;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        holder.recipe_title.setText(title.get(i));
        holder.recipe_image.setImageResource(image.get(i));
        holder.recipe_directions.setText(directions.get(i));
        holder.recipe_ingredients.setText(ingredients.get(i));
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipe_title;
        ImageView recipe_image;
        TextView recipe_ingredients;
        TextView recipe_directions;

        public ViewHolder(View view) {
            super(view);
            recipe_directions = (TextView) itemView.findViewById(R.id.textDescription);
            recipe_ingredients = (TextView) itemView.findViewById(R.id.textIngredients);
            recipe_title = (TextView) itemView.findViewById(R.id.textTitle);
            recipe_image = (ImageView) itemView.findViewById(R.id.recipe_picture);
        }
    }
}
