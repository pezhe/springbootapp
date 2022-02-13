package ru.gb.springbootapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springbootapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
