package com.example.recipemagic.presenter;

import com.example.recipemagic.model.CookBook;

import java.util.List;

public class RecipePresenter {

    private CookBook book;

    public RecipePresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    public String getValidTitles(String category, String recipe) {
        List<String>titles = book.getRecipeTitles(category);
        for(String title: titles){
            if(title.equals(recipe)){
                return title;
            }
        }
        return null;
    }

    public Integer getValidImages(String category, String images) {
        List<Integer>imageList = book.getRecipeThumbNails(category);
        for(Integer image: imageList){
            if(image.toString().equals(images)){
                return image;
            }
        }
        return null;
    }

    public String getValidIngredients(String category, String recipe) {
        List<String>ingredientList = book.getRecipeIngredients(category);
        for(String ingredients: ingredientList){
            if(ingredients.equals(recipe)){
                return ingredients;
            }
        }
        return null;
    }

    public String getValidDirections(String category, String recipe) {
        List<String> directionList = book.getRecipeDirections(category);
        for(String directions: directionList){
            if(directions.equals(recipe)){
                return directions;
            }
        }
        return null;
    }
}