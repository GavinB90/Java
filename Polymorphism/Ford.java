package com.gav;

class Ford extends Car{
    private int wheels = 5;

    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Ford class startEngine()";
    }

    @Override
    public String accelerate() {
        return "Ford class accelerate";
    }

    @Override
    public String brake() {
        return "Ford class brake";
    }

    @Override
    public int getWheels() {
        return wheels;
    }
}