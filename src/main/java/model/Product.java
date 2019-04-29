package model;


import enums.Color;
import enums.ProductSeparators;

import java.math.BigDecimal;

public class Product {



    private Integer id;
    private String productName;
    private BigDecimal price;
    private Float weight;
    private Color color;
    private Integer productCount;

    public Product(Integer id, String productName, BigDecimal price, Float weight, Color color, Integer productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Float getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public Integer getProductCount() {
        return productCount;
    }

    protected String getBasicInformationProduct() {
        return ""+ProductSeparators.PRODUCT_ID + ProductSeparators.PRODUCT_SEPARATOR + getProductName() + ProductSeparators.PRODUCT_SEPARATOR
                + getPrice() + ProductSeparators.PRODUCT_SEPARATOR
                + getWeight() + ProductSeparators.PRODUCT_SEPARATOR + getColor()
                + ProductSeparators.PRODUCT_SEPARATOR + getProductCount();
    }

    @Override
    public String toString() {
        return "" + ProductSeparators.PRODUCT_SEPARATOR
                + ProductSeparators.PRODUCT_ID+ getBasicInformationProduct();
    }
}