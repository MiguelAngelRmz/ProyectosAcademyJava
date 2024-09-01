package com.decorator;

public class Main {
    public static void main(String[] args) {
        Subscription basicSubscription = new BasicSubscription();

        Subscription premiumSubscription = new PremiumContentDecorator(
                new OfflineDownloadDecorator(
                        new NoAdsDecorator(basicSubscription)
                )
        );

        System.out.println("Subscription: " + premiumSubscription.getDescription());
        System.out.println("Total Cost: $" + premiumSubscription.getCost());
    }
}
