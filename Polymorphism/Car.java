package com.gav;

/**
 * Created by Gav on 18-Jul-16.
 */
class Car{
    private boolean engine;
    private int cylinders;
    private int wheels;
    private String name;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public String startEngine(){
        return "Class Car method startEngine() has started the engine.";
    }

    public String accelerate(){
        return "Class car method accelerate() has accelerated.";
    }

    public String brake(){
        return "Class car method brake() has broke";
    }

    public String getName() {
        return name;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }
}
