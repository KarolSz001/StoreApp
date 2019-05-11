package facade;


import api.ProductFacade;
import api.ProductService;
import model.Product;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade {

    private final static ProductFacade instance = new ProductFacadeImpl();
    private final ProductService productService = (ProductService) ProductServiceImpl.getInstance();

    private ProductFacadeImpl() {

    }

    public static ProductFacade getInstance() {
        return ProductFacadeImpl.instance;
    }

    @Override
    public String createProduct(Product product) {
        try {
            productService.saveProduct(product);
            return "Create product " + product;
        } catch (IOException e) {
            e.printStackTrace();
            return "[IOException] Error while add product to database";
        }
    }



    @Override
    public String removeProduct(String productName) {
        try{
            productService.removeProduct(productName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        try{
            return productService.getAllProducts();

        }catch(IOException e){
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
