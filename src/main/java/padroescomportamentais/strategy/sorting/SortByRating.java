package padroescomportamentais.strategy.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Rating, best first. */
public class SortByRating implements SortStrategy {

    public List<Product> sort(List<Product> products) {
        List<Product> sorted = new ArrayList<>(products);
        sorted.sort(Comparator.comparingDouble(Product::getRating).reversed());
        return sorted;
    }
}
