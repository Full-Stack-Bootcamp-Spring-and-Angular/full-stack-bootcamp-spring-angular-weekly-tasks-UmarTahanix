package dao;

import model.Product;
import model.ProductDetails;

import java.util.List;

public interface ProductDao {
    void insert(ProductDetails productDetails);
    void update(ProductDetails productDetails);
    List<Product> getAllProducts();
    void deleteById(int theId);
}
