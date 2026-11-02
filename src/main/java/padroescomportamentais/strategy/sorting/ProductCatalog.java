package padroescomportamentais.strategy.sorting;

import java.util.List;

public class ProductCatalog {

    private final List<Product> products;

    public ProductCatalog(List<Product> products) {
        this.products = products;
    }

    public List<Product> sort(SortStrategy strategy) {
        return strategy.sort(products);
    }
}
