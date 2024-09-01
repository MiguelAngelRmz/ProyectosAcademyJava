package com.builder;
public abstract class Vehicle {
    // Required parameters for all vehicles
    protected String engine;
    protected String transmission;

    // Constructor protegido para la clase base
    protected Vehicle(String engine, String transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }

    // Métodos comunes
    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        return "Vehicle [Engine=" + engine + ", Transmission=" + transmission + "]";
    }
}
