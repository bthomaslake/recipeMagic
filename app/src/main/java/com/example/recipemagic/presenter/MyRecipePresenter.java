package com.example.recipemagic.presenter;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is meant to contain the code necessary to interface the MyRecipe fragment
 * with the model. It currently contains one method for importing picture files from
 * local storage.
 */
public class MyRecipePresenter {

    public MyRecipePresenter(MainPresenter presenter) {
    }

    /**
     * Reads picture files from the local storage.
     * @return picture files
     */
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