package dao;

import api.ProductDao;
import model.Product;
import utils.FileUtils;
import java.io.FileNotFoundException;
import model.parser.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDaoImpl implements ProductDao {

    private static String fileName = "products.data";
    private static ProductDaoImpl instance = null;

    private ProductDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProductDaoImpl getInstance()  {

        if(instance == null){
            instance = new ProductDaoImpl();
        }
        return instance;
    }



    @Override
    public void saveProduct(Product product) {
        List<Product> productList = getAllProducts();
        productList.add(product);
        saveProducts(productList);
    }

    @Override
    public void saveProducts(List<Product> products) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (int i = 0; i < products.size(); i++) {
                printWriter.println(products.get(i).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeProductById(Integer productId) {
        List<Product> productList = getAllProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(productId)) {
                productList.remove(i);
            }
        }
        saveProducts(productList);
    }

    @Override
    public void removeProductByName(String productName) {
        List<Product> productList = getAllProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().equals(productName)) {
                productList.remove(i);
            }
        }
        saveProducts(productList);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {
                Product product = ProductParser.getProductFromString(sc.nextLine());
                productList.add(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

}
