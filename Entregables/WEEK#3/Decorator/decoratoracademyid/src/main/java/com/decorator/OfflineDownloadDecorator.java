package com.decorator;

public class OfflineDownloadDecorator extends SubscriptionDecorator {
    public OfflineDownloadDecorator(Subscription decoratedSubscription) {
        super(decoratedSubscription);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Offline Downloads";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.00; // Costo adicional por descarga sin conexión
    }
}
