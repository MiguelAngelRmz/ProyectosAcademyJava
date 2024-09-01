package com.decorator;

public class NoAdsDecorator extends SubscriptionDecorator {
    public NoAdsDecorator(Subscription decoratedSubscription) {
        super(decoratedSubscription);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", No Ads";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.75; // Costo adicional por eliminación de anuncios
    }
}
