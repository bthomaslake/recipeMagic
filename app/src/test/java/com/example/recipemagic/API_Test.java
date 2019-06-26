package com.example.recipemagic;

import com.example.recipemagic.model.CategoryList;
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
        List<CategoryList> categories = book.getCategoryList();
        List<String>names = categories.get(0).getCategoryNames();
        for(int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        assertNotNull(categories);
    }

    @Test
    public void readMeal_valid(){
        System.out.println("\nTest 2");
        CookBook book = new CookBook();
        book.loadMealList("https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood");
        List<MealList> mealLists = book.getRecipeLists();
        List<String>names = mealLists.get(0).getRecipeNames();
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }
        assertNotNull(mealLists);
    }

    @Test
    public void readRecipe_valid(){
        System.out.println("\nTest 3");
        CookBook book = new CookBook();
        book.loadRecipe("https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata");
        List<RecipeHelper> recipeHelper = book.getRecipeHelper();
        String name = recipeHelper.get(0).getRecipeName();
        String directions = recipeHelper.get(0).getRecipe(name).getDirections();
        List<String>ingredients = recipeHelper.get(0).getRecipe(name).getIngredients();
        System.out.println(name + "\n");
        for (int i = 0; i < ingredients.size(); i++){
            System.out.println(ingredients.get(i));
        }
        System.out.println("\n" + directions);
    }
}
