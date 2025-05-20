package com.hachau.connectors;

import com.hachau.models.Category;
import com.hachau.models.ListCategory;

import java.util.ArrayList;

public class CategoryConnector {
    private ListCategory listCategory;

    public CategoryConnector() {
        listCategory = new ListCategory();
        listCategory.generate_sample_dataset();
    }

    public ArrayList<Category> get_all_categories() {
        if (listCategory == null) {
            listCategory = new ListCategory();
            listCategory.generate_sample_dataset();
        }
        return listCategory.getCategories();
    }

    public ArrayList<Category> get_categories_by_name(String namePart) {
        if (listCategory == null) {
            listCategory = new ListCategory();
            listCategory.generate_sample_dataset();
        }

        ArrayList<Category> results = new ArrayList<>();
        for (Category c : listCategory.getCategories()) {
            if (c.getName().toLowerCase().contains(namePart.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }
}
