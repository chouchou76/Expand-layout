package com.hachau.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return id + " - " + name;
    }
}



//    public Category() {
//        products=new ArrayList<>();
//    }
//
//    public Category(int id, String name, int img_id) {
//        this.id = id;
//        this.name = name;
//        this.img_id = img_id;
//        products=new ArrayList<>();
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getImg_id() {
//        return img_id;
//    }
//
//    public void setImg_id(int img_id) {
//        this.img_id = img_id;
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
//    @NonNull
//    @Override
//    public String toString() {
//        return id+"\t"+name;
//    }
//    public void addProduct(Product p)
//    {
//        products.add(p);
//    }

    //    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

