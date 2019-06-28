package com.example.recipemagic.presenter;

import com.example.recipemagic.model.Category;
import com.example.recipemagic.model.CookBook;
import com.example.recipemagic.model.RecipeHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchPresenter {
    private CookBook book;

    private List<RecipeHelper> category;

    public SearchPresenter(MainPresenter presenter) {
        book = presenter.getCookBook();
        category = new ArrayList<RecipeHelper>();
    }

    public void searchTerm(String term) {
        category.clear();

        //This is where you do the loop, search for ingredients in: each category -> recipe.getIngredientString()

    }
}
