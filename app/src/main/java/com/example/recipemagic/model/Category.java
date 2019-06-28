package com.example.recipemagic.model;

import com.example.recipemagic.R;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("strCategory")
    private String title;

    @SerializedName("strCategoryThumb")
    private String image;


    public Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}