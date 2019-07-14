package com.example.recipemagic.presenter;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyRecipePresenter {

    public MyRecipePresenter(MainPresenter presenter) {
    }

    // functions to interact with fragments

    public List<File> readPictureFiles() {
        File directory = new File(Environment.getExternalStorageDirectory().toString()
                + "/Pictures/RecipeMagic/");
        if (directory.listFiles() != null) {
            return new ArrayList<>(Arrays.asList(directory.listFiles()));
        } else {
            return null;
        }
    }
}