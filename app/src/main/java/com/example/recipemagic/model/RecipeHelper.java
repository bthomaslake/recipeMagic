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

    public List<String> getNames() {
        List<String> bookNames = new ArrayList<String>();
        for (Recipe recipes : recipe) {
            bookNames.add(recipes.getTitle());
        }
        return bookNames;
    }

    public String getRecipeNames() {
        return recipe.get(0).getTitle();
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