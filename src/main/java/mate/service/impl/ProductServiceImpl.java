package mate.service.impl;

import java.util.List;
import mate.dao.ProductDao;
import mate.lib.Inject;
import mate.lib.Service;
import mate.model.Product;
import mate.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductDao productDao;

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product getById(Long productId) {
        return productDao.getById(productId).get();
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean deleteById(Long productId) {
        return productDao.deleteById(productId);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
}
