package model;


import java.math.BigDecimal;

public class Boots extends Product {
    public final static String BOOTS_ID = "B";
    private Integer size;
    private boolean isWaterProof;


    public Boots(Integer id, String productName, BigDecimal price, Float weight, String color, Integer productCount, Integer size, boolean isWaterProof) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isWaterProof = isWaterProof;
    }

    public Integer getSize() {
        return size;
    }

    public static String getBootsId() {
        return BOOTS_ID;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setWaterProof(boolean waterProof) {
        isWaterProof = waterProof;
    }

    public boolean isWaterProof() {
        return isWaterProof;
    }

    @Override
    public String toString() {
        return BOOTS_ID + SEPARATOR_PRODUCT + getBasicInformationProduct()
                + SEPARATOR_PRODUCT + getSize() + SEPARATOR_PRODUCT + isWaterProof()  ;
    }
}