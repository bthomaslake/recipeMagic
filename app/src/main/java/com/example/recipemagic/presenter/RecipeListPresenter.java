package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

import java.util.List;

public class RecipeListPresenter {

    private CookBook book;

    public RecipeListPresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    public List<String> getValidTitles(String category) {
        return book.getRecipeTitles(category);
    }

    public List<String> getValidImages(String category) {
        return book.getRecipeImages(category);
    }

    public List<String> getValidIngredients(String category) {
        return book.getRecipeIngredients(category);
    }

    public List<String> getValidDirections(String category) {
        return book.getRecipeDirections(category);
    }
}