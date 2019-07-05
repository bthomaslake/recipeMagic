package com.example.recipemagic.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/*
* Although the recipe json files only provide one recipe for
* each url, the recipe is put into a list. Therefore, we have
* to have this class so that we can get a list of the recipes.
*/
public class RecipeHelper {
    @SerializedName("meals")
    private List<Recipe> recipe;

    public RecipeHelper(){
        recipe = new ArrayList<Recipe>();
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