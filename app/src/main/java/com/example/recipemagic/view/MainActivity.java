package com.example.recipemagic.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.recipemagic.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Hello");
    }
}
