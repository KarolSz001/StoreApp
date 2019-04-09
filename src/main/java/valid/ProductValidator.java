package valid;


import exception.MyUncheckedException;
import model.Product;

import java.math.BigDecimal;

public class ProductValidator {
    private static ProductValidator instance = null;

    private ProductValidator() {

    }

    public static ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }

        return instance;
    }

    public boolean isValidate(Product product) throws MyUncheckedException {
        if (isPriceNoPositive(product.getPrice())) {
            throw new MyUncheckedException("Product price is no positive.");
        }

        if (isCountNegative(product.getProductCount())) {
            throw new MyUncheckedException("Product count is less than 0.");
        }

        if (isWeightNoPositive(product.getWeight())) {
            throw new MyUncheckedException("Product weight is less or equals 0.");
        }

        if (isNameEmpty(product.getProductName())) {
            throw new MyUncheckedException("Product name cannot be empty.");
        }

        return true;
    }

    private boolean isNameEmpty(String productName) {
        return productName.length() == 0;
    }

    private boolean isWeightNoPositive(Float weight) {
        return weight <= 0.0f;
    }

    private boolean isCountNegative(Integer productCount) {
        return productCount < 0;
    }

    private boolean isPriceNoPositive(BigDecimal price) {
        return price.compareTo(BigDecimal.ZERO) <= 0;
    }
}
