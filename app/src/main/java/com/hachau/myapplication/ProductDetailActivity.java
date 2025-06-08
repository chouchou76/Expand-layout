package com.hachau.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hachau.models.Category;
import com.hachau.models.ListProduct;
import com.hachau.models.Product;

public class ProductDetailActivity extends AppCompatActivity {
    EditText edt_product_id, edt_product_name, edt_product_quantity, edt_product_price;
    EditText edt_product_description, edt_category_id, edt_product_image_id;
    Button btn_new, btn_save, btn_remove;
    ListProduct listProduct;
    String mode;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listProduct = new ListProduct();
//        listProduct.generate_sample_dataset(); // Khởi tạo dữ liệu mẫu
        addViews();
        addEvents();
    }

    private void addViews() {
        edt_product_id = findViewById(R.id.edt_product_id);
        edt_product_name = findViewById(R.id.edt_product_name);
        edt_product_quantity = findViewById(R.id.edt_product_quantity);
        edt_product_price = findViewById(R.id.edt_product_price);
        edt_product_description = findViewById(R.id.edt_product_description);
        edt_category_id = findViewById(R.id.edt_category_id);
        edt_product_image_id = findViewById(R.id.edt_product_image_id);
        btn_new = findViewById(R.id.btn_new);
        btn_save = findViewById(R.id.btn_save);
        btn_remove = findViewById(R.id.btn_remove);

        // Hiển thị dữ liệu
        display_product_details();
    }

    private void display_product_details() {
        Intent intent = getIntent();
        mode = intent.getStringExtra("MODE");
        if (mode == null) mode = "EDIT";

        if (mode.equals("EDIT")) {
            Product product = (Product) intent.getSerializableExtra("SELECTED_PRODUCT");
            int categoryId = intent.getIntExtra("CATEGORY_ID", -1);
            if (product == null) {
                Log.d("ProductDetail", "Product is null");
                Toast.makeText(this, "Error: No product selected", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }

            Log.d("ProductDetail", "Product: Name=" + product.getName() + ", ID=" + product.getId() +
                    ", Description=" + (product.getDescription() != null ? product.getDescription() : "null"));

            edt_product_id.setText(String.valueOf(product.getId()));
            edt_product_name.setText(product.getName());
            edt_product_quantity.setText(String.valueOf(product.getQuantity()));
            edt_product_price.setText(String.valueOf(product.getPrice()));
            edt_product_description.setText(product.getDescription() != null ? product.getDescription() : "");
            edt_category_id.setText(String.valueOf(categoryId));
            edt_product_image_id.setText(String.valueOf(product.getImage_id()));
            btn_remove.setEnabled(true); // Cho phép xóa
        } else if (mode.equals("ADD")) {
            int categoryId = intent.getIntExtra("CATEGORY_ID", -1);
            edt_product_id.setText(String.valueOf(getNextProductId()));
            edt_category_id.setText(String.valueOf(categoryId));
            edt_product_name.setText("");
            edt_product_quantity.setText("");
            edt_product_price.setText("");
            edt_product_description.setText("");
            edt_product_image_id.setText("1");
            btn_remove.setEnabled(false); // Không cho xóa khi thêm mới
        }
    }

    private void addEvents() {
        btn_new.setOnClickListener(v -> {
            mode = "ADD";
            int categoryId = Integer.parseInt(edt_category_id.getText().toString().isEmpty() ? "-1" : edt_category_id.getText().toString());
            edt_product_id.setText(String.valueOf(getNextProductId()));
            edt_product_name.setText("");
            edt_product_quantity.setText("");
            edt_product_price.setText("");
            edt_product_description.setText("");
            edt_product_image_id.setText("1");
            if (categoryId != -1) {
                edt_category_id.setText(String.valueOf(categoryId));
            }
            btn_remove.setEnabled(false);
            Toast.makeText(this, "Enter new product details", Toast.LENGTH_SHORT).show();
        });

        btn_save.setOnClickListener(v -> {
            try {
                int id = Integer.parseInt(edt_product_id.getText().toString());
                String name = edt_product_name.getText().toString().trim();
                String quantityStr = edt_product_quantity.getText().toString().trim();
                String priceStr = edt_product_price.getText().toString().trim();
                String description = edt_product_description.getText().toString().trim();
                String categoryIdStr = edt_category_id.getText().toString().trim();
                String imageIdStr = edt_product_image_id.getText().toString().trim();

                // Kiểm tra đầu vào
                if (name.isEmpty()) {
                    Toast.makeText(this, "Product name is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (quantityStr.isEmpty()) {
                    Toast.makeText(this, "Quantity is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (priceStr.isEmpty()) {
                    Toast.makeText(this, "Price is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (categoryIdStr.isEmpty()) {
                    Toast.makeText(this, "Category ID is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (imageIdStr.isEmpty()) {
                    Toast.makeText(this, "Image ID is required", Toast.LENGTH_SHORT).show();
                    return;
                }

                int quantity = Integer.parseInt(quantityStr);
                double price = Double.parseDouble(priceStr);
                int categoryId = Integer.parseInt(categoryIdStr);
                int imageId = Integer.parseInt(imageIdStr);

                // Kiểm tra categoryId hợp lệ
                boolean categoryExists = false;
//                for (Category c : listProduct.getCategories()) {
//                    if (c.getId() == categoryId) {
//                        categoryExists = true;
//                        break;
//                    }
//                }
                if (!categoryExists) {
                    Toast.makeText(this, "Invalid Category ID", Toast.LENGTH_SHORT).show();
                    return;
                }

                Product product = new Product(id, name, quantity, price, categoryId, description.isEmpty() ? null : description, imageId);

                if (mode.equals("ADD")) {
                    // Kiểm tra ID trùng
                    for (Product p : listProduct.getProducts()) {
                        if (p.getId() == id) {
                            Toast.makeText(this, "Product ID already exists", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    // Thêm sản phẩm mới
//                    listProduct.addProduct(product);
//                    for (Category c : listProduct.getCategories()) {
//                        if (c.getId() == categoryId) {
//                            c.addProduct(product);
//                            break;
//                        }
//                    }
                    Toast.makeText(this, "Product added successfully", Toast.LENGTH_SHORT).show();
                } else if (mode.equals("EDIT")) {
                    // Cập nhật sản phẩm
                    for (Product p : listProduct.getProducts()) {
                        if (p.getId() == id) {
                            p.setName(name);
                            p.setQuantity(quantity);
                            p.setPrice(price);
                            p.setDescription(description.isEmpty() ? null : description);
                            p.setCate_id(categoryId);
                            p.setImage_id(imageId);
                            break;
                        }
                    }
                    // Cập nhật trong danh mục
//                    for (Category c : listProduct.getCategories()) {
//                        for (Product p : c.getProducts()) {
//                            if (p.getId() == id) {
//                                p.setName(name);
//                                p.setQuantity(quantity);
//                                p.setPrice(price);
//                                p.setDescription(description.isEmpty() ? null : description);
//                                p.setCate_id(categoryId);
//                                p.setImage_id(imageId);
//                                break;
//                            }
//                        }
//                    }
                    Toast.makeText(this, "Product updated successfully", Toast.LENGTH_SHORT).show();
                }

                // Thông báo cập nhật danh sách
                Intent resultIntent = new Intent();
                setResult(RESULT_OK, resultIntent);
                finish();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter valid numbers for ID, Quantity, Price, Category ID, and Image ID", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error saving product", Toast.LENGTH_SHORT).show();
                Log.e("ProductDetail", "Error saving product", e);
            }
        });

        btn_remove.setOnClickListener(v -> {
            if (mode.equals("EDIT")) {
                try {
                    int id = Integer.parseInt(edt_product_id.getText().toString());
                    // Xóa sản phẩm khỏi listProduct
                    listProduct.getProducts().removeIf(p -> p.getId() == id);
                    // Xóa sản phẩm khỏi danh mục
//                    for (Category c : listProduct.getCategories()) {
//                        c.getProducts().removeIf(p -> p.getId() == id);
//                    }
                    Toast.makeText(this, "Product deleted successfully", Toast.LENGTH_SHORT).show();
                    Intent resultIntent = new Intent();
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this, "Error deleting product", Toast.LENGTH_SHORT).show();
                    Log.e("ProductDetail", "Error deleting product", e);
                }
            } else {
                Toast.makeText(this, "Cannot delete a new product", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int getNextProductId() {
        int maxId = 0;
        for (Product p : listProduct.getProducts()) {
            if (p.getId() > maxId) maxId = p.getId();
        }
        return maxId + 1;
    }
}