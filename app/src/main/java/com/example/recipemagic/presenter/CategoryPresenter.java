package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

import java.util.List;

public class CategoryPresenter {

    private CookBook book;

    public CategoryPresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    public List<String> getValidTitles() {
        return book.getCategoryTitles();
    }

    public List<Integer> getValidImages() {
        return book.getCategoryThumbNails();
    }
}