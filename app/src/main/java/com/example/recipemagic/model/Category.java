package com.example.recipemagic.model;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("strCategory")
    private String title;

    @SerializedName("strCategoryThumb")
    private String image;

    private int thumbNail;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getThumbNail(){
        return thumbNail;
    }
}
