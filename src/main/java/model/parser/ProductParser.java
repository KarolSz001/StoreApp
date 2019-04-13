package model.parser;

import model.Boots;
import model.Product;
import model.Tshirt;

import java.math.BigDecimal;

import static model.Boots.BOOTS_ID;
import static model.Product.PRODUCT_ID;
import static model.Tshirt.TSHIRT_ID;

public class ProductParser {


    public static Product getProductFromString(String productStr) {
        final String productType = String.valueOf(productStr.charAt(0));
        switch (productType){
            case PRODUCT_ID:{
                return convertToProduct(productStr);
            }
            case TSHIRT_ID:{
                return convertToProduct(productStr);
            }
            case BOOTS_ID:{
                return convertToProduct(productStr);
            }
        }

        return null;
    }



    private static Boots convertToBoots(String productStr) {
        String [] productInformations = productStr.split(Product.SEPARATOR_PRODUCT);

        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = BigDecimal.valueOf(Float.valueOf(productInformations[3]));
        Float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        Integer productCount = Integer.parseInt(productInformations[6]);
        Integer size = Integer.parseInt(productInformations[7]);
        Boolean isNaturalSkin = Boolean.parseBoolean(productInformations[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    private static Tshirt convertToTshirt(String productStr) {
        String [] productInformations = productStr.split(Product.SEPARATOR_PRODUCT);

        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = BigDecimal.valueOf(Float.valueOf(productInformations[3]));
        Float weight = Float.parseFloat(productInformations[3]);
        String color = productInformations[4];
        Integer productCount = Integer.parseInt(productInformations[5]);
        String size = productInformations[6];
        String material = productInformations[7];

        return new Tshirt(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String productStr) {
        String [] productInformations = productStr.split(Product.SEPARATOR_PRODUCT);

        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = BigDecimal.valueOf(Float.valueOf(productInformations[3]));
        Float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        Integer productCount = Integer.parseInt(productInformations[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }
}
