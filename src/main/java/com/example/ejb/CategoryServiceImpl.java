package com.example.ejb;

import com.example.entities.Category;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CategoryServiceImpl implements CategoryService {

    @PersistenceContext(unitName = "shopPU")
    private EntityManager em;

    @Override
    public List<Category> getAllCategories() {
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
        return query.getResultList();
    }

    @Override
    public Category getCategoryById(Long id) {
        return em.find(Category.class, id);
    }

    @Override
    public void addCategory(Category category) {
        em.persist(category);
    }

    @Override
    public void updateCategory(Category category) {
        em.merge(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
    }
}