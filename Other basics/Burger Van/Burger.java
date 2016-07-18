package com.gav;

/**
 * Created by Gav on 15-Apr-16.
 */
public class Burger {
    private String breadRollType;
    private boolean meat = true;
    private boolean lettuce;
    private boolean tomato;
    private boolean cheese;
    private boolean cucumber;
    private double lettucePrice;
    private double tomatoPrice;
    private double cheesePrice;
    private double cucumberPrice;
    private double price;
    private double basePrice = 1.50;
    private int addedItems = 0;

    public Burger(String breadRollType, boolean meat, double price) {
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
    }

    public double overallPrice(){
        double burgerPrice = this.price;
        System.out.println("Base price for burger is " + this.basePrice + ".");
        System.out.println("There are " + addedItems + " additional items");

        if(isCheese()){
            System.out.println("Cheese additional price " + getCheesePrice() + ".");
        }
        if(isTomato()){
            System.out.println("Tomato additional price " + getTomatoPrice() + ".");
        }
        if(isLettuce()){
            System.out.println("Lettuce additional price " + getLettucePrice() + ".");
        }
        if(isCucumber()){
            System.out.println("Cucumber additional price " + getCucumberPrice() + ".");
        }
        System.out.println("Total is " + this.price);
        return burgerPrice;
    }

    public double addCucumber(){
        setCucumber(true);
        this.price += getCucumberPrice();
        System.out.println("Added cucumber to the burger.");
        addedItems++;
        return this.price;
    }

    public double addLettuce(){
        setLettuce(true);
        this.price += getLettucePrice();
        System.out.println("Added lettuce to the burger.");
        addedItems++;
        return this.price;
    }

    public double addTomato(){
        setTomato(true);
        this.price += getTomatoPrice();
        System.out.println("Added tomato to the burger.");
        addedItems++;
        return this.price;
    }

    public double addCheese(){
        setCheese(true);
        this.price += getCheesePrice();
        System.out.println("Added cheese to the burger.");
        addedItems++;
        return this.price;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
    }

    public boolean isTomato() {
        return tomato;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public double getPrice() {
        return price;
    }

    public boolean isCucumber() {
        return cucumber;
    }

    public void setCucumber(boolean cucumber) {
        this.cucumber = cucumber;
    }

    public double getCucumberPrice() {
        this.cucumberPrice = .10;
        return cucumberPrice;
    }

    public double getLettucePrice() {
        this.lettucePrice = .20;
        return lettucePrice;
    }

    public double getTomatoPrice() {
        this.tomatoPrice = .30;
        return tomatoPrice;
    }

    public double getCheesePrice() {
        this.cheesePrice = .40;
        return cheesePrice;
    }

    public String getBreadRollType() {
        return breadRollType;
    }
}
