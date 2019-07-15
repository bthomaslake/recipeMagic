package com.example.recipemagic.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.recipemagic.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView img=(ImageView)findViewById(R.id.logo);
        Drawable myDrawable = getResources().getDrawable(R.drawable.category);
        img.setImageDrawable(myDrawable);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME);
    }
}
