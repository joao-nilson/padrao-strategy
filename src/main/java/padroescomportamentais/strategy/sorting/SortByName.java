package padroescomportamentais.strategy.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Name, A to Z (case-insensitive). */
public class SortByName implements SortStrategy {

    public List<Product> sort(List<Product> products) {
        List<Product> sorted = new ArrayList<>(products);
        sorted.sort(Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER));
        return sorted;
    }
}
