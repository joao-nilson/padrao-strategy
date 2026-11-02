package padroescomportamentais.strategy.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Date, newest first. */
public class SortByDate implements SortStrategy {

    public List<Product> sort(List<Product> products) {
        List<Product> sorted = new ArrayList<>(products);
        sorted.sort(Comparator.comparing(Product::getDate).reversed());
        return sorted;
    }
}
