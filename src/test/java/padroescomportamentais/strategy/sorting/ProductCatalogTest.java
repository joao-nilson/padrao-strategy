package padroescomportamentais.strategy.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductCatalogTest {

    // Each sort criterion yields a different order, so a wrong strategy can't pass by accident.
    //   name   -> apple, Banana, cherry
    //   date   -> cherry, apple, Banana   (newest first)
    //   price  -> Banana, cherry, apple   (lowest first)
    //   rating -> Banana, apple, cherry   (best first)
    private Product apple;
    private Product banana;
    private Product cherry;
    private List<Product> input;
    private ProductCatalog catalog;

    @BeforeEach
    void setUp() {
        apple  = new Product("apple",  LocalDate.of(2024, 3, 10), 9.0, 4.1);
        banana = new Product("Banana", LocalDate.of(2023, 1, 15), 2.0, 4.8);
        cherry = new Product("cherry", LocalDate.of(2025, 6, 1),  5.0, 3.5);
        input = Arrays.asList(cherry, banana, apple);
        catalog = new ProductCatalog(input);
    }

    @Test
    void shouldSortByNameIgnoringCase() {
        assertEquals(Arrays.asList(apple, banana, cherry), catalog.sort(new SortByName()));
    }

    @Test
    void shouldSortByDateNewestFirst() {
        assertEquals(Arrays.asList(cherry, apple, banana), catalog.sort(new SortByDate()));
    }

    @Test
    void shouldSortByPriceLowestFirst() {
        assertEquals(Arrays.asList(banana, cherry, apple), catalog.sort(new SortByPrice()));
    }

    @Test
    void shouldSortByRatingBestFirst() {
        assertEquals(Arrays.asList(banana, apple, cherry), catalog.sort(new SortByRating()));
    }

    @Test
    void shouldSwapStrategyOnTheSameCatalog() {
        assertEquals(Arrays.asList(banana, cherry, apple), catalog.sort(new SortByPrice()));
        assertEquals(Arrays.asList(banana, apple, cherry), catalog.sort(new SortByRating()));
    }

    @Test
    void shouldNotModifyTheOriginalList() {
        catalog.sort(new SortByName());
        catalog.sort(new SortByDate());
        catalog.sort(new SortByPrice());
        catalog.sort(new SortByRating());
        assertEquals(Arrays.asList(cherry, banana, apple), input);
    }

    @Test
    void shouldSortEmptyList() {
        ProductCatalog empty = new ProductCatalog(Collections.emptyList());
        assertTrue(empty.sort(new SortByName()).isEmpty());
    }

    @Test
    void shouldKeepOriginalOrderOnTies() {
        Product first = new Product("first", LocalDate.of(2024, 1, 1), 10.0, 4.0);
        Product second = new Product("second", LocalDate.of(2024, 1, 1), 10.0, 4.0);
        ProductCatalog tied = new ProductCatalog(Arrays.asList(first, second));

        assertEquals(Arrays.asList(first, second), tied.sort(new SortByPrice()));
    }
}
