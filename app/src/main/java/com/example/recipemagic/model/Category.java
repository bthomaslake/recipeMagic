package com.example.recipemagic.model;

import com.google.gson.annotations.SerializedName;

/*
* This class is used to read in the categories from the API. Each category has
* a title and a picture associated with it.
*/
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