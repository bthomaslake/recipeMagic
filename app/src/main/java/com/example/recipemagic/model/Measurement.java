package com.example.recipemagic.model;

import com.google.gson.annotations.SerializedName;

public class Measurement {
    @SerializedName(value ="measurement", alternate = {"strMeasure1", "strMeasure2", "strMeasure3", "strMeasure4", "strMeasure5", "strMeasure6", "strMeasure7", "strMeasure8", "strMeasure9", "strMeasure", "strMeasure11", "strMeasure12", "strMeasure13", "strMeasure14", "strMeasure15", "strMeasure16", "strMeasure17", "strMeasure18", "strMeasure19", "strMeasure20"})
    private String measurement;

    public String getMeasurement() {
        return measurement;
    }
}
