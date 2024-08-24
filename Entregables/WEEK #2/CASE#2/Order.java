import java.util.List;

public class Order {
    String orderId;
    String customer;
    List<Product> products;
    String status;
    String date;

    // Constructor, getters, and setters
    public Order(String orderId, String customer, List<Product> products, String status, String date) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.status = status;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }
}
