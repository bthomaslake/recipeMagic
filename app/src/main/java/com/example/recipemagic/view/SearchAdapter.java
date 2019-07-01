package com.example.recipemagic.view;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipemagic.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<String> titles;
    private List<String> images;
    private List<String> ingredients;
    private List<String> directions;

    //Constructor:
    public SearchAdapter(List<String> titles, List<String> images, List<String> ingredients, List<String> directions) {
        this.titles = titles;
        this.images = images;
        this.ingredients = ingredients;
        this.directions = directions;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        Picasso.get().load(images.get(position)).into(holder.image);
        
    }

    //REturn how many items to be displayed in the
    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;
        private CardView card;

        public ViewHolder(View view) {
            super(view);

            title = (TextView) itemView.findViewById(R.id.search);
            image = (ImageView) itemView.findViewById(R.id.search_Img);
            card = (CardView) itemView.findViewById(R.id.cardview_search);

        }



        @Override
        public String toString() {
            return super.toString();
        }
    }
}
