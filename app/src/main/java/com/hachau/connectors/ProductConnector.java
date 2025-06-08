//package com.hachau.connectors;
//
//import com.hachau.models.ListProduct;
//import com.hachau.models.Product;
//
//import java.util.ArrayList;
//
//public class ProductConnector {
//    private ListProduct listProduct;
//
//    public ProductConnector() {
//        listProduct = new ListProduct();
//        listProduct.generate_sample_dataset();
//    }
//
//    public ArrayList<Product> get_all_products() {
//        if (listProduct == null) {
//            listProduct = new ListProduct();
//            listProduct.generate_sample_dataset();
//        }
//        return listProduct.getProducts();
//    }
//
//    public ArrayList<Product> get_products_by_category(int categoryId) {
//        if (listProduct == null) {
//            listProduct = new ListProduct();
//            listProduct.generate_sample_dataset();
//        }
//
//        ArrayList<Product> results = new ArrayList<>();
//        for (Product p : listProduct.getProducts()) {
//            if (p.getCate_id() == categoryId) {
//                results.add(p);
//            }
//        }
//        return results;
//    }
//}
