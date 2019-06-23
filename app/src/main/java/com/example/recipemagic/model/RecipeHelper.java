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

    public Recipe getRecipe(String name) {
        for (Recipe recipe : this.recipe) {
            if(recipe.getTitle().toUpperCase().equals(name.toUpperCase())) {
                return recipe;
            }
        }
        return null;
    }

    public String getRecipeName() {
        String recipeName = null;
        for (Recipe singleRecipe : recipe) {
            recipeName = singleRecipe.getTitle();
        }
        return recipeName;
    }
}
