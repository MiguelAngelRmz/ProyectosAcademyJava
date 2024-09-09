package com.hw1.springboot3restapijpacrud.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hw1.springboot3restapijpacrud.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        // Consulta para obtener todos los productos
        return entityManager.createQuery("FROM Product", Product.class).getResultList();
    }

    @Override
    public Product findById(Long id) {
        // Obtiene un producto por su ID
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            // Si el producto no tiene ID, lo creamos
            entityManager.persist(product);
        } else {
            // Si el producto ya existe, lo actualizamos
            entityManager.merge(product);
        }
        return product;
    }

    @Override
    public void deleteById(Long id) {
        // Elimina un producto por su ID
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
