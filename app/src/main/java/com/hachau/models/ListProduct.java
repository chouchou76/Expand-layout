package com.hachau.models;

import android.util.Log;
import com.hachau.myapplication.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

//public class ListProduct implements Serializable {
//    private ArrayList<Product> products;
//    private ArrayList<Category> categories;
//
//    public ListProduct() {
//        products = new ArrayList<>();
//        categories = new ArrayList<>();
//    }
//
//    public ArrayList<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(ArrayList<Product> products) {
//        this.products = products;
//    }
//
//    public ArrayList<Category> getCategories() {
//        return categories;
//    }
//
//    public void addProduct(Product p) {
//        products.add(p);
//    }
//
//    public void generate_sample_dataset() {
//        // Tạo danh sách mô tả mẫu
//        String[] sampleDescriptions = {
//                "Fresh and juicy",
//                "Organic product",
//                "High quality",
//                "Sweet and delicious",
//                "Best seller",
//                "Limited edition"
//        };
//        Random random = new Random();
//
//        categories.clear();
//        products.clear();
//        Log.d("ListProduct", "Cleared categories and products");
//
//        // Category 1 - Soft Drink
//        Category c1 = new Category(110, "Soft Drink", 1);
//        Product p1 = new Product(1, "Coca Cola", 100, 10.0, 110, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p2 = new Product(2, "Pepsi", 120, 9.5, 110, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p3 = new Product(3, "7Up", 90, 8.0, 110, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p4 = new Product(4, "Fanta", 85, 8.5, 110, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p5 = new Product(5, "Sprite", 95, 9.0, 110, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c1.addProduct(p1); c1.addProduct(p2); c1.addProduct(p3); c1.addProduct(p4); c1.addProduct(p5);
//        categories.add(c1);
//        products.add(p1); products.add(p2); products.add(p3); products.add(p4); products.add(p5);
//
//        // Category 2 - Cake
//        Category c2 = new Category(111, "Cake", 1);
//        Product p6 = new Product(6, "Chocolate Cake", 30, 25.0, 111, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p7 = new Product(7, "Cheesecake", 20, 28.0, 111, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p8 = new Product(8, "Carrot Cake", 25, 22.0, 111, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p9 = new Product(9, "Tiramisu", 15, 30.0, 111, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p10 = new Product(10, "Pineapple Cake", 18, 26.5, 111, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c2.addProduct(p6); c2.addProduct(p7); c2.addProduct(p8); c2.addProduct(p9); c2.addProduct(p10);
//        categories.add(c2);
//        products.add(p6); products.add(p7); products.add(p8); products.add(p9); products.add(p10);
//
//        // Category 3 - Fastfood
//        Category c3 = new Category(112, "Fastfood", 1);
//        Product p11 = new Product(11, "Burger", 50, 20.0, 112, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p12 = new Product(12, "Fried Chicken", 60, 22.5, 112, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p13 = new Product(13, "Pizza", 40, 30.0, 112, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p14 = new Product(14, "Hotdog", 55, 18.0, 112, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p15 = new Product(15, "French Fries", 70, 15.0, 112, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c3.addProduct(p11); c3.addProduct(p12); c3.addProduct(p13); c3.addProduct(p14); c3.addProduct(p15);
//        categories.add(c3);
//        products.add(p11); products.add(p12); products.add(p13); products.add(p14); products.add(p15);
//
//        // Category 4 - Beer
//        Category c4 = new Category(113, "Beer", 1);
//        Product p16 = new Product(16, "Heineken", 100, 18.0, 113, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p17 = new Product(17, "Tiger", 90, 17.0, 113, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p18 = new Product(18, "Budweiser", 80, 19.0, 113, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p19 = new Product(19, "Larue", 110, 15.0, 113, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p20 = new Product(20, "Saigon Beer", 95, 16.0, 113, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c4.addProduct(p16); c4.addProduct(p17); c4.addProduct(p18); c4.addProduct(p19); c4.addProduct(p20);
//        categories.add(c4);
//        products.add(p16); products.add(p17); products.add(p18); products.add(p19); products.add(p20);
//
//        // Category 5 - Seafood
//        Category c5 = new Category(114, "Seafood", 1);
//        Product p21 = new Product(21, "Grilled Squid", 25, 45.0, 114, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p22 = new Product(22, "Fried Shrimp", 30, 50.0, 114, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p23 = new Product(23, "Oyster", 20, 40.0, 114, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p24 = new Product(24, "Lobster", 10, 150.0, 114, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p25 = new Product(25, "Fish Fillet", 35, 35.0, 114, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c5.addProduct(p21); c5.addProduct(p22); c5.addProduct(p23); c5.addProduct(p24); c5.addProduct(p25);
//        categories.add(c5);
//        products.add(p21); products.add(p22); products.add(p23); products.add(p24); products.add(p25);
//
//        // Category 6 - Vegetarian
//        Category c6 = new Category(115, "Vegetarian", 1);
//        Product p26 = new Product(26, "Tofu Soup", 40, 20.0, 115, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p27 = new Product(27, "Stir-fried Vegetables", 45, 22.0, 115, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p28 = new Product(28, "Veggie Burger", 30, 25.0, 115, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p29 = new Product(29, "Vegetarian Pizza", 35, 28.0, 115, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p30 = new Product(30, "Mushroom Hotpot", 25, 32.0, 115, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c6.addProduct(p26); c6.addProduct(p27); c6.addProduct(p28); c6.addProduct(p29); c6.addProduct(p30);
//        categories.add(c6);
//        products.add(p26); products.add(p27); products.add(p28); products.add(p29); products.add(p30);
//
//        // Category 7 - Fruit
//        Category c7 = new Category(116, "Fruit", 1);
//        Product p31 = new Product(31, "Apple", 100, 5.0, 116, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p32 = new Product(32, "Banana", 120, 3.0, 116, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p33 = new Product(33, "Mango", 80, 7.0, 116, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p34 = new Product(34, "Orange", 90, 6.0, 116, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p35 = new Product(35, "Grapes", 85, 8.0, 116, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c7.addProduct(p31); c7.addProduct(p32); c7.addProduct(p33); c7.addProduct(p34); c7.addProduct(p35);
//        categories.add(c7);
//        products.add(p31); products.add(p32); products.add(p33); products.add(p34); products.add(p35);
//
//        // Category 8 - Snack
//        Category c8 = new Category(117, "Snack", 1);
//        Product p36 = new Product(36, "Potato Chips", 150, 12.0, 117, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p37 = new Product(37, "Popcorn", 100, 10.0, 117, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p38 = new Product(38, "Rice Crackers", 130, 11.5, 117, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p39 = new Product(39, "Nuts Mix", 90, 13.0, 117, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p40 = new Product(40, "Choco Bar", 140, 9.5, 117, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c8.addProduct(p36); c8.addProduct(p37); c8.addProduct(p38); c8.addProduct(p39); c8.addProduct(p40);
//        categories.add(c8);
//        products.add(p36); products.add(p37); products.add(p38); products.add(p39); products.add(p40);
//
//        // Category 9 - Coffee
//        Category c9 = new Category(118, "Coffee", 1);
//        Product p41 = new Product(41, "Espresso", 80, 15.0, 118, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p42 = new Product(42, "Cappuccino", 75, 18.0, 118, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p43 = new Product(43, "Latte", 85, 17.5, 118, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p44 = new Product(44, "Black Coffee", 90, 12.0, 118, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p45 = new Product(45, "Iced Coffee", 95, 14.0, 118, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c9.addProduct(p41); c9.addProduct(p42); c9.addProduct(p43); c9.addProduct(p44); c9.addProduct(p45);
//        categories.add(c9);
//        products.add(p41); products.add(p42); products.add(p43); products.add(p44); products.add(p45);
//
//        // Category 10 - Ice Cream
//        Category c10 = new Category(119, "Ice Cream", 1);
//        Product p46 = new Product(46, "Vanilla", 60, 20.0, 119, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p47 = new Product(47, "Chocolate", 70, 21.0, 119, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p48 = new Product(48, "Strawberry", 65, 19.5, 119, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p49 = new Product(49, "Matcha", 55, 22.0, 119, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        Product p50 = new Product(50, "Mango Sorbet", 50, 18.0, 119, sampleDescriptions[random.nextInt(sampleDescriptions.length)], random.nextInt(100) + 1);
//        c10.addProduct(p46); c10.addProduct(p47); c10.addProduct(p48); c10.addProduct(p49); c10.addProduct(p50);
//        categories.add(c10);
//        products.add(p46); products.add(p47); products.add(p48); products.add(p49); products.add(p50);
//
//        // Log danh sách sản phẩm
//        Log.d("ListProduct", "Generated " + products.size() + " products");
//        for (Product p : products) {
//            Log.d("ListProduct", "Product: " + p.getName() + ", Description: " + (p.getDescription() != null ? p.getDescription() : "null"));
//        }
//    }
//}

public class ListProduct {
    ArrayList<Product> products;
    public ListProduct()
    {
        products=new ArrayList<>();
    }

    public ArrayList<Product> getProducts()
    {
        return products;
    }

    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }

    public void generate_sample_product_dataset() {
        Category c1 = new Category(110, "Soft Drink", 1);
        Product p1 = new Product(1, "Coca Cola", 100, 10.0, R.mipmap.coca);
        Product p2 = new Product(2, "Pepsi", 120, 9.5, R.mipmap.pepsi);
        Product p3 = new Product(3, "7Up", 90, 8.0, R.mipmap.sevenup);
        Product p4 = new Product(4, "Fanta", 85, 8.5, R.mipmap.fanta);
        Product p5 = new Product(5, "Sprite", 95, 9.0, R.mipmap.sprite);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
    }
}