package com.example.recipemagic.model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CookBook {
    private List<CategoryList> categories;
    private List<RecipeHelper> beef;
    private List<RecipeHelper> chicken;
    private List<RecipeHelper> dessert;
    private List<RecipeHelper> lamb;
    private List<RecipeHelper> miscellaneous;
    private List<RecipeHelper> pasta;
    private List<RecipeHelper> pork;
    private List<RecipeHelper> seafood;
    private List<RecipeHelper> side;
    private List<RecipeHelper> starter;
    private List<RecipeHelper> vegan;
    private List<RecipeHelper> vegetarian;
    private Gson gson;
    private HTTPHelper httpHelper;

    public CookBook(){
        categories = new ArrayList<CategoryList>();
        gson = new Gson();
        httpHelper = new HTTPHelper();
        beef = new ArrayList<RecipeHelper>();
        chicken = new ArrayList<RecipeHelper>();
        dessert = new ArrayList<RecipeHelper>();
        lamb = new ArrayList<RecipeHelper>();
        miscellaneous = new ArrayList<RecipeHelper>();
        pasta = new ArrayList<RecipeHelper>();
        pork = new ArrayList<RecipeHelper>();
        seafood = new ArrayList<RecipeHelper>();
        side = new ArrayList<RecipeHelper>();
        starter = new ArrayList<RecipeHelper>();
        vegan = new ArrayList<RecipeHelper>();
        vegetarian = new ArrayList<RecipeHelper>();

    }

    public void loadCategory(String url){
        String data = httpHelper.readHTTP(url);
        CategoryList categoryList = gson.fromJson(data, CategoryList.class);
        categories.add(categoryList);
    }

    public List<String> getCategoryTitles() {
        List<String> titles = categories.get(0).getCategoryNames();
        return titles;
    }

    public List<Integer> getCategoryThumbNails() {
        List<Integer> thumbNails = categories.get(0).getCategoryThumbNails();
        return thumbNails;
    }

    public List<String> getRecipeTitles(String category) {
        switch(category){
            case "beef":
                return beef.get(0).getRecipeNames();
            case "chicken":
                return chicken.get(0).getRecipeNames();
            case "dessert":
                return dessert.get(0).getRecipeNames();
            case "lamb":
                return lamb.get(0).getRecipeNames();
            case "miscellaneous":
                return miscellaneous.get(0).getRecipeNames();
            case "pasta":
                return pasta.get(0).getRecipeNames();
            case "pork":
                return pork.get(0).getRecipeNames();
            case "seafood":
                return seafood.get(0).getRecipeNames();
            case "side":
                return side.get(0).getRecipeNames();
            case "starter":
                return starter.get(0).getRecipeNames();
            case "vegan":
                return vegan.get(0).getRecipeNames();
            default:
                return vegetarian.get(0).getRecipeNames();
        }
    }

    public List<Integer> getRecipeThumbNails(String category) {
        switch(category){
            case "beef":
                return beef.get(0).getRecipeThumbNails();
            case "chicken":
                return chicken.get(0).getRecipeThumbNails();
            case "dessert":
                return dessert.get(0).getRecipeThumbNails();
            case "lamb":
                return lamb.get(0).getRecipeThumbNails();
            case "miscellaneous":
                return miscellaneous.get(0).getRecipeThumbNails();
            case "pasta":
                return pasta.get(0).getRecipeThumbNails();
            case "pork":
                return pork.get(0).getRecipeThumbNails();
            case "seafood":
                return seafood.get(0).getRecipeThumbNails();
            case "side":
                return side.get(0).getRecipeThumbNails();
            case "starter":
                return starter.get(0).getRecipeThumbNails();
            case "vegan":
                return vegan.get(0).getRecipeThumbNails();
            default:
                return vegetarian.get(0).getRecipeThumbNails();
        }
    }

    public void loadRecipe(String url, String category){
        String data = httpHelper.readHTTP(url);
        RecipeHelper recipeHelper = gson.fromJson(data, RecipeHelper.class);
        switch(category){
            case "beef":
                beef.add(recipeHelper);
                break;
            case "chicken":
                chicken.add(recipeHelper);
                break;
            case "dessert":
                dessert.add(recipeHelper);
                break;
            case "lamb":
                lamb.add(recipeHelper);
                break;
            case "miscellaneous":
                miscellaneous.add(recipeHelper);
                break;
            case "pasta":
                pasta.add(recipeHelper);
                break;
            case "pork":
                pork.add(recipeHelper);
                break;
            case "seafood":
                seafood.add(recipeHelper);
                break;
            case "side":
                side.add(recipeHelper);
                break;
            case "starter":
                starter.add(recipeHelper);
                break;
            case "vegan":
                vegan.add(recipeHelper);
                break;
            default:
                vegetarian.add(recipeHelper);
                break;
        }
    }

    public List<RecipeHelper> getRecipeHelper(String category){
        switch(category){
            case "beef":
                return beef;
            case "chicken":
                return chicken;
            case "dessert":
                return dessert;
            case "lamb":
                return lamb;
            case "miscellaneous":
                return miscellaneous;
            case "pasta":
                return pasta;
            case "pork":
                return pork;
            case "seafood":
                return seafood;
            case "side":
                return side;
            case "starter":
                return starter;
            case "vegan":
                return vegan;
            default:
                return vegetarian;
        }
    }
}
