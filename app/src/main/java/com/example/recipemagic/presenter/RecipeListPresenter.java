package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

import java.util.List;

/**
 * This class contains all the functions that will be called in
 * RecipeList Fragment.
 */
public class RecipeListPresenter {

    private CookBook book;

    public RecipeListPresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    /**
     * This function returns all the titles of the category
     * that is requested
     * @param category
     * @return
     */
    public List<String> getValidTitles(String category) {
        return book.getRecipeTitles(category);
    }

    /**
     * This function returns all the pictures of the recipes from
     * the category that is requested
     * @param category
     * @return
     */
    public List<String> getValidImages(String category) {
        return book.getRecipeImages(category);
    }

    /**
     * This function returns all the ingredients of the recipes from
     * the category that is requested
     * @param category
     * @return
     */
    public List<String> getValidIngredients(String category) {
        return book.getRecipeIngredients(category);
    }

    /**
     * This function returns all the directions of the recipes from
     * the category that is requested
     * @param category
     * @return
     */
    public List<String> getValidDirections(String category) {
        return book.getRecipeDirections(category);
    }
}