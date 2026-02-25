package util;

import model.Product;
import model.ProductDetails;

import java.util.List;

public interface ProductService {
    void insert(ProductDetails productDetails);
    void update(ProductDetails productDetails);
    void deleteById(int theId);
    List<Product> getAllProducts();
}
