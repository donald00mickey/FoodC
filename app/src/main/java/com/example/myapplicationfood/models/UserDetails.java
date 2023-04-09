package com.example.myapplicationfood.models;

public class UserDetails {
    String user_name;
    String user_pass;
    String user_designation;

    public UserDetails() {
    }

    public UserDetails(String user_name, String user_pass, String user_designation) {
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.user_designation = user_designation;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_designation() {
        return user_designation;
    }

    public void setUser_designation(String user_designation) {
        this.user_designation = user_designation;
    }
}
