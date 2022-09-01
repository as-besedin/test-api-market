package tests.category;

import models.CategoryEntity;
import models.ErrorStructureResponse;
import models.SuccessActionWithCategoryResponse;
import org.junit.jupiter.api.Test;

import static api.CategoryApi.*;
import static enums.Actions.ADD;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.GenerateUtil.generateRandomString;

public class CreateCategoryTest {

    private final String NAME = generateRandomString(10);
    private final String BRAND = generateRandomString(10);
    private final boolean IS_VISIBLE = true;

    @Test
    public void checkingCreateCategory() {
        CategoryEntity category = new CategoryEntity(NAME, BRAND, IS_VISIBLE);

        SuccessActionWithCategoryResponse successAddCategoryResponse = createCategory(category);

        assertAll(
                () -> assertEquals(ADD, successAddCategoryResponse.getAction()),
                () -> assertEquals(NAME, successAddCategoryResponse.getCategory().getName()),
                () -> assertEquals(BRAND, successAddCategoryResponse.getCategory().getBrand()),
                () -> assertEquals(IS_VISIBLE, successAddCategoryResponse.getCategory().getIsVisible())
        );
    }

    @Test
    public void checkingCreateCategoryWithoutBody() {
        ErrorStructureResponse errorStructureResponse = createCategoryWithoutBody();

        assertAll(
                () -> assertEquals(400, errorStructureResponse.getStatus()),
                () -> assertEquals("Bad Request", errorStructureResponse.getError())
        );
    }

    @Test
    public void checkingCreateCategoryWithEmptyBody() {
        CategoryEntity category = new CategoryEntity();

        ErrorStructureResponse errorStructureResponse = createCategoryWithEmptyBody(category);

        assertAll(
                () -> assertEquals(400, errorStructureResponse.getStatus()),
                () -> assertEquals("Bad Request", errorStructureResponse.getError())
        );
    }
}
