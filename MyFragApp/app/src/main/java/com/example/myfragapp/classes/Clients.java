package com.example.myfragapp.classes;

import java.util.ArrayList;
//I should have called the class :Client
public class Clients {
    private String username;
    private String password;
    private String phone;
    private ArrayList<Ingredient> ingredients; //To add the ingredients per each client ,

    public Clients(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.ingredients = new ArrayList<>();
    }
    // Getters and setters for the fields

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }


}
