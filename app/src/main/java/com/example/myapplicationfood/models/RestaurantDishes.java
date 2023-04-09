package com.example.myapplicationfood.models;

public class RestaurantDishes {
   String dish_name;
   String price;
   String image;

    public RestaurantDishes() {
    }

    public RestaurantDishes(String dish_name, String price, String image) {
        this.dish_name = dish_name;
        this.price = price;
        this.image = image;
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
}
