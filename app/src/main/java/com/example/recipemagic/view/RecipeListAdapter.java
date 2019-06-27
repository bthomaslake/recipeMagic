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

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.ViewHolder> {

    private List<String>titles;
    private List<Integer>images;
    private List<String>ingredients;
    private List<String>directions;
    public RecipeListAdapter(List<String> titles, List<Integer>images) {
        this.titles = titles;
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recipelist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        holder.recipe_title.setText(titles.get(i));
        holder.recipe_image.setImageResource(images.get(i));
        holder.cardview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Bundle bundle = new Bundle();
                bundle.putString("Title", titles.get(i));
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipe_title;
        ImageView recipe_image;
        CardView cardview;

        public ViewHolder(View view) {
            super(view);
            recipe_title = (TextView) itemView.findViewById(R.id.recipe);
            recipe_image = (ImageView) itemView.findViewById(R.id.recipe_Img);
            cardview = (CardView) itemView.findViewById(R.id.cardview_recipe);
        }
    }
}
