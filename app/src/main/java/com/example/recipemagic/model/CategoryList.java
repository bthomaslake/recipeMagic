package com.example.recipemagic.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    private List<Category>categories;

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

    public List<String> getCategoryImages() {
        List<String> images = new ArrayList<String>();
        for (Category category : categories) {
            images.add(category.getImage());
        }
        return images;
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
