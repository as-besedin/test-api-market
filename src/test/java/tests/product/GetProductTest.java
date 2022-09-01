package tests.product;

import models.ErrorStructureResponse;
import models.ProductEntity;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static api.ProductApi.*;
import static api.ProductApi.getNotValidProduct;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.GenerateUtil.generateUuid;

public class GetProductTest {

    @Test
    public void checkingGetExistProduct() {
        List<ProductEntity> products = getProducts().getProducts();
        ProductEntity randomProduct = products.get(new Random().nextInt(products.size()));

        ProductEntity actualProductData = getProduct(randomProduct.getId()).getProduct();

        assertEquals(randomProduct, actualProductData);
    }

    @Test
    public void checkingGetNotExistProduct() {
        String notExistId = generateUuid();
        ErrorStructureResponse errorStructureResponse = getNotExistProduct(notExistId);

        assertAll(
                () -> assertEquals(404, errorStructureResponse.getStatus()),
                () -> assertEquals("Not Found", errorStructureResponse.getError())
        );
    }

    @Test
    public void checkingGetProductWithNoValidId() {
        String failId = "test";
        ErrorStructureResponse errorStructureResponse = getNotValidProduct(failId);

        assertAll(
                () -> assertEquals(400, errorStructureResponse.getStatus()),
                () -> assertEquals("Bad Request", errorStructureResponse.getError())
        );
    }
}
