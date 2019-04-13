package model;


import java.math.BigDecimal;

public class Tshirt extends Product {

    public final static String TSHIRT_ID = "T";
    private String size;
    private String material;

    public Tshirt(Integer id, String productName, BigDecimal price, Float weight, String color, Integer productCount, String size, String material) {
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
        return TSHIRT_ID + SEPARATOR_PRODUCT + getBasicInformationProduct()
                + SEPARATOR_PRODUCT + getSize() + SEPARATOR_PRODUCT + getMaterial();
    }
}