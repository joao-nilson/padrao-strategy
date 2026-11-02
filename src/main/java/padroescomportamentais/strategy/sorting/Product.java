package padroescomportamentais.strategy.sorting;

import java.time.LocalDate;

public class Product {

    private final String name;
    private final LocalDate date;
    private final double price;
    private final double rating;

    public Product(String name, LocalDate date, double price, double rating) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return name;
    }
}
