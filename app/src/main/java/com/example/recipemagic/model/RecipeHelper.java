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

    public String getRecipeNames() {
        return recipe.get(0).getTitle();
    }

    public Integer getRecipeThumbNails() {
        return recipe.get(0).getThumbNail();
    }

    public String getRecipeImages(){
        return recipe.get(0).getImage();
    }
    public String getRecipeIngredients(){
        return recipe.get(0).getIngredients();
    }
    public String getRecipeDirections(){
        return recipe.get(0).getDirections();
    }
}