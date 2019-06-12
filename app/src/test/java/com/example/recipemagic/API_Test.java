package com.example.recipemagic;

import com.example.recipemagic.model.cookBook;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class API_Test {

    @Test
    public void readAPI_valid(){
        cookBook book = new cookBook();
        String result = book.readAPI("https://www.byui.edu");
        assertEquals(result.contains("Rexburg"), true);
    }

    @Test
    public void readAPI_invalid(){
        cookBook book = new cookBook();
        String result = book.readAPI("https://nowhere");
        assertEquals(result.equals(null), true);
    }
}
