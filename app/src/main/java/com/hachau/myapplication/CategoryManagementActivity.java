package com.hachau.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.hachau.connectors.CategoryConnector;
import com.hachau.models.Category;

public class CategoryManagementActivity extends AppCompatActivity {

    GridView lvCategory;
    ArrayAdapter<Category> adapter;
    CategoryConnector connector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        lvCategory.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Category selected = adapter.getItem(i);
            if (selected != null) {
                adapter.remove(selected);
            }
            return true; // true nếu bạn đã xử lý sự kiện
        });

        lvCategory.setOnItemClickListener((parent, view, position, id) -> {
            Category selectedCategory = adapter.getItem(position);
            if (selectedCategory != null) {
                // Tạo Intent chuyển sang ProductManagementActivity
                Intent intent = new Intent(CategoryManagementActivity.this, ProductManagementActivity.class);
                // Truyền cate_id qua Intent
                intent.putExtra("cate_id", selectedCategory.getId());
                intent.putExtra("cate_name", selectedCategory.getName()); // nếu muốn hiển thị tên
                startActivity(intent);
            }
        });
    }

    @SuppressLint("WrongViewCast")
    private void addViews() {
        lvCategory = findViewById(R.id.lvCategory);
        adapter = new ArrayAdapter<>(
                CategoryManagementActivity.this,
                android.R.layout.simple_list_item_1
        );
        connector = new CategoryConnector();
        adapter.addAll(connector.get_all_categories());
        lvCategory.setAdapter(adapter);
    }
}
