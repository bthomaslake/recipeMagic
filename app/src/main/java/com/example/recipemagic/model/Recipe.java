package com.example.recipemagic.model;

import com.example.recipemagic.R;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private int thumbNail;

    @SerializedName("strInstructions")
    private String directions;

    @SerializedName("strMeal")
    private String title;

    @SerializedName("strMealThumb")
    private String image;

    public String getImage(){
        return image;
    }

    public int getThumbNail() {
        switch(image){
            case "https://www.themealdb.com/images/media/meals/sytuqu1511553755.jpg":
                return R.drawable.beefmustardpie;
            case "https://www.themealdb.com/images/media/meals/wrssvt1511556563.jpg":
                return R.drawable.beefoysterpie;
            case "https://www.themealdb.com/images/media/meals/vtqxtu1511784197.jpg":
                return R.drawable.beefbourguignon;
            case "https://www.themealdb.com/images/media/meals/ursuup1487348423.jpg":
                return R.drawable.beefpotroast;
            case "https://www.themealdb.com/images/media/meals/uyqrrv1511553350.jpg":
                return R.drawable.beefdumplingstew;
            case "https://www.themealdb.com/images/media/meals/1529444830.jpg":
                return R.drawable.beeflomein;
            case "https://www.themealdb.com/images/media/meals/svprys1511176755.jpg":
                return R.drawable.beefstroganoff;
            case "https://www.themealdb.com/images/media/meals/ssrrrs1503664277.jpg":
                return R.drawable.beefsundayroast;
            case "https://www.themealdb.com/images/media/meals/vvpprx1487325699.jpg":
                return R.drawable.beefwellington;
            case "https://www.themealdb.com/images/media/meals/uuqvwu1504629254.jpg":
                return R.drawable.braisedbeefchilli;
            case "https://www.themealdb.com/images/media/meals/sxxpst1468569714.jpg":
                return R.drawable.irishstew;
            case "https://www.themealdb.com/images/media/meals/wsqqsw1515364068.jpg":
                return R.drawable.jamaicanbeefpatties;
            case "https://www.themealdb.com/images/media/meals/1525874812.jpg":
                return R.drawable.mapatofu;
            case "https://www.themealdb.com/images/media/meals/tvttqv1504640475.jpg":
                return R.drawable.beefcurry;
            case "https://www.themealdb.com/images/media/meals/xwutvy1511555540.jpg":
                return R.drawable.beefpie;
            case "https://www.themealdb.com/images/media/meals/uttupv1511815050.jpg":
                return R.drawable.smokedmeat;
            case "https://www.themealdb.com/images/media/meals/1520083578.jpg":
                return R.drawable.oxtail;
            case "https://www.themealdb.com/images/media/meals/yyrrxr1511816289.jpg":
                return R.drawable.patechinois;
            case "https://www.themealdb.com/images/media/meals/sqpqtp1515365614.jpg":
                return R.drawable.redpeasoup;
            case "https://www.themealdb.com/images/media/meals/sutysw1468247559.jpg":
                return R.drawable.spaghettibolognese;
            case "https://www.themealdb.com/images/media/meals/qysyss1511558054.jpg":
                return R.drawable.steakkidneypie;
            case "https://www.themealdb.com/images/media/meals/vussxq1511882648.jpg":
                return R.drawable.steakdiane;
            case "https://www.themealdb.com/images/media/meals/1529443236.jpg":
                return R.drawable.szechuanbeef;
            default:
                return R.drawable.category;
        }
    }

    @SerializedName(value = "ingredient1", alternate = "strIngredient1")
    private String ingredient1;
    @SerializedName(value = "ingredient2", alternate = "strIngredient2")
    private String ingredient2;
    @SerializedName(value = "ingredient3", alternate = "strIngredient3")
    private String ingredient3;
    @SerializedName(value = "ingredient4", alternate = "strIngredient4")
    private String ingredient4;
    @SerializedName(value = "ingredient5", alternate = "strIngredient5")
    private String ingredient5;
    @SerializedName(value = "ingredient6", alternate = "strIngredient6")
    private String ingredient6;
    @SerializedName(value = "ingredient7", alternate = "strIngredient7")
    private String ingredient7;
    @SerializedName(value = "ingredient8", alternate = "strIngredient8")
    private String ingredient8;
    @SerializedName(value = "ingredient9", alternate = "strIngredient9")
    private String ingredient9;
    @SerializedName(value = "ingredient10", alternate = "strIngredient10")
    private String ingredient10;
    @SerializedName(value = "ingredient11", alternate = "strIngredient11")
    private String ingredient11;
    @SerializedName(value = "ingredient12", alternate = "strIngredient12")
    private String ingredient12;
    @SerializedName(value = "ingredient13", alternate = "strIngredient13")
    private String ingredient13;
    @SerializedName(value = "ingredient14", alternate = "strIngredient14")
    private String ingredient14;
    @SerializedName(value = "ingredient15", alternate = "strIngredient15")
    private String ingredient15;
    @SerializedName(value = "ingredient16", alternate = "strIngredient16")
    private String ingredient16;
    @SerializedName(value = "ingredient17", alternate = "strIngredient17")
    private String ingredient17;
    @SerializedName(value = "ingredient18", alternate = "strIngredient18")
    private String ingredient18;
    @SerializedName(value = "ingredient19", alternate = "strIngredient19")
    private String ingredient19;
    @SerializedName(value = "ingredient20", alternate = "strIngredient20")
    private String ingredient20;
    @SerializedName(value = "measurement1", alternate = "strMeasure1")
    private String measurement1;
    @SerializedName(value = "measurement2", alternate = "strMeasure2")
    private String measurement2;
    @SerializedName(value = "measurement3", alternate = "strMeasure3")
    private String measurement3;
    @SerializedName(value = "measurement4", alternate = "strMeasure4")
    private String measurement4;
    @SerializedName(value = "measurement5", alternate = "strMeasure5")
    private String measurement5;
    @SerializedName(value = "measurement6", alternate = "strMeasure6")
    private String measurement6;
    @SerializedName(value = "measurement7", alternate = "strMeasure7")
    private String measurement7;
    @SerializedName(value = "measurement8", alternate = "strMeasure8")
    private String measurement8;
    @SerializedName(value = "measurement9", alternate = "strMeasure9")
    private String measurement9;
    @SerializedName(value = "measurement10", alternate = "strMeasure10")
    private String measurement10;
    @SerializedName(value = "measurement11", alternate = "strMeasure11")
    private String measurement11;
    @SerializedName(value = "measurement12", alternate = "strMeasure12")
    private String measurement12;
    @SerializedName(value = "measurement13", alternate = "strMeasure13")
    private String measurement13;
    @SerializedName(value = "measurement14", alternate = "strMeasure14")
    private String measurement14;
    @SerializedName(value = "measurement15", alternate = "strMeasure15")
    private String measurement15;
    @SerializedName(value = "measurement16", alternate = "strMeasure16")
    private String measurement16;
    @SerializedName(value = "measurement17", alternate = "strMeasure17")
    private String measurement17;
    @SerializedName(value = "measurement18", alternate = "strMeasure18")
    private String measurement18;
    @SerializedName(value = "measurement19", alternate = "strMeasure19")
    private String measurement19;
    @SerializedName(value = "measurement20", alternate = "strMeasure20")
    private String measurement20;

    public String getDirections() {
        return directions;
    }

    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        List<String> ingredientList = new ArrayList<String>();
        String ingredients = "";
        if (measurement1 != null && !measurement1.equals("")) {
            ingredientList.add(measurement1 + " " + ingredient1);
        }
        if (measurement2 != null && !measurement2.equals("")) {
            ingredientList.add(measurement2 + " " + ingredient2);
        }
        if (measurement3 != null && !measurement3.equals("")) {
            ingredientList.add(measurement3 + " " + ingredient3);
        }
        if (measurement4 != null && !measurement4.equals("")) {
            ingredientList.add(measurement4 + " " + ingredient4);
        }
        if (measurement5 != null && !measurement5.equals("")) {
            ingredientList.add(measurement5 + " " + ingredient5);
        }
        if (measurement6 != null && !measurement6.equals("")) {
            ingredientList.add(measurement6 + " " + ingredient6);
        }
        if (measurement7 != null && !measurement7.equals("")) {
            ingredientList.add(measurement7 + " " + ingredient7);
        }
        if (measurement8 != null && !measurement8.equals("")) {
            ingredientList.add(measurement8 + " " + ingredient8);
        }
        if (measurement9 != null && !measurement9.equals("")) {
            ingredientList.add(measurement9 + " " + ingredient9);
        }
        if (measurement10 != null && !measurement10.equals("")) {
            ingredientList.add(measurement10 + " " + ingredient10);
        }
        if (measurement11 != null && !measurement11.equals("")) {
            ingredientList.add(measurement11 + " " + ingredient11);
        }
        if (measurement12 != null && !measurement12.equals("")) {
            ingredientList.add(measurement12 + " " + ingredient12);
        }
        if (measurement13 != null && !measurement13.equals("")) {
            ingredientList.add(measurement13 + " " + ingredient13);
        }
        if (measurement14 != null && !measurement14.equals("")) {
            ingredientList.add(measurement14 + " " + ingredient14);
        }
        if (measurement15 != null && !measurement15.equals("")) {
            ingredientList.add(measurement15 + " " + ingredient15);
        }
        if (measurement16 != null && !measurement16.equals("")) {
            ingredientList.add(measurement16 + " " + ingredient16);
        }
        if (measurement17 != null && !measurement17.equals("")) {
            ingredientList.add(measurement17 + " " + ingredient17);
        }
        if (measurement18 != null && !measurement18.equals("")) {
            ingredientList.add(measurement18 + " " + ingredient18);
        }
        if (measurement19 != null && !measurement19.equals("")) {
            ingredientList.add(measurement19 + " " + ingredient19);
        }
        if (measurement20 != null && !measurement20.equals("")) {
            ingredientList.add(measurement20 + " " + ingredient20);
        }

        for(String ingredient: ingredientList){
                ingredients += ingredient + "\n";
        }
        return ingredients;
    }
}
