package stream;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {
    Product product_1 = new Product("Book", 30.0, false, LocalDateTime.of(2023, 9, 1, 12, 20));
    Product product_2 = new Product("Book", 25.0, true, LocalDateTime.of(2023, 9, 1, 12, 25));
    Product product_3 = new Product("Electronics", 500.0, false, LocalDateTime.of(2023, 9, 1, 12, 30));
    Product product_4 = new Product("Sport", 120.0, false, LocalDateTime.of(2023, 8, 30, 23, 50));
    Product product_5 = new Product("Games", 60.0, true, LocalDateTime.of(2023, 8, 30, 23, 55));
    Product product_6 = new Product("Games", 30.0, false, LocalDateTime.of(2023, 9, 1, 12, 10));
    List<Product> products = Arrays.asList(product_1, product_2, product_3, product_4, product_5, product_6);

    @Test
    public void shouldToFilterAndToList() {
        List<Product> result = Product.toListProductFilter(products);
        assertEquals(0, result.size());
    }

    @Test
    public void shouldToShowProductsWithDiscount() {
        List<Product> result = Product.toListWithDiscountFilter(products);
        assertEquals(1, result.size());
        assertEquals(22.5, result.get(0).getPrice());
    }

    @Test
    public void shouldToShowChippestProduct() {
        Product result = Product.getChippestProduct(products);
        assertEquals(25.0, result.getPrice());
    }

    @Test
    public void shouldToShowLastThreeProducts() {
        List<Product> result = Product.getLastThreeProducts(products);
        List<Product> toCompare = List.of(product_3, product_2, product_1);
        for (var i = 0; i < toCompare.size(); i++) {
            assertEquals(toCompare.get(i).getPrice(), result.get(i).getPrice());
        }
    }

    @Test
    public void shouldToCalculateTotalPrice() {
        double result = Product.getTotalPriceFilter(products);
        assertEquals(55.0, result);
    }

    @Test
    public void shouldToGroupByCategory() {
        Map<String, List<Product>> result = Product.groupByCategory(products);
        assertTrue(result.containsKey("Book"));
        assertTrue(result.containsKey("Sport"));
        assertTrue(result.containsKey("Electronics"));
        assertTrue(result.containsKey("Games"));

    }
}