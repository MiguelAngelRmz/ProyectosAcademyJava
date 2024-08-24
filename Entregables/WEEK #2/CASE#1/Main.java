import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Product> listProducts = Arrays.asList(
            new Electronics("Laptop", 10),
            new Clothing("Shirt", 0),
            new Electronics("TV", 5),
            new Clothing("Shoes", 15),
            new Appliances("Refrigerator", 0),
            new Clothing("Pants", 8),
            new Electronics("Smartphone", 0),
            new Furniture("Sofa", 2),
            new Furniture("Table", 0),
            new Food("Milk", 20)
        );

        // Filter products out of stock
        List<Product> listProdOutOfStock = listProducts.stream()
            .filter(product -> product.getQuantityOfStock() == 0)
            .collect(Collectors.toList());

        listProdOutOfStock.forEach(System.out::println);

        // Identify categories with no stock
        List<String> listOfCategoryOutStock = listProdOutOfStock.stream()
            .map(Product::getCategory)
            .distinct()
            .collect(Collectors.toList());

        listOfCategoryOutStock.forEach(System.out::println);

        // Group products by category
        Map<String, List<Product>> listForCategory = listProducts.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        listForCategory.forEach((category, products) -> {
            System.out.println("Category: " + category);
            products.forEach(product -> System.out.println("  " + product));
            System.out.println(); // Space between categories
        });
    }
}
