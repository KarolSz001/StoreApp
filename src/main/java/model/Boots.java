package model;


import enums.Color;
import enums.ProductSeparators;

import java.math.BigDecimal;

public class Boots extends Product {

    public static final char BOOTS_TYPE = 'B';
    private Integer size;
    private boolean isWaterProof;


    public Boots(Integer id, String productName, BigDecimal price, Float weight, Color color, Integer productCount, Integer size, boolean isWaterProof) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isWaterProof = isWaterProof;
    }

    public Integer getSize() {
        return size;
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
        return "" + ProductSeparators.BOOTS_ID + ProductSeparators.BOOTS_ID + getBasicInformationProduct()
                + ProductSeparators.BOOTS_ID + getSize() + ProductSeparators.BOOTS_ID + isWaterProof()  ;
    }
}