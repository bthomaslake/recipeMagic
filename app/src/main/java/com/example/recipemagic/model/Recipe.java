package com.example.recipemagic.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private List<Ingredient> ingredients;
    private List<Measurement> measurements;
    @SerializedName("strInstructions")
    private String directions;
    @SerializedName("strmeal")
    private String title;

    public Recipe(){
        ingredients = new ArrayList<Ingredient>();
        measurements = new ArrayList<Measurement>();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public String getDirections() {
        return directions;
    }

    public String getTitle() {
        return title;
    }
}
