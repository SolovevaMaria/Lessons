package HomeControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // save
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // saveAll
    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    // findById
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    // existsById
    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    // findAll
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    // findAllById
    public List<Product> findAllById(List<Long> ids) {
        return productRepository.findAllById(ids);
    }

    // count
    public long countProducts() {
        return productRepository.count();
    }

    // deleteById
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    // delete
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    // deleteAll
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
