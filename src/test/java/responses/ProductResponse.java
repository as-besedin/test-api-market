package responses;

import io.restassured.response.ValidatableResponse;
import models.ProductEntity;

import static endpoints.ProductEndpoints.PRODUCT;
import static endpoints.ProductEndpoints.PRODUCTS;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static specs.Specs.getRequestSpec;

public class ProductResponse {

    public static ValidatableResponse getProductsResponse() {
        return given()
                .spec(getRequestSpec())
                .when()
                .get(PRODUCTS.getEndpoint())
                .then();
    }

    public static ValidatableResponse getProductResponse(String productId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .get(format(PRODUCT.getEndpoint(), productId))
                .then();
    }

    public static ValidatableResponse deleteProductResponse(String productId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .delete(format(PRODUCT.getEndpoint(), productId))
                .then();
    }

    public static ValidatableResponse deleteProductResponse(int productId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .delete(format(PRODUCT.getEndpoint(), productId))
                .then();
    }

    public static ValidatableResponse changeProductResponse(String productId, ProductEntity productEntity) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(productEntity)
                .patch(format(PRODUCT.getEndpoint(), productId))
                .then();
    }

    public static ValidatableResponse changeProductResponse(String productId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .patch(format(PRODUCT.getEndpoint(), productId))
                .then();
    }
}
