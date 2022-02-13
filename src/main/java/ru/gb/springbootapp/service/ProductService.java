package ru.gb.springbootapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.springbootapp.dao.ProductRepository;
import ru.gb.springbootapp.model.Product;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository repo;

    public List<Product> getSortedProductList(Sort.Direction direction) {
        return repo.findAll(Sort.by(direction, "title"));
    }

    public void add(Product product) {
        //Заглушки для NOT NULL полей даты производства и производителя. Без них не сохраняет
        product.setDate(LocalDate.now());
        product.setManufacturer(1L);
        repo.save(product);
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product findById(long id) {
        return repo.findById(id).get();
    }

    public void remove(long id) {
        repo.delete(findById(id));
    }

}
