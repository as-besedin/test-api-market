package tests.category;

import models.CategoryEntity;
import models.ErrorStructureResponse;
import models.SuccessActionWithCategoryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static api.CategoryApi.*;
import static enums.Actions.REMOVE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.GenerateUtil.generateRandomString;
import static utils.GenerateUtil.generateUuid;

public class DeleteCategoryTest {

    private final String NAME = generateRandomString(10);
    private final String BRAND = generateRandomString(10);
    private final boolean IS_VISIBLE = true;

    private CategoryEntity category;

    @BeforeEach
    public void setUp() {
        CategoryEntity categoryEntity = new CategoryEntity(NAME, BRAND, IS_VISIBLE);

        category = createCategory(categoryEntity).getCategory();
    }

    @Test
    public void checkingDeleteCategory() {
        SuccessActionWithCategoryResponse successDeleteCategoryResponse = deleteCategory(category.getId());

        assertAll(
                () -> assertEquals(REMOVE, successDeleteCategoryResponse.getAction()),
                () -> assertEquals(category.getName(), successDeleteCategoryResponse.getCategory().getName()),
                () -> assertEquals(category.getBrand(), successDeleteCategoryResponse.getCategory().getBrand()),
                () -> assertEquals(category.getIsVisible(), successDeleteCategoryResponse.getCategory().getIsVisible())
        );
    }

    @Test
    public void checkingDeleteNotExistCategory() {
        String notExistCategoryId = generateUuid();

        ErrorStructureResponse errorStructureResponse = deleteNotExistCategory(notExistCategoryId);

        assertAll(
                () -> assertEquals(404, errorStructureResponse.getStatus()),
                () -> assertEquals("Not Found", errorStructureResponse.getError())
        );
    }
}
