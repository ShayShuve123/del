package com.example.myfragapp.classes;

public class Ingredient {
    private String ingredientName;
    private int ingredientAmount;
    private int ingredientImage;
    private int ingredientPrice;


    public Ingredient(String ingredientName,int ingredientPrice, int ingredientImage) {
        this.ingredientName = ingredientName;
        this.ingredientAmount = 0;
        this.ingredientPrice =  ingredientPrice;
        this.ingredientImage = ingredientImage;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(int ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    public int getIngredientImage() {
        return ingredientImage;
    }

    public void setIngredientImage(int ingredientImage) {
        this.ingredientImage = ingredientImage;
    }

    public int getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(int ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }





}
