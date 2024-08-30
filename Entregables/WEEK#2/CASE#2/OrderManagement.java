import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderManagement {
    public static void main(String[] args) {
        // Sample data
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("001", "Alice", List.of(new Product("Laptop", 1000.00), new Product("Mouse", 25.00)), "Shipped", "2024-08-01"));
        orders.add(new Order("002", "Bob", List.of(new Product("Keyboard", 75.00)), "Pending", "2024-08-05"));
        orders.add(new Order("003", "Alice", List.of(new Product("Monitor", 300.00)), "Shipped", "2024-08-03"));
        orders.add(new Order("004", "Charlie", List.of(new Product("Laptop", 1000.00), new Product("Desk", 150.00)), "Delivered", "2024-08-10"));
        orders.add(new Order("005", "Bob", List.of(new Product("Mouse", 25.00), new Product("Keyboard", 75.00)), "Pending", "2024-08-07"));

        // 1. Filter and Sort Orders by Status and Date
        String statusToFilter = "Shipped";
        List<Order> filteredAndSortedOrders = orders.stream()
            .filter(o -> o.getStatus().equals(statusToFilter))
            .sorted((o1, o2) -> o1.getDate().compareTo(o2.getDate()))
            .collect(Collectors.toList());
        System.out.println("Filtered and Sorted Orders: " + filteredAndSortedOrders);

        // 2. Transform Products to Prices
        List<Double> productPrices = orders.stream()
            .flatMap(o -> o.getProducts().stream())
            .map(Product::getPrice)
            .collect(Collectors.toList());
        System.out.println("Product Prices: " + productPrices);

        // 3. Remove Duplicates and Calculate Average Price
        double averagePrice = orders.stream()
            .flatMap(o -> o.getProducts().stream())
            .map(Product::getPrice)
            .distinct()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);
        System.out.println("Average Price of Unique Products: " + averagePrice);

        // 4. Group Orders by Customer and Filter
        double salesThreshold = 1100.00;
        Map<String, Double> highSpendingCustomers = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getCustomer,
                Collectors.summingDouble(o -> o.getProducts().stream().mapToDouble(Product::getPrice).sum())))
            .entrySet().stream()
            .filter(entry -> entry.getValue() > salesThreshold)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("High Spending Customers: " + highSpendingCustomers);

        // 5. Sort Customers by Number of Orders
        Map<String, Long> ordersCountByCustomer = orders.stream()
            .collect(Collectors.groupingBy(Order::getCustomer, Collectors.counting()));
        List<Map.Entry<String, Long>> sortedCustomers = ordersCountByCustomer.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .collect(Collectors.toList());
        System.out.println("Customers Sorted by Number of Orders: " + sortedCustomers);
    }
}
