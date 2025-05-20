package com.hachau.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hachau.connectors.ProductConnector;
import com.hachau.models.Product;

public class ProductManagementActivity extends AppCompatActivity {

    GridView lvProduct;
    ArrayAdapter<Product> adapter;
    ProductConnector connector;

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
        int cateId = getIntent().getIntExtra("cate_id", -1); // -1 là mặc định nếu không có
        addViews(cateId);
        addEvents();
    }

    private void addEvents() {
        lvProduct.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Product selected = adapter.getItem(i);
            if (selected != null) {
                adapter.remove(selected);
            }
            return true;
        });
    }

    @SuppressLint("WrongViewCast")
    private void addViews(int cateId) {
        lvProduct = findViewById(R.id.lvProduct);
        adapter = new ArrayAdapter<>(
                ProductManagementActivity.this,
                android.R.layout.simple_list_item_1
        );
        connector = new ProductConnector();

        if (cateId != -1) {
            adapter.addAll(connector.get_products_by_category(cateId));
        } else {
            adapter.addAll(connector.get_all_products());
        }

        lvProduct.setAdapter(adapter);
    }

}

//package com.hachau.myapplication;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.Spinner;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.hachau.models.Category;
//import com.hachau.models.ListCategory;
//import com.hachau.models.Product;
//
//public class ProductManagementActivity extends AppCompatActivity {
//
//    Spinner spinnerCategory;
//    ArrayAdapter<Category>adapterCategory;
//    ListCategory listCategory;
//    ListView lvProduct;
//    ArrayAdapter<Product>adapterProduct;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_product_management);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        addViews();
//        addEvents();
//    }
//
//    private void addEvents() {
//        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Category c = adapterCategory.getItem(position);
//                displayProductsByCategory(c);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }
//
//
//    private void displayProductsByCategory(Category c) {
////        xóa dữ liệu cũ trong listview
//        adapterProduct.clear();
////        nạp mới lại dữ liệu của adapter
//        adapterProduct.addAll(c.getProducts());
//    }
//
//    private void addViews() {
//        spinnerCategory=findViewById(R.id.spinnerCategory);
//        adapterCategory=new ArrayAdapter<>(
//                ProductManagementActivity.this, android.R.layout.simple_spinner_item
//        );
//        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerCategory.setAdapter(adapterCategory);
//        listCategory=new ListCategory();
//        listCategory.generate_sample_product_dataset();
//        adapterCategory.addAll(listCategory.getCategories());
//        lvProduct=findViewById(R.id.lvProduct);
//        adapterProduct=new ArrayAdapter<>(
//                ProductManagementActivity.this,
//                android.R.layout.simple_list_item_1
//        );
//        lvProduct.setAdapter(adapterProduct);
//    }
//}