package com.example.recipemagic.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RecipeHelper {
    @SerializedName("meals")
    private List<Recipe> recipe;

    public RecipeHelper(){
        recipe = new ArrayList<Recipe>();
    }

    public List<String> getRecipeNames() {
        List<String> recipeNames = new ArrayList<String>();
        for (Recipe recipes : recipe) {
            recipeNames.add(recipes.getTitle());
        }
        return recipeNames;
    }

    public List<Integer> getRecipeThumbNails() {
        List<Integer> thumbNails = new ArrayList<Integer>();
        for (Recipe recipes : recipe) {
            thumbNails.add(recipes.getThumbNail());
        }
        return thumbNails;
    }
}