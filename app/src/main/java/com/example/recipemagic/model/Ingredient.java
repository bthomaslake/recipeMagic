package com.example.recipemagic.model;

import com.google.gson.annotations.SerializedName;

public class Ingredient {
    @SerializedName(value ="ingredient", alternate = {"strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5", "strIngredient6", "strIngredient7", "strIngredient8", "strIngredient9", "strIngredient10", "strIngredient11", "strIngredient12", "strIngredient13", "strIngredient14", "strIngredient15", "strIngredient16", "strIngredient17", "strIngredient18", "strIngredient19", "strIngredient20"})
    private String ingredient;

    public String getIngredient() {
        return ingredient;
    }
}
