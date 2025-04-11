import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductStreamProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Smartphone", "Electronics", 900),
            new Product("TV", "Electronics", 1500),
            new Product("Jeans", "Clothing", 60),
            new Product("T-Shirt", "Clothing", 25),
            new Product("Jacket", "Clothing", 120),
            new Product("Banana", "Groceries", 1.2),
            new Product("Apple", "Groceries", 0.8),
            new Product("Steak", "Groceries", 15.0)
        );

        // Group by category
        System.out.println("📦 Products Grouped by Category:");
        Map<String, List<Product>> grouped = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((category, list) -> {
            System.out.println(category + ": " + list);
        });

        // Most expensive product in each category
        System.out.println("\n💰 Most Expensive Product in Each Category:");
        Map<String, Optional<Product>> mostExpensive = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));
        mostExpensive.forEach((category, productOpt) ->
            System.out.println(category + ": " + productOpt.get())
        );

        // Average price of all products
        double avgPrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);
        System.out.printf("\n📊 Average Price of All Products: $%.2f%n", avgPrice);
    }
}
