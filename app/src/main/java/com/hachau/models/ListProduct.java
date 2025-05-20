package com.hachau.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ListProduct implements Serializable {
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void generate_sample_dataset() {
        products.clear();

        products.add(new Product(1, "iPhone 14", 10, 999.99, 1, "Smartphone Apple"));
        products.add(new Product(2, "Samsung TV", 5, 1200.50, 1, "Smart TV Samsung"));
        products.add(new Product(7, "MacBook Pro", 8, 2500.00, 1, "Laptop Apple"));
        products.add(new Product(8, "Bose Headphones", 15, 299.99, 1, "Wireless headphones"));

        products.add(new Product(3, "Harry Potter Book", 20, 15.75, 2, "Bestseller Book"));
        products.add(new Product(9, "Lord of the Rings", 12, 20.00, 2, "Fantasy book"));

        products.add(new Product(4, "Men's Jacket", 10, 49.99, 3, "Winter Jacket"));
        products.add(new Product(10, "Women's Dress", 25, 59.99, 3, "Elegant dress"));

        products.add(new Product(5, "Lego Set", 30, 59.99, 4, "Kids Toy Lego"));
        products.add(new Product(11, "Action Figure", 40, 19.99, 4, "Superhero figure"));

        products.add(new Product(6, "Office Chair", 5, 150.00, 5, "Comfortable Chair"));
        products.add(new Product(12, "Dining Table", 3, 350.00, 5, "Wooden table"));
    }
}
