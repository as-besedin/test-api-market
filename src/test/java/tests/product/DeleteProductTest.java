package tests.product;

import models.ErrorStructureResponse;
import models.ProductEntity;
import models.SuccessActionWithProductResponse;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static api.ProductApi.*;
import static enums.Actions.REMOVE;
import static org.junit.jupiter.api.Assertions.*;
import static utils.GenerateUtil.generateUuid;

public class DeleteProductTest {

    @Test
    public void checkingDeleteExistProduct() {
        List<ProductEntity> products = getProducts().getProducts();
        ProductEntity randomProduct = products.get(new Random().nextInt(products.size()));

        SuccessActionWithProductResponse removeProductData = deleteProduct(randomProduct.getId());

        assertAll(
                () -> assertEquals(REMOVE, removeProductData.getAction()),
                () -> assertEquals(randomProduct, removeProductData.getProduct())
        );

        products = getProducts().getProducts();
        boolean isProductExist = products.stream().anyMatch(product -> product.getId().equals(randomProduct.getId()));

        assertFalse(isProductExist);
    }

    @Test
    public void checkingDeleteNotExistProduct() {
        String failId = generateUuid();
        ErrorStructureResponse errorStructureResponse = deleteNotExistProduct(failId);

        assertAll(
                () -> assertEquals(404, errorStructureResponse.getStatus()),
                () -> assertEquals("Not Found", errorStructureResponse.getError())
        );
    }

    @Test
    public void checkingDeleteNotValidProduct() {
        int failId = 10;
        ErrorStructureResponse errorStructureResponse = deleteNotValidProduct(failId);

        assertAll(
                () -> assertEquals(400, errorStructureResponse.getStatus()),
                () -> assertEquals("Bad Request", errorStructureResponse.getError())
        );
    }
}
