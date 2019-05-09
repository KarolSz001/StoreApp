package model.parser;

import model.Boots;
import model.Product;
import model.Tshirt;

import java.math.BigDecimal;

import enums.*;

import static enums.ProductSeparators.*;



public class ProductParser {


    public static Product getProductFromString(String productStr) {
        final ProductSeparators productType = getIdByChar(productStr.substring(0,1));
        switch (productType) {
            case PRODUCT_ID: {
                return convertToProduct(productStr);
            }
            case TSHIRT_ID: {
                return convertToTshirt(productStr);
            }
            case BOOTS_ID: {
                return convertToBoots(productStr);
            }
        }

        return null;
    }


    private static Boots convertToBoots(String productStr) {
        String[] productInformations = productStr.split(String.valueOf(PRODUCT_SEPARATOR));
        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = BigDecimal.valueOf(Float.valueOf(productInformations[3]));
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.convertStringToColor(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);
        Integer size = Integer.parseInt(productInformations[7]);
        Boolean isNaturalSkin = Boolean.parseBoolean(productInformations[8]);
        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    private static Tshirt convertToTshirt(String productStr) {
        String[] productInformations = productStr.split(String.valueOf(PRODUCT_SEPARATOR));
        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = BigDecimal.valueOf(Float.valueOf(productInformations[3]));
        Float weight = Float.parseFloat(productInformations[3]);
        Color color = ColorParser.convertStringToColor(productInformations[4]);
        Integer productCount = Integer.parseInt(productInformations[5]);
        String size = productInformations[6];
        Material material = MaterialParser.convertStringToMaterial(productInformations[7]);
        return new Tshirt(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String productStr) {
        String[] productInformations = productStr.split(String.valueOf(PRODUCT_SEPARATOR));
        Integer id = Integer.parseInt(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = BigDecimal.valueOf(Float.valueOf(productInformations[3]));
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.convertStringToColor(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);
        return new Product(id, productName, price, weight, color, productCount);
    }
}
