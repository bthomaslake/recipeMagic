package com.example.recipemagic.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    List<Category>categories;

    public CategoryList(){
        categories = new ArrayList<Category>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<String> getCategoryNames() {
        List<String> bookNames = new ArrayList<String>();
        for (Category category : categories) {
            bookNames.add(category.getTitle());
        }
        return bookNames;
    }

    public List<Integer> getCategoryThumbNails() {
        List<Integer> thumbNails = new ArrayList<Integer>();
        for (Category category : categories) {
            thumbNails.add(category.getThumbNail());
        }
        return thumbNails;
    }

    public String toString() {
        String output;
        try {
            output = String.format("title: %s", categories);
        } catch (NullPointerException e) {
            output = "No Data";
        }
        return output;
    }
}

