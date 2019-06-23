package com.example.recipemagic.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipemagic.R;
import com.example.recipemagic.model.Category;
import com.example.recipemagic.model.RecipeHelper;

import java.util.List;

public class CategoryPresenter {


    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

        private Context context;
        private List<Category> data;

        public RecyclerViewAdapter(Context context, List<Category> data) {
            this.context = context;
            this.data = data;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.fragment_category,viewGroup, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
            myViewHolder.category_title.setText(data.get(i).getTitle());
            myViewHolder.category_image.setImageResource(data.get(i).getThumbNail());
            myViewHolder.cardview.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Intent intent = new Intent(context, RecipeHelper.class);

                    //passing data to recipe activity
                    intent.putExtra("Title", data.get(i).getTitle());
                    intent.putExtra("Thumbnail", data.get(i).getThumbNail());

                    //start activity
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView category_title;
            ImageView category_image;
            CardView cardview;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                category_title = (TextView) itemView.findViewById(R.id.category);
                category_image = (ImageView) itemView.findViewById(R.id.category_Img);
                cardview = (CardView) itemView.findViewById(R.id.cardview_category);
            }
        }
    }
}
