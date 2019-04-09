package api;

import model.Product;

import java.util.List;

public interface ProductDao {

    void saveProduct(Product product);
    void saveProducts(List<Product> products);
    void removeProductById(Integer productId);
    void removeProductByName(String productName);
    List<Product>getAllProducts();
    Product getProductById(Integer productId);
    Product getProductByProductName(String productName);
}
