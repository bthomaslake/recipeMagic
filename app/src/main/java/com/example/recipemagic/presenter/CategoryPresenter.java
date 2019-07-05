package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

import java.util.List;

/*
* This class contains all the functions that will be called in
* CategoryList Fragment.
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