package mate.service;

import java.util.List;
import mate.model.Product;

public interface ProductService {
    Product create(Product product);

    Product getById(Long productId);

    Product update(Product product);

    boolean deleteById(Long productId);

    List<Product> getAll();
}
