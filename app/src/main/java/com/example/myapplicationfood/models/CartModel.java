package com.example.myapplicationfood.models;

public class CartModel {
    String dish_name;
    String dish_price;
    String dish_image;
    String count;

    public CartModel() {
    }

    public CartModel(String dish_name, String dish_price, String dish_image, String count) {
        this.dish_name = dish_name;
        this.dish_price = dish_price;
        this.dish_image = dish_image;
        this.count = count;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getDish_price() {
        return dish_price;
    }

    public void setDish_price(String dish_price) {
        this.dish_price = dish_price;
    }

    public String getDish_image() {
        return dish_image;
    }

    public void setDish_image(String dish_image) {
        this.dish_image = dish_image;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
