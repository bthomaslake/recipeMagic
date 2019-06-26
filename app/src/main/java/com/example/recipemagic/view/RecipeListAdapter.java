package com.example.recipemagic.view;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

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

    public RecipeListAdapter(List<String> titles, List<Integer>images) {
        System.out.println("Here");
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
