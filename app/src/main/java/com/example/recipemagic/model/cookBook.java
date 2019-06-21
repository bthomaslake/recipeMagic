package com.example.recipemagic.model;

import android.content.Context;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class cookBook {
    private List<Category> categories;
    private List<Favorite> favorites;
    private Gson gson;
    private FileHelper fileHelper;
    private HTTPHelper httpHelper;
    private List<RecipeList> recipes;
    private Recipe singleRecipe;

    public cookBook(Context context){
        categories = new ArrayList<Category>();
        recipes = new ArrayList<RecipeList>();
        favorites = new ArrayList<Favorite>();
        gson = new Gson();
        fileHelper = new FileHelper(context);
        httpHelper = new HTTPHelper();
        singleRecipe = new Recipe();
    }

    public void loadCategory(String url){
        String data = fileHelper.readFile(url);
        Category category = gson.fromJson(data, Category.class);
        categories.add(category);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category getCategory(String title){
        for (Category category : categories) {
            if (category.getTitle().toUpperCase().equals(title.toUpperCase())) {
                return category;
            }
        }
        return null;
    }

    public void loadRecipeList(String url){
        String data = fileHelper.readFile(url);
        RecipeList recipeList = gson.fromJson(data, RecipeList.class);
        recipes.add(recipeList);
    }

    public List<RecipeList> getRecipeLists() {
        return recipes;
    }

    public RecipeList getRecipeList(String title){
        for (RecipeList recipeList : recipes) {
            if (recipeList.getTitle().toUpperCase().equals(title.toUpperCase())) {
                return recipeList;
            }
        }
        return null;
    }

    public void loadRecipe(String url){
        String data = fileHelper.readFile(url);
        Recipe recipe = gson.fromJson(data, Recipe.class);
    }

    public Recipe getSingleRecipe(){
        return singleRecipe;
    }

    public void loadFavorites(){

    }

    public void saveFavorites(){

    }
}
