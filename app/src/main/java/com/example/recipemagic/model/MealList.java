package com.example.recipemagic.model;

import java.util.ArrayList;
import java.util.List;

public class MealList {
    List<Meals> meals;

    public MealList(){
        meals = new ArrayList<Meals>();
    }

    public Meals getRecipe(String name) {
        for (Meals meals : this.meals) {
            if (meals.getTitle().toUpperCase().equals(name.toUpperCase())) {
                return meals;
            }
        }
        return null;
    }

    public List<String> getRecipeNames() {
        List<String> recipeNames = new ArrayList<String>();
        for (Meals meals : this.meals) {
            recipeNames.add(meals.getTitle());
        }
        return recipeNames;
    }

    public String toString() {
        String output;
        try {
            output = String.format("title: %s", meals);
        } catch (NullPointerException e) {
            output = "No Data";
        }
        return output;
    }
}
