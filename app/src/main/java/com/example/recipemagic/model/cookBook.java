package com.example.recipemagic.model;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recipemagic.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class cookBook {
    private List<CategoryList> categories;
    private List<MealList> recipes;
    private List<RecipeHelper> recipeHelpers;
    private List<Favorite> favorites;
    private Gson gson;
    private HTTPHelper httpHelper;

    public cookBook(){
        categories = new ArrayList<CategoryList>();
        recipes = new ArrayList<MealList>();
        favorites = new ArrayList<Favorite>();
        gson = new Gson();
        httpHelper = new HTTPHelper();
        recipeHelpers = new ArrayList<RecipeHelper>();
    }

    public void loadCategory(String url){
        String data = httpHelper.readHTTP(url);
        CategoryList categoryList = gson.fromJson(data, CategoryList.class);
        categories.add(categoryList);
    }

    public List<CategoryList> getCategoryList(){
        return categories;
    }
    public void loadMealList(String url){
        String data = httpHelper.readHTTP(url);
        MealList mealList = gson.fromJson(data, MealList.class);
        recipes.add(mealList);
    }

    public List<MealList> getRecipeLists() {
        return recipes;
    }


    public void loadRecipe(String url){
        String data = httpHelper.readHTTP(url);
        RecipeHelper recipeHelper = gson.fromJson(data, RecipeHelper.class);
        recipeHelpers.add(recipeHelper);
    }

    public List<RecipeHelper> getRecipeHelper(){
        return recipeHelpers;
    }

    public void loadFavorites(){

    }

    public void saveFavorites(){

    }
}
