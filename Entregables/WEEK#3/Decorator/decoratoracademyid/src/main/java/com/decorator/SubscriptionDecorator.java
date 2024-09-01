package com.decorator;

public abstract class SubscriptionDecorator implements Subscription {
    protected Subscription decoratedSubscription;

    public SubscriptionDecorator(Subscription decoratedSubscription) {
        this.decoratedSubscription = decoratedSubscription;
    }

    @Override
    public String getDescription() {
        return decoratedSubscription.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedSubscription.getCost();
    }
}
