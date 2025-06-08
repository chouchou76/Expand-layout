package com.hachau.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hachau.models.Category;
import com.hachau.models.ListProduct;
import com.hachau.models.Product;

public class ProductManagementActivity extends AppCompatActivity {
    ListView lvProduct;
    Spinner spinnerCategory;
    Button btnAddProduct;
    ArrayAdapter<Product> adapterProduct;
    ArrayAdapter<Category> adapterCategory;
    ListProduct listProduct;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addViews() {
        lvProduct = findViewById(R.id.lvProduct);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        listProduct = new ListProduct();
        Log.d("ProductManagement", "Generating sample dataset");
//        listProduct.generate_sample_dataset();

        // Log danh sách danh mục và sản phẩm ban đầu
//        Log.d("ProductManagement", "Categories: " + listProduct.getCategories().size());
//        for (Category c : listProduct.getCategories()) {
//            Log.d("ProductManagement", "Category: " + c.getName() + ", Products: " + c.getProducts().size());
//            for (Product p : c.getProducts()) {
//                Log.d("ProductManagement", "Initial Product: " + p.getName() + ", Description: " + (p.getDescription() != null ? p.getDescription() : "null"));
//            }
//        }

//        adapterCategory = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listProduct.getCategories());
        spinnerCategory.setAdapter(adapterCategory);
        adapterProduct = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listProduct.getProducts());
        lvProduct.setAdapter(adapterProduct);
    }

    private void addEvents() {
        spinnerCategory.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                Category c = adapterCategory.getItem(position);
                if (c != null) {
                    Log.d("ProductManagement", "Selected Category: " + c.getName() + ", Product count: " + c.getProducts().size());
                    for (Product p : c.getProducts()) {
                        Log.d("ProductManagement", "Category Product: " + p.getName() + ", Description: " + (p.getDescription() != null ? p.getDescription() : "null"));
                    }
                    adapterProduct.clear();
                    adapterProduct.addAll(c.getProducts());
                    adapterProduct.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
            }
        });

        lvProduct.setOnItemClickListener((parent, view, position, id) -> {
            Product p = adapterProduct.getItem(position);
            if (p != null) {
                Log.d("ProductManagement", "Selected Product: " + p.getName() + ", Description: " + (p.getDescription() != null ? p.getDescription() : "null"));
                Category selectedCategory = (Category) spinnerCategory.getSelectedItem();
                int categoryId = selectedCategory.getId();
                Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
                intent.putExtra("SELECTED_PRODUCT", p);
                intent.putExtra("CATEGORY_ID", categoryId);
                intent.putExtra("MODE", "EDIT");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            // Làm mới danh sách sản phẩm
            Category selectedCategory = (Category) spinnerCategory.getSelectedItem();
            if (selectedCategory != null) {
                adapterProduct.clear();
                adapterProduct.addAll(selectedCategory.getProducts());
                adapterProduct.notifyDataSetChanged();
            }
            Log.d("ProductManagement", "Product list refreshed");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_product,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_add_product) {
            Category selectedCategory = (Category) spinnerCategory.getSelectedItem();
            if (selectedCategory != null) {
                Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
                intent.putExtra("CATEGORY_ID", selectedCategory.getId());
                intent.putExtra("MODE", "ADD");
                startActivityForResult(intent, REQUEST_CODE);
            } else {
                Toast.makeText(this, "Please select a category", Toast.LENGTH_SHORT).show();
                Log.d("ProductManagement", "No category selected");
            }
            return true;
        } else if (id == R.id.menu_refresh) {
            Category selectedCategory = (Category) spinnerCategory.getSelectedItem();
            if (selectedCategory != null) {
                adapterProduct.clear();
                adapterProduct.addAll(selectedCategory.getProducts());
                adapterProduct.notifyDataSetChanged();
                Toast.makeText(this, "Product list refreshed", Toast.LENGTH_SHORT).show();
            }
            return true;
        } else if (id == R.id.menu_clear_all) {
            listProduct.getProducts().clear();
//            for (Category c : listProduct.getCategories()) {
//                c.getProducts().clear();
//            }
            adapterProduct.clear();
            adapterProduct.notifyDataSetChanged();
            Toast.makeText(this, "All products cleared", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}