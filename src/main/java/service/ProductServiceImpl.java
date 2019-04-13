package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import model.Product;
import valid.ProductValidator;
import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;
    private static ProductServiceImpl instance = null;

    ProductValidator productValidator = ProductValidator.getInstance();
    ProductDao productDao = ProductDaoImpl.getInstance();

   ProductServiceImpl() {

    }

    public static ProductServiceImpl getInstance() {
        if(instance == null){
            instance = new ProductServiceImpl();
        }
        return instance;
    }




    public List<Product> getAllProducts() {
        return products;
    }

    public Integer getCountProducts() {
        return products.size();
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        return null;
    }

    @Override
    public boolean isProductOnWarehouse(String productName) {
        return false;
    }

    public Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public boolean isProductOnStore(String productName) {
        for (Product product : products) {
            if (isProductExist(productName) && product.getProductCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isProductExist(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isProductExist(Integer productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean saveProduct(Product product) {
        try {
            if (productValidator.isValidate(product)) {
                productDao.saveProduct(product);

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }

}
