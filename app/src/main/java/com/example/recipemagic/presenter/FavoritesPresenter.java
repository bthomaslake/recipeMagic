package com.example.recipemagic.presenter;

import com.example.recipemagic.model.Favorite;
import com.example.recipemagic.model.cookBook;

import java.util.List;

public class FavoritesPresenter {

    private cookBook book;

    public FavoritesPresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    // functions to interact with fragments

    /*
    public List<Favorite> getFavorittes(){
        return cookBook.getFavorites();
    }*/
}
