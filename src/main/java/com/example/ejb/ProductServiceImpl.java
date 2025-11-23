package com.example.ejb;

import com.example.entities.Product;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProductServiceImpl implements ProductService {

    @PersistenceContext(unitName = "shopPU")
    private EntityManager em;

    @Override
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public Product getProductById(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public void addProduct(Product product) {
        em.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        em.merge(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }
}