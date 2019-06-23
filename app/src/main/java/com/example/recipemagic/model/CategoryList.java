package com.example.recipemagic.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    List<Category>categories;

    public CategoryList(){
        categories = new ArrayList<Category>();
    }

    public Category getCategory(String name) {
        for (Category category : categories) {
            if (category.getTitle().toUpperCase().equals(name.toUpperCase())) {
                return category;
            }
        }
        return null;
    }

    public List<String> getCategoryNames() {
        List<String> bookNames = new ArrayList<String>();
        for (Category category : categories) {
            bookNames.add(category.getTitle());
        }
        return bookNames;
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

