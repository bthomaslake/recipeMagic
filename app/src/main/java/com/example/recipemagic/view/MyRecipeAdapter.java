package com.example.recipemagic.view;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recipemagic.R;
import com.example.recipemagic.presenter.MainPresenter;
import com.example.recipemagic.view.MyRecipesFragment.OnListFragmentInteractionListener;
import com.example.recipemagic.view.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRecipeAdapter extends RecyclerView.Adapter<MyRecipeAdapter.ViewHolder> {

    private final List<Bitmap> pictures;
    private final OnListFragmentInteractionListener mListener;
    private MainPresenter presenter;

    public MyRecipeAdapter(List<Bitmap> pictures, OnListFragmentInteractionListener listener) {
        this.pictures = pictures;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_myrecipe, parent, false);
        return new ViewHolder(view);
    }


    //Bitmap bitmap = BitmapFactory.decodeFile(pathToPicture);

    @Override
    public void onBindViewHolder(final ViewHolder holder, int i) {
        holder.recipePicture.setImageBitmap(pictures.get(i));


        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;
        ImageView recipePicture;
        CardView cardView;

        public ViewHolder(View view) {
            super(view);
            recipeName = (TextView) itemView.findViewById(R.id.);
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
