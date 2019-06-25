package com.example.recipemagic;

import com.example.recipemagic.model.CookBook;
import com.example.recipemagic.model.RecipeHelper;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

public class API_Test {

    @Test
    public void readAPI_valid(){
        System.out.println("Test 1");
        CookBook book = new CookBook();
        book.loadCategory("https://www.themealdb.com/api/json/v1/1/categories.php");
        List<String> categories = book.getCategoryTitles();
        for(String name: categories) {
            System.out.println(name);
        }
        assertNotNull(categories);
    }
}
