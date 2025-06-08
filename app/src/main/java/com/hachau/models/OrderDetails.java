package com.hachau.models;

public class OrderDetails {
    private int id;
    private int OrderId;
    private int Productid;
    private int Quantity;
    private double Price;
    private double VAT;
    private double Discount;
    private double TotalValue;

    public OrderDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getProductid() {
        return Productid;
    }

    public void setProductid(int productid) {
        Productid = productid;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public double getTotalValue() {
        TotalValue=(Quantity*Price-Discount/100*Quantity*Price)*(1+VAT/100);
        return TotalValue;
    }

}
