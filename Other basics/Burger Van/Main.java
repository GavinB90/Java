package com.gav;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        DecimalFormat df2 = new DecimalFormat("#.00");

//        Burger hamburger = new Burger("Roll", true, 1.50);
//
//        hamburger.addCheese();
//        System.out.println("Burger costs " +  df2.format(hamburger.getPrice()));
//
//        hamburger.addLettuce();
//        hamburger.overallPrice();

        HealthyBurger healthyBurger = new HealthyBurger(true, 1.70);

        healthyBurger.addOnion();
        healthyBurger.overallPrice();
        System.out.println(df2.format(healthyBurger.getPrice()));
        System.out.println(healthyBurger.getBreadRollType());
    }

}
