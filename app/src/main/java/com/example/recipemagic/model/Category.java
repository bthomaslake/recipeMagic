package com.example.recipemagic.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Category {

    @SerializedName("strCategory")
    private String title;

    @SerializedName("strCategoryThumb")
    private String imageURL;

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }
}
