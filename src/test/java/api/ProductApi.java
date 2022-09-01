package api;

import models.ErrorStructureResponse;
import models.ProductEntity;
import models.SuccessActionWithProductResponse;
import models.getProduct.SuccessGetProductResponse;
import models.getProducts.SuccessGetProductsResponse;

import static org.apache.http.HttpStatus.*;
import static responses.ProductResponse.*;
import static specs.Specs.getResponseSpec;

public class ProductApi {

    public static SuccessGetProductsResponse getProducts() {
        return getProductsResponse()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(SuccessGetProductsResponse.class);
    }

    public static SuccessGetProductResponse getProduct(String productId) {
        return getProductResponse(productId)
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(SuccessGetProductResponse.class);
    }

    public static ErrorStructureResponse getNotExistProduct(String productId) {
        return getProductResponse(productId)
                .spec(getResponseSpec(SC_NOT_FOUND))
                .extract()
                .as(ErrorStructureResponse.class);
    }

    public static ErrorStructureResponse getNotValidProduct(String productId) {
        return getProductResponse(productId)
                .spec(getResponseSpec(SC_BAD_REQUEST))
                .extract()
                .as(ErrorStructureResponse.class);
    }

    public static SuccessActionWithProductResponse deleteProduct(String productId) {
        return deleteProductResponse(productId)
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(SuccessActionWithProductResponse.class);
    }

    public static ErrorStructureResponse deleteNotExistProduct(String productId) {
        return deleteProductResponse(productId)
                .spec(getResponseSpec(SC_NOT_FOUND))
                .extract()
                .as(ErrorStructureResponse.class);
    }

    public static ErrorStructureResponse deleteNotValidProduct(int productId) {
        return deleteProductResponse(productId)
                .spec(getResponseSpec(SC_BAD_REQUEST))
                .extract()
                .as(ErrorStructureResponse.class);
    }

    public static SuccessActionWithProductResponse changeProduct(String productId, ProductEntity product) {
        return changeProductResponse(productId, product)
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(SuccessActionWithProductResponse.class);
    }

    public static ErrorStructureResponse changeProductWithoutBody(String productId) {
        return changeProductResponse(productId)
                .spec(getResponseSpec(SC_BAD_REQUEST))
                .extract()
                .as(ErrorStructureResponse.class);
    }

    public static ErrorStructureResponse changeNotExistProduct(String productId, ProductEntity product) {
        return changeProductResponse(productId, product)
                .spec(getResponseSpec(SC_NOT_FOUND))
                .extract()
                .as(ErrorStructureResponse.class);
    }
}
