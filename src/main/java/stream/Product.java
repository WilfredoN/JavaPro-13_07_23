package stream;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Product {
    String category;
    double price;
    boolean isDiscount;
    LocalDateTime date;

    public Product(String category, double price, boolean isDiscount, LocalDateTime date) {
        this.category = category;
        this.price = price;
        this.isDiscount = isDiscount;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    public boolean isDiscount() {
        return isDiscount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public static List<Product> toListProductFilter(List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory().equals("Book") && product.getPrice() > 250)
                .toList();
    }

    public static List<Product> toListWithDiscountFilter(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getCategory()) && product.isDiscount())
                .map(product -> new Product(product.getCategory(), product.getPrice() * 0.9, true, product.getDate()))
                .collect(Collectors.toList());
    }

    public static Product getChippestProduct(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getCategory()))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("У категорії книг немає продуктів"));
    }

    public static List<Product> getLastThreeProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .toList();
    }

    public static double getTotalPriceFilter(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getCategory()) && product.getPrice() <= 75 && product.getDate().getYear() == LocalDateTime.now().getYear())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }
}
