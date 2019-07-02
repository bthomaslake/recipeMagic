package com.example.recipemagic.presenter;

import com.example.recipemagic.model.Category;
import com.example.recipemagic.model.CookBook;
import com.example.recipemagic.model.RecipeHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchPresenter {
    private CookBook book;

    private List<RecipeHelper> recipes;
    private List<RecipeHelper> myRecipes;

    public SearchPresenter(MainPresenter presenter) {
        book = presenter.getCookBook();
        recipes = new ArrayList<RecipeHelper>();
        myRecipes = new ArrayList<RecipeHelper>();
    }

    public void searchDataBase(String term) {
        recipes.clear();

        List<List<RecipeHelper>> listFromPresenter = book.getRecipes();

        //This is where you do the loop, search for ingredients in:
        for (List<RecipeHelper> list_rh : listFromPresenter) {
            for (RecipeHelper rh : list_rh) {
                if (rh.getRecipeNames().toUpperCase().contains(term.toUpperCase())) {
                    recipes.add(rh);
                }
            }
        }
    }

    public void searchMyrecipes(String term) {
        myRecipes.clear();

    }

    public List<RecipeHelper>getRecipes(){
        return recipes;
    }

    public List<RecipeHelper>getMyRecipes(){
        return myRecipes;
    }
}
