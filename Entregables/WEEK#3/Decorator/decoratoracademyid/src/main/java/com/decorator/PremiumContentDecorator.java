package com.decorator;

public class PremiumContentDecorator extends SubscriptionDecorator {
    public PremiumContentDecorator(Subscription decoratedSubscription) {
        super(decoratedSubscription);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Premium Content";
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.50; // Costo adicional por contenido premium
    }
}
