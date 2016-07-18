package com.gav;

/**
 * Created by Gav on 15-Apr-16.
 */
public class HealthyBurger extends Burger {
    private boolean onion;
    private double onionPrice;
    private boolean carrot;
    private double carrotPrice;
    private double price;

    public HealthyBurger(boolean meat, double price) {
        super("Brown rye bread roll", meat, price);
    }

    @Override
    public double overallPrice() {
        double burgerPrice = super.overallPrice();
        if(isOnion()){
            System.out.println("Onion additional price " + getOnionPrice() + ".");
        }
        if(isCarrot()){
            System.out.println("Carrot additional price " + getCarrotPrice() + ".");
        }
        return burgerPrice;
    }

    public double addOnion(){
        setOnion(true);
        this.price += getOnionPrice();
        System.out.println("Added Onion to the burger.");
        return this.price;
    }

    public boolean isOnion() {
        return onion;
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    public double getOnionPrice() {
        this.onionPrice = .25;
        return onionPrice;
    }

    public boolean isCarrot() {
        return carrot;
    }

    public void setCarrot(boolean carrot) {
        this.carrot = carrot;
    }

    public double getCarrotPrice() {
        this.carrotPrice = .35;
        return carrotPrice;
    }
}
