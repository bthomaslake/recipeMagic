package com.example.recipemagic.presenter;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import com.example.recipemagic.model.CookBook;

import java.io.File;
import java.util.List;

public class MyRecipePresenter {

    private CookBook book;
    public List<Bitmap> pictures;

    public MyRecipePresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    // functions to interact with fragments

    /*
    public List<MyRecipes> getFavorittes(){
        return CookBook.getFavorites();
    }*/

    public List<Bitmap> readPictures() {
        String path = Environment.getExternalStorageDirectory().toString()
                + "/Pictures/RecipeMagic/";
        Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        Log.d("Files", "Size: "+ files.length);
        for (int i = 0; i < files.length; i++)
        {
            Log.d("Files", "FileName:" + files[i].getName());
        }
        return null;
    }

}
