package com.example.myapplicationfood.models;

public class OrderModel {
    String order_no;
    String status;
    String table_no;
    String price;

    public OrderModel(String order_no, String status, String table_no, String price) {
        this.order_no = order_no;
        this.status = status;
        this.table_no = table_no;
        this.price = price;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTable_no() {
        return table_no;
    }

    public void setTable_no(String table_no) {
        this.table_no = table_no;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
