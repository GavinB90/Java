package com.gav;

public class Main {

    public static void main(String[] args) {
        // Creating and calling Car class
        Car car = new Car(5, "Car");

        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        //Creating and calling Porsche class
        Porsche porsche = new Porsche(10, "Porsche");

        System.out.println(porsche.startEngine());
        System.out.println(porsche.accelerate());
        System.out.println(porsche.brake());

        System.out.println(porsche.getWheels());

        // Creating and calling Ford class
        Ford ford = new Ford(8, "Ford");

        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        System.out.println(ford.getWheels());
    }
}

