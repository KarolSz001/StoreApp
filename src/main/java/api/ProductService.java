package api;

import model.Product;

import java.io.IOException;
import java.util.List;


    public interface ProductService {
        List<Product> getAllProducts() throws IOException;
        Integer getCountProducts() throws IOException;
        Product getProductByProductName(String productName) throws IOException;

        boolean isProductOnWarehouse(String productName);
        boolean isProductExist(String productName) throws IOException;
        boolean isProductExist(Integer productId);

        boolean saveProduct(Product product) throws IOException;
        void removeProduct(String productname) throws Exception;
    }

