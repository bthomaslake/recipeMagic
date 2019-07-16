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

import java.io.File;
import java.util.List;

/**
 * The search adapter is used to help display the different recipes that are
 * to be displayed based on the term that was searched.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<String> titles;
    private List<String> images;
    private List<String> ingredients;
    private List<String> directions;
    private List<File> recipes;
    private Integer numParams;

    //Constructor:
    SearchAdapter(List<String> titles, List<String> images, List<String> ingredients, List<String> directions) {
        this.titles = titles;
        this.images = images;
        this.ingredients = ingredients;
        this.directions = directions;
        numParams = 4;
    }

    SearchAdapter(List<File> recipes){
        this.recipes = recipes;
        numParams = 1;
    }

    /**
     * This function clears the list of titles, images, ingredients, and
     * directions so that the search feature can display only what is
     * searched for.
     */
    void clear(){
        titles.clear();
        ingredients.clear();
        directions.clear();
        images.clear();
    }

    void setTitles(List<String> titles) {
        this.titles = titles;
    }

    void setImages(List<String> images) {
        this.images = images;
    }

    void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    void setDirections(List<String> directions) {
        this.directions = directions;
    }

    void setMyRecipes(List<File> recipes){
        this.recipes = recipes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_search, parent, false);
        return new ViewHolder(view);
    }

    /**
     * This function sets the titles and images of the cards based on which
     * recipes are found within the search. When a card is clicked, the title,
     * image, ingredients, and directions of that recipe are bundled and sent
     * to the recipefragment to be displayed.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (numParams == 4){
            holder.title.setText(titles.get(position));
            Picasso.get().load(images.get(position)).into(holder.image);
            holder.card.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Title", titles.get(position));
                    bundle.putString("Ingredient", ingredients.get(position));
                    bundle.putString("Direction", directions.get(position));
                    bundle.putString("Image", images.get(position));

                    Fragment myFragment = new RecipeFragment();
                    myFragment.setArguments(bundle);

                    //start fragment
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, myFragment)
                            .addToBackStack(null)
                            .commit();
                }
            });
        }else{
            String filename = recipes.get(position).getName();
            holder.title.setText(filename.substring(0, filename.length() - 4));
            Picasso.get().load(recipes.get(position)).fit().into(holder.image);
            holder.card.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Recipe", recipes.get(position).getPath());
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
    }

    //Return how many items to be displayed in the
    @Override
    public int getItemCount() {
        if (numParams == 4){
            return titles.size();
        }else{
            return recipes.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;
        private CardView card;

        ViewHolder(View view) {
            super(view);
            title = (TextView) itemView.findViewById(R.id.search);
            image = (ImageView) itemView.findViewById(R.id.search_Img);
            card = (CardView) itemView.findViewById(R.id.cardview_search);
        }



        @NonNull
        @Override
        public String toString() {
            return super.toString();
        }
    }
}
