package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

public class myRecipesPresenter {

    private CookBook book;

    public myRecipesPresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    // functions to interact with fragments

    /*
    public List<Favorite> getFavorittes(){
        return CookBook.getFavorites();
    }*/
}
