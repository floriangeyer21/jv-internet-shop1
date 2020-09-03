package mate.dao.impl;

import java.util.List;
import java.util.Optional;
import mate.dao.ProductDao;
import mate.db.Storage;
import mate.lib.Dao;
import mate.model.Product;

@Dao
public class ProductDaoImpl implements ProductDao {

    @Override
    public Product create(Product product) {
        Storage.addProduct(product);
        return product;
    }

    @Override
    public Optional<Product> getById(Long productId) {
        return getAll().stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst();
    }

    @Override
    public Product update(Product product) {
        List<Product> products = getAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                products.set(i, product);
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Long productId) {
        return Storage.products
                .removeIf(product -> product.getId().equals(productId));
    }

    @Override
    public List<Product> getAll() {
        return Storage.products;
    }
}
