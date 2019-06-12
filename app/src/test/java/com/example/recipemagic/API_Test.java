package com.example.recipemagic;

import com.example.recipemagic.model.cookBook;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNull;

public class API_Test {

    @Test
    public void readAPI_valid(){
        cookBook book = new cookBook();
        String result = book.readAPI("https://www.byui.edu");
        assertTrue(result.contains("Rexburg"));
    }

    @Test
    public void readAPI_invalid(){
        cookBook book = new cookBook();
        String result = book.readAPI("https://nowhere");
        assertNull(result);
    }
}
