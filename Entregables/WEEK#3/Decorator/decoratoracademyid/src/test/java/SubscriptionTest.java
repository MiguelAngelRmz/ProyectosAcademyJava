import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.decorator.BasicSubscription;
import com.decorator.NoAdsDecorator;
import com.decorator.OfflineDownloadDecorator;
import com.decorator.PremiumContentDecorator;
import com.decorator.Subscription;

class SubscriptionTest {

    @Test
    void testBasicSubscription() {
        Subscription subscription = new BasicSubscription();
        assertEquals("Basic Subscription", subscription.getDescription());
        assertEquals(7.99, subscription.getCost(), 0.01);
    }

    @Test
    void testOfflineDownloadDecorator() {
        Subscription subscription = new OfflineDownloadDecorator(new BasicSubscription());
        assertEquals("Basic Subscription, Offline Downloads", subscription.getDescription());
        assertEquals(9.99, subscription.getCost(), 0.01);
    }

    @Test
    void testPremiumContentDecorator() {
        Subscription subscription = new PremiumContentDecorator(new BasicSubscription());
        assertEquals("Basic Subscription, Premium Content", subscription.getDescription());
        assertEquals(11.49, subscription.getCost(), 0.01);
    }

    @Test
    void testNoAdsDecorator() {
        Subscription subscription = new NoAdsDecorator(new BasicSubscription());
        assertEquals("Basic Subscription, No Ads", subscription.getDescription());
        assertEquals(9.74, subscription.getCost(), 0.01);
    }

    @Test
    void testCompositeSubscription() {
        Subscription subscription = new PremiumContentDecorator(
                new OfflineDownloadDecorator(
                        new NoAdsDecorator(new BasicSubscription())
                )
        );
        assertEquals("Basic Subscription, No Ads, Offline Downloads, Premium Content", subscription.getDescription());
        assertEquals(15.24, subscription.getCost(), 0.01);
    }
}