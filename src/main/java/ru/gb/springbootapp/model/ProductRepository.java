package ru.gb.springbootapp.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Getter
public class ProductRepository {

    private long idCounter;
    private final List<Product> productList = new ArrayList<>();

    public Optional<Product> get(long id) {
        return productList
                .stream()
                .filter(c -> c.getId() == id)
                .findAny();
    }

    public void add(Product product) {
        product.setId(++idCounter);
        productList.add(product);
    }

    public void remove(long id) {
        get(id).ifPresent(productList::remove);
    }

}
