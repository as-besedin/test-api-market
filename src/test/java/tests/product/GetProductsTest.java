package tests.product;

import models.getProducts.SuccessGetProductsResponse;
import org.junit.jupiter.api.Test;

import static api.ProductApi.getProducts;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetProductsTest {

    @Test
    public void checkingGetProducts() {
        SuccessGetProductsResponse products = getProducts();

        assertTrue(products.getProducts().size() > 0);
    }
}
