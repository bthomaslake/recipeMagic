package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

public class RecipeListPresenter {

    private CookBook book;
    public RecipeListPresenter(MainPresenter presenter) {
        book = presenter.getCookBook();

    }
}
