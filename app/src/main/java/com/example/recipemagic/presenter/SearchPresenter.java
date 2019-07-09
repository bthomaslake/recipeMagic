package com.example.recipemagic.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.example.recipemagic.model.CookBook;
import com.example.recipemagic.model.RecipeHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This class contains all the functions that will be called in
 * Search Fragment.
 */
public class SearchPresenter {
    private CookBook book;
    private List<RecipeHelper> recipes;
    private List<RecipeHelper> myRecipes;
    private List<String> images;
    private List<String> titles;
    private List<String> directions;
    private List<String> ingredients;
    private List<List<RecipeHelper>> listFromPresenter;
    public Map<String, Bitmap> pictures;


    public SearchPresenter(MainPresenter presenter) {
        book = presenter.getCookBook();
        recipes = new ArrayList<RecipeHelper>();
        myRecipes = new ArrayList<RecipeHelper>();
        images = new ArrayList<String>();
        titles = new ArrayList<String>();
        ingredients = new ArrayList<String>();
        directions = new ArrayList<String>();;
        listFromPresenter = book.getRecipes();
    }

    public void searchDataBase(String term) {
        recipes.clear();
        //This is where you do the loop, search for ingredients in:
        for (List<RecipeHelper> list_rh : listFromPresenter) {
            for (RecipeHelper rh : list_rh) {
                if (rh.getRecipeNames().toUpperCase().contains(term.toUpperCase())) {
                    recipes.add(rh);
                }
            }
        }
    }

    public Map<String, Bitmap> readPictures() {
        pictures = new HashMap<>();
        String path = Environment.getExternalStorageDirectory().toString()
                + "/Pictures/RecipeMagic/";
        Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        Log.d("Files", "Size: "+ files.length);
        for (int i = 0; i < files.length; i++)
        {
            Log.d("Files", "FileName:" + files[i].getName());
            pictures.put(files[i].getName(), BitmapFactory.decodeFile(files[i].getPath()));
        }
        return pictures;
    }

    public void searchMyrecipes(String term) {
        myRecipes.clear();
        readPictures();

        if (pictures.containsKey(term))
        {

        }
    }

    public List<String>getRecipeTitles(){
        titles.clear();
        for(RecipeHelper recipe : recipes){
            titles.add(recipe.getRecipeNames());
        }
        return titles;
    }

    public List<String>getRecipeImages(){
        images.clear();
        for(RecipeHelper recipe : recipes){
            images.add(recipe.getRecipeImages());
        }
        return images;
    }

    public List<String>getRecipeIngredients(){
        ingredients.clear();
        for(RecipeHelper recipe : recipes){
            ingredients.add(recipe.getRecipeIngredients());
        }
        return ingredients;
    }

    public List<String>getRecipeDirections(){
        directions.clear();
        for(RecipeHelper recipe : recipes){
            directions.add(recipe.getRecipeDirections());
        }
        return directions;
    }
}
