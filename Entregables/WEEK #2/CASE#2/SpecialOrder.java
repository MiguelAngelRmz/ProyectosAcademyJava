import java.util.List;

public class SpecialOrder extends Order {

    public SpecialOrder(String orderId, String customer, List<Product> products, String status, String date) {
        super(orderId, customer, products, status, date);
    }
}
