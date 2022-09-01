package responses;

import io.restassured.response.ValidatableResponse;
import models.CategoryEntity;

import static endpoints.CategoryEndpoints.ADD_CATEGORY;
import static endpoints.CategoryEndpoints.CATEGORY;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static specs.Specs.getRequestSpec;

public class CategoryResponse {

    public static ValidatableResponse createCategoryResponse(CategoryEntity category) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(category)
                .post(ADD_CATEGORY.getEndpoint())
                .then();
    }

    public static ValidatableResponse createCategoryResponse() {
        return given()
                .spec(getRequestSpec())
                .when()
                .post(ADD_CATEGORY.getEndpoint())
                .then();
    }

    public static ValidatableResponse changeCategoryResponse(String categoryId, CategoryEntity category) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(category)
                .patch(format(CATEGORY.getEndpoint(), categoryId))
                .then();
    }

    public static ValidatableResponse changeCategoryResponse(String categoryId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .patch(format(CATEGORY.getEndpoint(), categoryId))
                .then();
    }

    public static ValidatableResponse deleteCategoryResponse(String categoryId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .delete(format(CATEGORY.getEndpoint(), categoryId))
                .then();
    }
}
