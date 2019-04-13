/*
package service;

import model.Boots;
import model.Product;
import model.Tshirt;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetCountProductsPositive(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Boots(1,"TRAKI",new BigDecimal(200),10f,"WHITE",2,41,true));
        productList.add(new Tshirt(1,"KRATA",new BigDecimal(22),300f,"BLACK",1,"M","COTTON"));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        int siezOfList = productService.getCountProducts();
        Assert.assertEquals(2,siezOfList);

    }

    @Test
    public void testGetCountProductsNegative(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Boots(1,"TRAKI",new BigDecimal(200),10f,"WHITE",2,41,true));
        productList.add(new Tshirt(1,"KRATA",new BigDecimal(22),300f,"BLACK",1,"M","COTTON"));

        ProductServiceImpl productService = new ProductServiceImpl(productList);
        int siezOfList = productService.getCountProducts();
        Assert.assertNotEquals(100,siezOfList);

    }

    @Test
    public void testGetAllProductsPositive(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Boots(1,"TRAKI",new BigDecimal(200),10f,"WHITE",2,41,true));
        productList.add(new Tshirt(1,"KRATA",new BigDecimal(22),300f,"BLACK",1,"M","COTTON"));
        ProductServiceImpl userService = new ProductServiceImpl(productList);
        List<Product> listFromTestClass = userService.getAllProducts();

        Assert.assertEquals(productList,listFromTestClass);

    }

    @Test
    public void testGetAllProductsNegative(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Boots(1,"TRAKI",new BigDecimal(200),10f,"WHITE",2,41,true));
        productList.add(new Tshirt(1,"KRATA",new BigDecimal(22),300f,"BLACK",1,"M","COTTON"));
        ProductServiceImpl userService = new ProductServiceImpl(productList);
        List<Product> listFromTestClass = userService.getAllProducts();
        listFromTestClass.add(new Boots(2,"KOZAKI",new BigDecimal(211),9f,"BLACK",2,43,true));

        Assert.assertNotEquals(productList,listFromTestClass);

    }
    @Test
    public static void testGetProductByNameExist(){
        List<Product> products = new ArrayList<>();
        Product tshirt = new Tshirt(1,"KRATA",new BigDecimal(22),300f,"BLACK",1,"S","COTTON");
        Product boots = new Boots(1,"TRAKI",new BigDecimal(200),10f,"WHITE",2,41,true);
        products.add(tshirt);
        products.add(boots);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product product = productService.getProductByName("KRATA");

        Assert.assertEquals(product,tshirt);
    }
    public static void testGetProductByNameNoExist(){
        List<Product> products = new ArrayList<>();
        Product tshirt = new Tshirt(1,"KRATA",new BigDecimal(22),300f,"BLACK",1,"S","COTTON");
        Product boots = new Boots(1,"TRAKI",new BigDecimal(200),10f,"WHITE",2,41,true);
        products.add(tshirt);
        products.add(boots);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product product = productService.getProductByName("AAAAA");

        Assert.assertEquals(product,null);
    }





}
*/
