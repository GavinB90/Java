package com.gav;

/**
 * Created by Gav on 18-Jul-16.
 */
class Porsche extends Car{
    private int wheels = 5;

    public Porsche(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Porsche class startEngine()";
    }

    @Override
    public String accelerate() {
        return "Porsche class accelerate";
    }

    @Override
    public String brake() {
        return "Porsche class brake";
    }

    @Override
    public int getWheels() {
        return wheels;
    }
}
