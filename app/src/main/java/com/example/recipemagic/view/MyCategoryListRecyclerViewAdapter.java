package com.example.recipemagic.view;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipemagic.R;
import com.example.recipemagic.model.Recipe;
import com.example.recipemagic.view.CategoryListFragment.OnListFragmentInteractionListener;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCategoryListRecyclerViewAdapter extends RecyclerView.Adapter<MyCategoryListRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context context;
    private List<Recipe>data;

    public MyCategoryListRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.recipe_title.setText(data.get(position).getTitle());
        holder.recipe_image.setImageResource(data.get(position).getThumbNail());
        holder.cardview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(context, Recipe.class);

                //passing data to recipe activity
                intent.putExtra("Title", data.get(position).getTitle());
                intent.putExtra("Thumbnail", data.get(position).getThumbNail());

                //start activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
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
