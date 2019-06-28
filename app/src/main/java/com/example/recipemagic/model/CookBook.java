package com.example.recipemagic.model;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class CookBook {
    private List<CategoryList> categories;
    private List<List<RecipeHelper>> recipes;
    private List<RecipeHelper> beef;
    private List<RecipeHelper> chicken;
    private List<RecipeHelper> dessert;
    private List<RecipeHelper> lamb;
    private List<RecipeHelper> miscellaneous;
    private List<RecipeHelper> pasta;
    private List<RecipeHelper> pork;
    private List<RecipeHelper> seafood;
    private List<RecipeHelper> side;
    private List<RecipeHelper> starter;
    private List<RecipeHelper> vegan;
    private List<RecipeHelper> vegetarian;
    private Gson gson;
    private HTTPHelper httpHelper;

    public CookBook(){
        categories = new ArrayList<CategoryList>();
        gson = new Gson();
        httpHelper = new HTTPHelper();
        beef = new ArrayList<RecipeHelper>();
        chicken = new ArrayList<RecipeHelper>();
        dessert = new ArrayList<RecipeHelper>();
        lamb = new ArrayList<RecipeHelper>();
        miscellaneous = new ArrayList<RecipeHelper>();
        pasta = new ArrayList<RecipeHelper>();
        pork = new ArrayList<RecipeHelper>();
        seafood = new ArrayList<RecipeHelper>();
        side = new ArrayList<RecipeHelper>();
        starter = new ArrayList<RecipeHelper>();
        vegan = new ArrayList<RecipeHelper>();
        vegetarian = new ArrayList<RecipeHelper>();
        recipes = new ArrayList<List<RecipeHelper>>();

    }

    public void loadCategory(String url){
        String data = httpHelper.readHTTP(url);
        CategoryList categoryList = gson.fromJson(data, CategoryList.class);
        categories.add(categoryList);
    }

    public List<String> getCategoryTitles() {
        List<String> titles = categories.get(0).getCategoryNames();
        System.out.println("Titles: " + titles.size());
        return titles;
    }

    public List<Integer> getCategoryThumbNails() {
        List<Integer> thumbNails = categories.get(0).getCategoryThumbNails();
        return thumbNails;
    }

    public List<String> getRecipeTitles(String category) {
        List<String>titles = new ArrayList<String>();
        switch(category){
            case "Beef":
                for(RecipeHelper categoryBeef : beef){
                    titles.add(categoryBeef.getRecipeNames());
                }
                System.out.println("Titles: " + titles.size());
                return titles;
            case "Chicken":
                for(RecipeHelper categoryChicken : chicken){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            case "Dessert":
                for(RecipeHelper categoryChicken : dessert){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            case "Lamb":
                for(RecipeHelper categoryChicken : lamb){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            case "Miscellaneous":
                for(RecipeHelper categoryChicken : miscellaneous){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            case "Pasta":
                for(RecipeHelper categoryChicken : pasta){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            case "Pork":
                for(RecipeHelper categoryChicken : pork){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            case "Seafood":
                for(RecipeHelper categoryChicken : seafood){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            case "Side":
                for(RecipeHelper categoryChicken : side){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            case "Starter":
                for(RecipeHelper categoryChicken : starter){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            case "Vegan":
                for(RecipeHelper categoryChicken : vegan){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
            default:
                for(RecipeHelper categoryChicken : vegetarian){
                    titles.add(categoryChicken.getRecipeNames());
                }
                return titles;
        }
    }

    public List<String> getRecipeIngredients(String category) {
        List<String> ingredients = new ArrayList<>();
        switch(category){
            case "Beef":
                for(RecipeHelper categoryBeef : beef){
                    ingredients.add(categoryBeef.getRecipeIngredients());
                }
                return ingredients;
            case "Chicken":
                for(RecipeHelper categoryChicken : chicken){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            case "Dessert":
                for(RecipeHelper categoryChicken : dessert){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            case "Lamb":
                for(RecipeHelper categoryChicken : lamb){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            case "Miscellaneous":
                for(RecipeHelper categoryChicken : miscellaneous){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            case "Pasta":
                for(RecipeHelper categoryChicken : pasta){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            case "Pork":
                for(RecipeHelper categoryChicken : pork){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            case "Seafood":
                for(RecipeHelper categoryChicken : seafood){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            case "Side":
                for(RecipeHelper categoryChicken : side){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            case "Starter":
                for(RecipeHelper categoryChicken : starter){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            case "Vegan":
                for(RecipeHelper categoryChicken : vegan){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
            default:
                for(RecipeHelper categoryChicken : vegetarian){
                    ingredients.add(categoryChicken.getRecipeIngredients());
                }
                return ingredients;
        }
    }

    public List<String> getRecipeDirections(String category) {
        List<String>directions = new ArrayList<String>();
        switch(category){
            case "Beef":
                for(RecipeHelper categoryBeef : beef){
                    directions.add(categoryBeef.getRecipeDirections());
                }
                return directions;
            case "Chicken":
                for(RecipeHelper categoryChicken : chicken){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            case "Dessert":
                for(RecipeHelper categoryChicken : dessert){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            case "Lamb":
                for(RecipeHelper categoryChicken : lamb){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            case "Miscellaneous":
                for(RecipeHelper categoryChicken : miscellaneous){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            case "Pasta":
                for(RecipeHelper categoryChicken : pasta){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            case "Pork":
                for(RecipeHelper categoryChicken : pork){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            case "Seafood":
                for(RecipeHelper categoryChicken : seafood){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            case "Side":
                for(RecipeHelper categoryChicken : side){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            case "Starter":
                for(RecipeHelper categoryChicken : starter){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            case "Vegan":
                for(RecipeHelper categoryChicken : vegan){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
            default:
                for(RecipeHelper categoryChicken : vegetarian){
                    directions.add(categoryChicken.getRecipeDirections());
                }
                return directions;
        }
    }

    public List<String> getRecipeImages(String category) {
        List<String>thumbNails = new ArrayList<String>();
        switch(category){
            case "Beef":
                for(RecipeHelper categoryBeef : beef){
                    thumbNails.add(categoryBeef.getRecipeImages());
                }
                return thumbNails;
            case "Chicken":
                for(RecipeHelper categoryChicken : chicken){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            case "Dessert":
                for(RecipeHelper categoryChicken : dessert){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            case "Lamb":
                for(RecipeHelper categoryChicken : lamb){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            case "Miscellaneous":
                for(RecipeHelper categoryChicken : miscellaneous){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            case "Pasta":
                for(RecipeHelper categoryChicken : pasta){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            case "Pork":
                for(RecipeHelper categoryChicken : pork){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            case "Seafood":
                for(RecipeHelper categoryChicken : seafood){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            case "Side":
                for(RecipeHelper categoryChicken : side){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            case "Starter":
                for(RecipeHelper categoryChicken : starter){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            case "Vegan":
                for(RecipeHelper categoryChicken : vegan){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
            default:
                for(RecipeHelper categoryChicken : vegetarian){
                    thumbNails.add(categoryChicken.getRecipeImages());
                }
                return thumbNails;
        }
    }

    public List<Integer> getRecipeThumbNails(String category) {
        List<Integer>thumbNails = new ArrayList<Integer>();
        switch(category){
            case "Beef":
                for(RecipeHelper categoryBeef : beef){
                    thumbNails.add(categoryBeef.getRecipeThumbNails());
                }
                return thumbNails;
            case "Chicken":
                for(RecipeHelper categoryChicken : chicken){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            case "Dessert":
                for(RecipeHelper categoryChicken : dessert){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            case "Lamb":
                for(RecipeHelper categoryChicken : lamb){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            case "Miscellaneous":
                for(RecipeHelper categoryChicken : miscellaneous){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            case "Pasta":
                for(RecipeHelper categoryChicken : pasta){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            case "Pork":
                for(RecipeHelper categoryChicken : pork){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            case "Seafood":
                for(RecipeHelper categoryChicken : seafood){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            case "Side":
                for(RecipeHelper categoryChicken : side){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            case "Starter":
                for(RecipeHelper categoryChicken : starter){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            case "Vegan":
                for(RecipeHelper categoryChicken : vegan){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
            default:
                for(RecipeHelper categoryChicken : vegetarian){
                    thumbNails.add(categoryChicken.getRecipeThumbNails());
                }
                return thumbNails;
        }
    }

    public void loadRecipe(String url, String category){
        String data = httpHelper.readHTTP(url);
        RecipeHelper recipeHelper = gson.fromJson(data, RecipeHelper.class);
        switch(category){
            case "beef":
                beef.add(recipeHelper);
                break;
            case "chicken":
                chicken.add(recipeHelper);
               break;
            case "dessert":
                dessert.add(recipeHelper);
                break;
            case "lamb":
                lamb.add(recipeHelper);
                break;
            case "miscellaneous":
                miscellaneous.add(recipeHelper);
                break;
            case "pasta":
                pasta.add(recipeHelper);
                break;
            case "pork":
                pork.add(recipeHelper);
                break;
            case "seafood":
                seafood.add(recipeHelper);
                break;
            case "side":
                side.add(recipeHelper);
                break;
            case "starter":
                starter.add(recipeHelper);
                break;
            case "vegan":
                vegan.add(recipeHelper);
                break;
            default:
                vegetarian.add(recipeHelper);
                break;
        }
    }

    public List<List<RecipeHelper>> getRecipes(){

        recipes.add(beef);
        recipes.add(chicken);
        recipes.add(dessert);
        recipes.add(lamb);
        recipes.add(miscellaneous);
        recipes.add(pasta);
        recipes.add(pork);
        recipes.add(seafood);
        recipes.add(side);
        recipes.add(starter);
        recipes.add(vegan);

        return recipes;
    }
}
