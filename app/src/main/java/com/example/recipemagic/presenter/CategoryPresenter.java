package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

import java.util.List;

/**
* This class contains all the functions that will be called in
* CategoryList Fragment. Each function in the class gets the data
* from the CookBook about the list of categories read in from the
* API database.
*/
public class CategoryPresenter {

    private CookBook book;

    public CategoryPresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    public List<String> getValidTitles() {
        return book.getCategoryTitles();
    }

    public List<String> getValidImages() {
        return book.getCategoryImages();
    }
}