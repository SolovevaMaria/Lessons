package HomeControllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class HomeController {

    @Autowired
    private EntityManager entityManager;

    // Сохранение
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product createdProduct = saveProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Получение
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Получение по ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = findProductById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Обновление
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                 @Valid @RequestBody Product productDetails) {
        Optional<Product> existingProduct = findProductById(id);

        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(productDetails.getName());
            updatedProduct.setDescription(productDetails.getDescription());
            updatedProduct.setPrice(productDetails.getPrice());

            Product updated = saveProduct(updatedProduct);
            return ResponseEntity.ok(updated);
        }

        return ResponseEntity.notFound().build();
    }

    // Удаление
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = findProductById(id);

        if (product.isPresent()) {
            deleteProductById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    // Поиск по ID
    @PostMapping("/find-by-ids")
    public ResponseEntity<List<Product>> findByIds(@RequestBody List<Long> ids) {
        List<Product> products = findAllById(ids);
        return ResponseEntity.ok(products);
    }

    // Подсчет количества
    @GetMapping("/count")
    public ResponseEntity<Long> countProducts() {
        ResponseEntity<Long> count = countProducts();
        return ResponseEntity.ok(count.getBody());
    }

    // Проверка есть или нет
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> checkExists(@PathVariable Long id) {
        boolean exists = existsById(id);
        return ResponseEntity.ok(exists);
    }

    // Внутренние методы
    private Product saveProduct(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            return entityManager.merge(product);
        }
        return product;
    }

    private List<Product> findAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    private Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(entityManager.find(Product.class, id));
    }

    private boolean existsById(Long id) {
        return findProductById(id).isPresent();
    }

    private List<Product> findAllById(List<Long> ids) {
        TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.id IN :ids", Product.class);
        query.setParameter("ids", ids);
        return query.getResultList();
    }

    private long getProductCount() {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(p) FROM Product p", Long.class);
        return query.getSingleResult();
    }

    private void deleteProductById(Long id) {
        Product product = findProductById(id).orElse(null);
        if (product != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(product);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw new RuntimeException("Ошибка при удалении: " + e.getMessage());
            }
        }
    }

    // Метод удаления всего
    private void deleteAllProducts() {
        try {
            entityManager.getTransaction().begin();
            List<Product> products = findAllProducts();
            for (Product product : products) {
                entityManager.remove(product);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Ошибка при удалении: " + e.getMessage());
        }
    }

    // Метод для выборочного удаления
    private void deleteProduct(Product product) {
        if (product != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(product);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw new RuntimeException("Ошибка при удалении: " + e.getMessage());
            }
        }
    }
}
