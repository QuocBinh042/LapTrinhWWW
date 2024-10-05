package bai2.dao;

import bai2.models.Product;

import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);
    List<Product> getAllProducts();
    void deleteProduct(int productId);
    void updateProduct(Product product);
    boolean isDatabaseEmpty();
    void insertInitialData();
}
