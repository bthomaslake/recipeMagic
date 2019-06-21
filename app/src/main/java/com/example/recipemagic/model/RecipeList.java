package com.example.recipemagic.model;

import com.google.gson.annotations.SerializedName;

public class RecipeList {

    @SerializedName("strMeal")
    private String title;

    @SerializedName("strMealThumb")
    private String imageURL;

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }
}
