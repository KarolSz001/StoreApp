package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import model.Product;
import valid.ProductValidator;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance = null;

    ProductValidator productValidator = ProductValidator.getInstance();
    ProductDao productDao = ProductDaoImpl.getInstance();

    ProductServiceImpl() {

    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }


    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    public Integer getCountProducts() throws IOException {
        return productDao.getAllProducts().size();
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products;
        products = productDao.getAllProducts();

        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductOnWarehouse(String productName) {
        try {
            for(Product product : getAllProducts())
            if(isProductExist(productName ) && product.getProductCount() > 0)
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean isProductExist(String productName) throws IOException {
        Product product = getProductByProductName(productName);
        return product != null;
    }

    @Override
    public boolean isProductExist(Integer productId) {
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

    @Override
    public void removeProduct(String productName) throws Exception {
        productDao.removeProductByName(productName);

    }


}
