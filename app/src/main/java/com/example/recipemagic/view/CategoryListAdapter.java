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
import com.example.recipemagic.presenter.DownloadRecipes;
import com.example.recipemagic.presenter.MainPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private List<String>titles;
    private List<String>images;
    private MainPresenter presenter;
    private Clicked beef;
    private Clicked chicken;
    private Clicked dessert;
    private Clicked lamb;
    private Clicked miscellaneous;
    private Clicked pasta;
    private Clicked pork;
    private Clicked seafood;
    private Clicked side;
    private Clicked starter;
    private Clicked vegan;
    private Clicked vegetarian;

    public CategoryListAdapter(List<String> titles, List<String>images, MainPresenter presenter) {
        this.titles = titles;
        this.images = images;
        this.presenter = presenter;
        beef = new Clicked();
        chicken = new Clicked();
        dessert = new Clicked();
        lamb = new Clicked();
        miscellaneous = new Clicked();
        pasta = new Clicked();
        pork = new Clicked();
        seafood = new Clicked();
        side = new Clicked();
        starter = new Clicked();
        vegan = new Clicked();
        vegetarian = new Clicked();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        holder.category_title.setText(titles.get(i));
        Picasso.get().load(images.get(i)).into(holder.category_image);
        holder.cardview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switch(titles.get(i)){
                    case "Beef":
                        if(!beef.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Chicken":
                        if(!chicken.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Dessert":
                        if(!dessert.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Lamb":
                        if(!lamb.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Miscellaneous":
                        if(!miscellaneous.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Pasta":
                        if(!pasta.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Pork":
                        if(!pork.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Seafood":
                        if(!seafood.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Side":
                        if(!side.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Starter":
                        if(!starter.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    case "Vegan":
                        if(!vegan.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                    default:
                        if(!vegetarian.beenClicked()){
                            DownloadRecipes task = new DownloadRecipes(presenter, titles.get(i));
                            task.execute();
                        }
                        break;
                }
                //passing data to recipe list activity
                Bundle bundle = new Bundle();
                bundle.putString("Category", titles.get(i));
                Fragment myFragment = new RecipeListFragment();
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
        TextView category_title;
        ImageView category_image;
        CardView cardview;

        public ViewHolder(View view) {
            super(view);
            category_title = (TextView) itemView.findViewById(R.id.category);
            category_image = (ImageView) itemView.findViewById(R.id.category_Img);
            cardview = (CardView) itemView.findViewById(R.id.cardview_category);
        }
    }

    private class Clicked{
        private int clicked;
        private boolean isClicked;

        public Clicked(){
            clicked = 0;
            isClicked = false;
        }

        public boolean beenClicked(){

            if (clicked == 0){
                clicked++;
            }else{
                isClicked = true;
            }
            return isClicked;
        }
    }
}