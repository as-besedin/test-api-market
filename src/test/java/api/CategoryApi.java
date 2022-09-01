package api;

import models.CategoryEntity;
import models.ErrorStructureResponse;
import models.SuccessActionWithCategoryResponse;

import static org.apache.http.HttpStatus.*;
import static responses.CategoryResponse.*;
import static specs.Specs.getResponseSpec;

public class CategoryApi {

    public static SuccessActionWithCategoryResponse createCategory(CategoryEntity category) {
        return createCategoryResponse(category)
                .spec(getResponseSpec(SC_CREATED))
                .extract()
                .as(SuccessActionWithCategoryResponse.class);
    }

    public static ErrorStructureResponse createCategoryWithEmptyBody(CategoryEntity category) {
        return createCategoryResponse(category)
                .spec(getResponseSpec(SC_BAD_REQUEST))
                .extract()
                .as(ErrorStructureResponse.class);
    }

    public static ErrorStructureResponse createCategoryWithoutBody() {
        return createCategoryResponse()
                .spec(getResponseSpec(SC_BAD_REQUEST))
                .extract()
                .as(ErrorStructureResponse.class);
    }

    public static SuccessActionWithCategoryResponse changeCategory(String categoryId, CategoryEntity category) {
        return changeCategoryResponse(categoryId, category)
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(SuccessActionWithCategoryResponse.class);
    }

    public static ErrorStructureResponse changeCategoryWithoutBody(String categoryId) {
        return changeCategoryResponse(categoryId)
                .spec(getResponseSpec(SC_BAD_REQUEST))
                .extract()
                .as(ErrorStructureResponse.class);
    }

    public static ErrorStructureResponse changeNotExistCategory(String categoryId, CategoryEntity categoryEntity) {
        return changeCategoryResponse(categoryId, categoryEntity)
                .spec(getResponseSpec(SC_NOT_FOUND))
                .extract()
                .as(ErrorStructureResponse.class);
    }

    public static SuccessActionWithCategoryResponse deleteCategory(String categoryId) {
        return deleteCategoryResponse(categoryId)
                .spec(getResponseSpec(SC_CREATED))
                .extract()
                .as(SuccessActionWithCategoryResponse.class);
    }

    public static ErrorStructureResponse deleteNotExistCategory(String categoryId) {
        return deleteCategoryResponse(categoryId)
                .spec(getResponseSpec(SC_NOT_FOUND))
                .extract()
                .as(ErrorStructureResponse.class);
    }
}
