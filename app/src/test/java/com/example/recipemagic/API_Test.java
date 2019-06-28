package com.example.recipemagic;

import com.example.recipemagic.model.CategoryList;
import com.example.recipemagic.model.CookBook;
import com.example.recipemagic.model.RecipeHelper;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertNotNull;
public class API_Test {

    @Test
    public void readAPI_valid() {
        System.out.println("Test 1");
        CookBook book = new CookBook();
        book.loadCategory("https://www.themealdb.com/api/json/v1/1/categories.php");
        List<String> categories = book.getCategoryTitles();
        for (String name : categories) {
            System.out.println(name);
        }
        assertNotNull(categories);
    }

    @Test
    public void readURL_valid() {
        System.out.println("Test 2");
        CookBook book = new CookBook();
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20and%20Mustard%20Pie", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20and%20Oyster%20pie", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Bourguignon", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Brisket%20Pot%20Roast", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Dumpling%20Stew", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Lo%20Mein", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20stroganoff", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Sunday%20Roast", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Beef%20Wellington", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Braised%20Beef%20Chilli", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Irish%20stew", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Jamaican%20Beef%20Patties", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Ma%20Po%20Tofu", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Massaman%20Beef%20curry", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Minced%20Beef%20Pie", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Montreal%20Smoked%20Meat", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Oxtail%20with%20broad%20beans", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Pate%20Chinois", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Red%20Peas%20Soup", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Spaghetti%20Bolognese", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Steak%20and%20Kidney%20Pie", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Steak%20Diane", "beef");
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Szechuan%20Beef", "beef");

        List<String> categories = book.getRecipeImages("Beef");
        for (String name : categories) {
            System.out.println(name);
        }
        assertNotNull(categories);
    }
}