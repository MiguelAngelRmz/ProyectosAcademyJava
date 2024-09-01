package com.decorator;

public class BasicSubscription implements Subscription {
    @Override
    public String getDescription() {
        return "Basic Subscription";
    }

    @Override
    public double getCost() {
        return 7.99; // Precio básico
    }
}
