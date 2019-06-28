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

    @Test
    public void read_valid() {
        System.out.println("Test 3");
        CookBook book = new CookBook();
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Beef");
        List<String> recipes9 = book.getUrlList();
        for (String name : recipes9) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Beef\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Chicken");
        List<String> recipes11 = book.getUrlList();
        for (String name : recipes11) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Chicken\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Dessert");
        List<String> recipes13 = book.getUrlList();
        for (String name : recipes13) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Dessert\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Lamb");
        List<String> recipes = book.getUrlList();
        for (String name : recipes) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Lamb\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Miscellaneous");
        List<String> recipes1 = book.getUrlList();
        for (String name : recipes1) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Miscellaneous\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Pasta");
        List<String> recipes2 = book.getUrlList();
        for (String name : recipes2) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Pasta\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Pork");
        List<String> recipes3 = book.getUrlList();
        for (String name : recipes3) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Pork\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood");
        List<String> recipes4 = book.getUrlList();
        for (String name : recipes4) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Seafood\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Side");
        List<String> recipes12 = book.getUrlList();
        for (String name : recipes12) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Side\");");

        }

        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Starter");
        List<String> recipes5 = book.getUrlList();
        for (String name : recipes5) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Starter\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Vegan");
        List<String> recipes6 = book.getUrlList();
        for (String name : recipes6) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Vegan\");");

        }
        book.loadURL("https://www.themealdb.com/api/json/v1/1/filter.php?c=Vegetarian");
        List<String> recipes7 = book.getUrlList();
        for (String name : recipes7) {
            String names = name.replace(" ","%20");
            System.out.println("presenter.get().getCookBook().loadRecipe(\"https://www.themealdb.com/api/json/v1/1/search.php?s=" +  names + "\", \"Vegetarian\");");

        }

        assertNotNull(recipes);
    }
}