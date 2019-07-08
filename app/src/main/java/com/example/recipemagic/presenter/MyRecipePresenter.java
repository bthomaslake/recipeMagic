package com.example.recipemagic.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.example.recipemagic.model.CookBook;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyRecipePresenter {

    private CookBook book;
    public Map<String, Bitmap> pictures;

    public MyRecipePresenter(MainPresenter presenter){
        book = presenter.getCookBook();
    }

    // functions to interact with fragments

    /*
    public List<MyRecipes> getFavorittes(){
        return CookBook.getFavorites();
    }*/

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

}
