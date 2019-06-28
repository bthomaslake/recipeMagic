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

    public void searchTerm(String term) {
        recipes.clear();

        //This is where you do the loop, search for ingredients in: each category -> recipe.getIngredientString()
        for (List<RecipeHelper> list_rh : book.getRecipes()) {
            for (RecipeHelper rh : list_rh) {
                if (rh.getRecipeIngredients().contains(term)) {
                    recipes.add(rh);
                }

            }
        }
    }
}
