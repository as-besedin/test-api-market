package tests.product;

import models.ErrorStructureResponse;
import models.ProductEntity;
import models.SuccessActionWithProductResponse;
import models.getProduct.SuccessGetProductResponse;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static api.ProductApi.*;
import static enums.Actions.EDIT;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.GenerateUtil.*;

public class ChangeProductTest {

    private final String NAME = generateRandomString(10);
    private final double AMOUNT = generateRandomNumber(3);
    private final double DISCOUNT = generateRandomNumber(3);
    private final double PERCENT_DISCOUNT = generateRandomNumber(3);
    private final boolean IS_VISIBLE = false;

    @Test
    public void checkingChangeAllProduct() {
        List<ProductEntity> products = getProducts().getProducts();
        ProductEntity randomProduct = products.get(new Random().nextInt(products.size()));
        ProductEntity changedProduct = new ProductEntity(NAME, AMOUNT, DISCOUNT, PERCENT_DISCOUNT, IS_VISIBLE);

        SuccessActionWithProductResponse successEditProductResponse = changeProduct(randomProduct.getId(), changedProduct);

        assertAll(
                () -> assertEquals(EDIT, successEditProductResponse.getAction()),
                () -> assertEquals(randomProduct.getId(), successEditProductResponse.getProduct().getId()),
                () -> assertEquals(NAME, successEditProductResponse.getProduct().getProductName()),
                () -> assertEquals(AMOUNT, successEditProductResponse.getProduct().getAmount()),
                () -> assertEquals(DISCOUNT, successEditProductResponse.getProduct().getDiscount()),
                () -> assertEquals(PERCENT_DISCOUNT, successEditProductResponse.getProduct().getPercentDiscount()),
                () -> assertEquals(IS_VISIBLE, successEditProductResponse.getProduct().isVisible())
        );

        SuccessGetProductResponse successGetProductResponse = getProduct(randomProduct.getId());
        assertEquals(successEditProductResponse.getProduct(), successGetProductResponse.getProduct());
    }

    @Test
    public void checkingChangeNotExistProduct() {
        List<ProductEntity> products = getProducts().getProducts();
        ProductEntity randomProduct = products.get(new Random().nextInt(products.size()));
        String notExistProductId = generateUuid();

        ErrorStructureResponse errorStructureResponse = changeNotExistProduct(notExistProductId, randomProduct);

        assertAll(
                () -> assertEquals(404, errorStructureResponse.getStatus()),
                () -> assertEquals("Not Found", errorStructureResponse.getError())
        );
    }

    @Test
    public void checkingChangeProductWithoutBody() {
        List<ProductEntity> products = getProducts().getProducts();
        ProductEntity randomProduct = products.get(new Random().nextInt(products.size()));

        ErrorStructureResponse errorStructureResponse = changeProductWithoutBody(randomProduct.getId());

        assertAll(
                () -> assertEquals(400, errorStructureResponse.getStatus()),
                () -> assertEquals("Bad Request", errorStructureResponse.getError())
        );
    }

    @Test
    public void checkingChangeProductWithEmptyBody() {
        List<ProductEntity> products = getProducts().getProducts();
        ProductEntity randomProduct = products.get(new Random().nextInt(products.size()));
        ProductEntity changedProduct = new ProductEntity();

        SuccessActionWithProductResponse successEditProductResponse = changeProduct(randomProduct.getId(), changedProduct);

        assertAll(
                () -> assertEquals(EDIT, successEditProductResponse.getAction()),
                () -> assertEquals(randomProduct, successEditProductResponse.getProduct())
        );
    }
}
