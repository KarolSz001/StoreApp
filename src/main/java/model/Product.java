package model;


import java.math.BigDecimal;

public class Product {
    public final static String SEPARATOR_PRODUCT = "#";
    public final static String PRODUCT_ID= "P";
    private Integer id;
    private String productName;
    private BigDecimal price;
    private Float weight;
    private String color;
    private Integer productCount;

    public Product(Integer id, String productName, BigDecimal price, Float weight, String color, Integer productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProductCount(Integer productCount) {
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

    public String getColor() {
        return color;
    }

    public Integer getProductCount() {
        return productCount;
    }

    protected String getBasicInformationProduct(){
        return id + SEPARATOR_PRODUCT + getProductName() + SEPARATOR_PRODUCT
                + getPrice() + SEPARATOR_PRODUCT + getWeight() + SEPARATOR_PRODUCT + getColor() + SEPARATOR_PRODUCT +getProductCount();
    }

    @Override
    public String toString() {
        return PRODUCT_ID + SEPARATOR_PRODUCT + getBasicInformationProduct();
    }
}