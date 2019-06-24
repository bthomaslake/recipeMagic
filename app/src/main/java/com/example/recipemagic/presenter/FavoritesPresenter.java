package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

public class FavoritesPresenter {

    private CookBook book;

    public FavoritesPresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    // functions to interact with fragments

    /*
    public List<Favorite> getFavorittes(){
        return CookBook.getFavorites();
    }*/
}
