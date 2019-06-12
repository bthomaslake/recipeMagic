package com.example.recipemagic;

import com.example.recipemagic.model.cookBook;
import com.example.recipemagic.presenter.MainPresenter;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class CookBookTest {
    @Test
    public void cookBookValid(){
        MainPresenter presenter = new MainPresenter();
        cookBook book = presenter.getCookBook();
        assertNotNull("Book exists", book);
    }
}
