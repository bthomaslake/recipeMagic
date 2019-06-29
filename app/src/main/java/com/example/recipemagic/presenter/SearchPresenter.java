package com.example.recipemagic.presenter;

import com.example.recipemagic.model.Category;
import com.example.recipemagic.model.CookBook;
import com.example.recipemagic.model.RecipeHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchPresenter {
    private CookBook book;

    private List<RecipeHelper> recipes;

    public SearchPresenter(MainPresenter presenter) {
        book = presenter.getCookBook();
    }

    public List<RecipeHelper> searchTerm(String term) {

        recipes.clear();

        List<List<RecipeHelper>> listFromPresenter = book.getRecipes();

        //This is where you do the loop, search for ingredients in:
        for (List<RecipeHelper> list_rh : listFromPresenter) {
            for (RecipeHelper rh : list_rh) {
                if (rh.getRecipeIngredients().contains(term)) {
                    recipes.add(rh);
                }
            }
        }

        return recipes;
    }
}
