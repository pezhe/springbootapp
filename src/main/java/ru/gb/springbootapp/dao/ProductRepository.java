package ru.gb.springbootapp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.springbootapp.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

@Repository
@Transactional
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public Iterable<Product> getProductList() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    public Product get(long id) {
        TypedQuery<Product> query = entityManager.createNamedQuery("findById", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public void add(Product product) {
        //Заглушки для NOT NULL полей даты производства и производителя. Без них не сохраняет
        product.setDate(LocalDate.now());
        product.setManufacturer(1L);
        entityManager.persist(product);
    }

    public void remove(long id) {
        entityManager.remove(get(id));
    }

}
