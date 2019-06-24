package com.example.recipemagic.model;

import com.example.recipemagic.R;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("strCategory")
    private String title;

    @SerializedName("strCategoryThumb")
    private String image;

    public Category(String title, int thumbNail) {
        this.title = title;
        this.thumbNail = thumbNail;
    }

    private int thumbNail;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getThumbNail(){
        return R.drawable.category;
    }
}
