package model;


import enums.Color;
import enums.ProductSeparators;

import java.math.BigDecimal;

public class Tshirt extends Product {



    private String size;
    private String material;

    public Tshirt(Integer id, String productName, BigDecimal price, Float weight, Color color, Integer productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "" + ProductSeparators.TSHIRT_ID + ProductSeparators.TSHIRT_ID + getBasicInformationProduct()
                + ProductSeparators.TSHIRT_ID + getSize() + ProductSeparators.TSHIRT_ID + getMaterial();
    }
}