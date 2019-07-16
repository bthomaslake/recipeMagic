package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;
import com.example.recipemagic.model.RecipeHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 * This class contains all the functions that will be called in
 * Search Fragment.
 */
public class SearchPresenter {
    private List<RecipeHelper> recipes;
    private List<String> images;
    private List<String> titles;
    private List<String> directions;
    private List<String> ingredients;
    private List<List<RecipeHelper>> listFromPresenter;

    // Variables for the my recipe search
    private List<File> files;
    private List<File> myRecipes;


    public SearchPresenter(MainPresenter presenter) {
        // Variables for the database recipe search
        CookBook book = presenter.getCookBook();
        recipes = new ArrayList<RecipeHelper>();
        images = new ArrayList<String>();
        titles = new ArrayList<String>();
        ingredients = new ArrayList<String>();
        directions = new ArrayList<String>();;
        listFromPresenter = book.getRecipes();
        MyRecipePresenter mpPresenter = new MyRecipePresenter(presenter);
        files = mpPresenter.readPictureFiles();
        myRecipes = new ArrayList<File>();
    }

    /**
     * This function is designed to search through the recipes and
     * add the recipes with the given term into a list.
     * @param term
     */
    public void searchDataBase(String term) {
        recipes.clear();
        //This is where you do the loop, search for ingredients in:
        for (List<RecipeHelper> list_rh : listFromPresenter) {
            for (RecipeHelper rh : list_rh) {
                if (rh.getRecipeNames().toUpperCase().contains(term.toUpperCase())) {
                    recipes.add(rh);
                }
            }
        }
    }

    /**
     * This function is designed to search through the recipes added by the user and
     * add the recipes with the given term into a list.
     * @param term
     */
    public void searchMyrecipes(String term) {
        myRecipes.clear();
        if(files != null){
            System.out.println("yes!");
            for (File searchedFile : files){
                if (searchedFile.getName().toUpperCase().contains(term.toUpperCase())){
                    myRecipes.add(searchedFile);
                }
            }
        }
    }

    /**
     * This function returns a list of recipes that contained the term the user
     * searched for.
     * @return
     */
    public List<File> getMyRecipes() {
        return myRecipes;
    }

    /**
     * This function is designed to get all the recipe titles from
     * the list created from the search function
     * @return
     */
    public List<String>getRecipeTitles(){
        titles.clear();
        for(RecipeHelper recipe : recipes){
            titles.add(recipe.getRecipeNames());
        }
        return titles;
    }

    /**
     * This function is designed to get all the recipe images from
     * the list created from the search function
     * @return
     */
    public List<String>getRecipeImages(){
        images.clear();
        for(RecipeHelper recipe : recipes){
            images.add(recipe.getRecipeImages());
        }
        return images;
    }

    /**
     * This function is designed to get all the recipe ingredients from
     * the list created from the search function
     * @return
     */
    public List<String>getRecipeIngredients(){
        ingredients.clear();
        for(RecipeHelper recipe : recipes){
            ingredients.add(recipe.getRecipeIngredients());
        }
        return ingredients;
    }

    /**
     * This function is designed to get all the recipe directions from
     * the list created from the search function
     * @return
     */
    public List<String>getRecipeDirections(){
        directions.clear();
        for(RecipeHelper recipe : recipes){
            directions.add(recipe.getRecipeDirections());
        }
        return directions;
    }
}
