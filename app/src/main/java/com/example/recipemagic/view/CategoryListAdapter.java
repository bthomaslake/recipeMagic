package com.example.recipemagic.view;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipemagic.R;
import com.example.recipemagic.model.Category;
import com.example.recipemagic.model.CategoryList;
import com.example.recipemagic.model.CookBook;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.view.CategoryListFragment.OnListFragmentInteractionListener;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

   private List<String>titles;
   private List<Integer>images;
    public CategoryListAdapter(List<String> titles, List<Integer>images) {
        this.titles = titles;
        this.images = images;
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
        holder.category_image.setImageResource(images.get(i));
        //      holder.cardview.setOnClickListener(new View.OnClickListener(){
        //        public void onClick(View view){
        //             Intent intent = new Intent(context, Recipe.class);

        //           //passing data to recipe activity
        //         intent.putExtra("Title", RecipeData.get(position).getTitle());
        //         intent.putExtra("Thumbnail", RecipeData.get(position).getThumbNail());

        //       //start activity
        //       context.startActivity(intent);
        //   }
        //});
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
            cardview = (CardView) itemView.findViewById(R.id.cardview_recipe);
        }

    }
}
