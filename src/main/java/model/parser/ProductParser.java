package model.parser;

import model.Boots;
import model.Product;
import model.Tshirt;

import java.math.BigDecimal;

import enums.*;

import java.math.BigDecimal;

public class ProductParser {


    public static Product getProductFromString(String productStr) {
        final char productType = productStr.charAt(0);
        switch (productType) {
            case Product.PRODUCT_TYPE: {
                return convertToProduct(productStr);
            }
            case Tshirt.TSHIRT_TYPE: {
                return convertToProduct(productStr);
            }
            case Boots.BOOTS_TYPE: {
                return convertToProduct(productStr);
            }
        }

        return null;
    }


    private static Boots convertToBoots(String productStr) {
        String[] productInformations = productStr.split(String.valueOf(ProductSeparators.PRODUCT_SEPARATOR));
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
        String[] productInformations = productStr.split(String.valueOf(ProductSeparators.PRODUCT_SEPARATOR));
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
        String[] productInformations = productStr.split(String.valueOf(ProductSeparators.PRODUCT_SEPARATOR));
        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = BigDecimal.valueOf(Float.valueOf(productInformations[3]));
        Float weight = Float.parseFloat(productInformations[4]);
        String color = productInformations[5];
        Integer productCount = Integer.parseInt(productInformations[6]);
        return new Product(id, productName, price, weight, color, productCount);
    }
}
