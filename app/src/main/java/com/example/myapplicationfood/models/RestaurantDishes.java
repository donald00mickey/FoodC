package com.example.myapplicationfood.models;

import java.io.Serializable;

public class RestaurantDishes implements Serializable {
   String dish_name;
   String price;
   String image;
   String count;

    public RestaurantDishes() {
    }

    public RestaurantDishes(String dish_name, String price, String image) {
        this.dish_name = dish_name;
        this.price = price;
        this.image = image;
    }

    public RestaurantDishes(String dish_name, String price, String image, String count) {
        this.dish_name = dish_name;
        this.price = price;
        this.image = image;
        this.count = count;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
