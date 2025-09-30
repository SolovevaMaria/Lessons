package HomeControllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    @Autowired
    private EntityManager entityManager;

    // save
    public Product save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            return entityManager.merge(product);
        }
        return product;
    }

    // saveAll
    public List<Product> saveAll(List<Product> products) {
        products.forEach(product -> save(product));
        return products;
    }

    // findById
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Product.class, id));
    }

    // existsById
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    // findAll
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    // findAllById
    public List<Product> findAllById(List<Long> ids) {
        TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.id IN :ids", Product.class);
        query.setParameter("ids", ids);
        return query.getResultList();
    }

    // count
    public long count() {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(p) FROM Product p", Long.class);
        return query.getSingleResult();
    }

    // deleteById
    public void deleteById(Long id) {
        Product product = findById(id).orElse(null);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    // delete
    public void delete(Product product) {
        entityManager.remove(product);
    }

    // deleteAll
    public void deleteAll() {
        List<Product> products = findAll();
        products.forEach(this::delete);
    }
}
