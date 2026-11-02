package padroescomportamentais.strategy.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Price, lowest first. */
public class SortByPrice implements SortStrategy {

    public List<Product> sort(List<Product> products) {
        List<Product> sorted = new ArrayList<>(products);
        sorted.sort(Comparator.comparingDouble(Product::getPrice));
        return sorted;
    }
}
