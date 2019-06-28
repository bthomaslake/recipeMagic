package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

public class MyRecipePresenter {

    private CookBook book;

    public MyRecipePresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    // functions to interact with fragments

    /*
    public List<MyRecipes> getFavorittes(){
        return CookBook.getFavorites();
    }*/
}
