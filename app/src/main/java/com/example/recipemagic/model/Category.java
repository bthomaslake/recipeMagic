package com.example.recipemagic.model;

import com.example.recipemagic.R;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("strCategory")
    private String title;

    @SerializedName("strCategoryThumb")
    private String image;

    private int thumbNail;

    public Category(String title, int thumbNail) {
        this.title = title;
        this.thumbNail = thumbNail;
    }

    public String getTitle() {
        return title;
    }

    public int getThumbNail(){
        switch(image){
            case "https://www.themealdb.com/images/category/beef.png":
                return R.drawable.beef;
            case "https://www.themealdb.com/images/category/chicken.png":
                return R.drawable.chicken;
            case "https://www.themealdb.com/images/category/dessert.png":
                return R.drawable.dessert;
            case "https://www.themealdb.com/images/category/lamb.png":
                return R.drawable.lamb;
            case "https://www.themealdb.com/images/category/miscellaneous.png":
                return R.drawable.miscellaneous;
            case "https://www.themealdb.com/images/category/pasta.png":
                return R.drawable.pasta;
            case "https://www.themealdb.com/images/category/seafood.png":
                return R.drawable.seafood;
            case "https://www.themealdb.com/images/category/side.png":
                return R.drawable.side;
            case "https://www.themealdb.com/images/category/starter.png":
                return R.drawable.starter;
            case "https://www.themealdb.com/images/category/vegan.png":
                return R.drawable.vegan;
            case "https://www.themealdb.com/images/category/vegetarian.png":
                return R.drawable.vegetarian;
            default:
                return R.drawable.category;
        }
    }
}
