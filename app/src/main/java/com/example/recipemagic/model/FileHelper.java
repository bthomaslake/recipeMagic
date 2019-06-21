package com.example.recipemagic.model;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHelper {
    private Context context;

    public FileHelper(Context context){
        this.context = context;
    }

    public String readFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.openFileInput(fileName)));
            String data = reader.readLine();
            reader.close();
            return data;
         }catch (IOException e){
            Log.e("FileHelper", "Error reading from file: " + fileName);
            return null;
        }
    }
}
