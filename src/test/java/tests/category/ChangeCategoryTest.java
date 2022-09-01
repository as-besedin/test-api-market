package tests.category;

import models.CategoryEntity;
import models.ErrorStructureResponse;
import models.SuccessActionWithCategoryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static api.CategoryApi.*;
import static enums.Actions.EDIT;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.GenerateUtil.generateRandomString;
import static utils.GenerateUtil.generateUuid;

public class ChangeCategoryTest {

    private final String NAME = generateRandomString(10);
    private final String BRAND = generateRandomString(10);
    private final boolean IS_VISIBLE = false;

    private final String NEW_NAME = generateRandomString(10);
    private final String NEW_BRAND = generateRandomString(10);
    private final boolean NEW_IS_VISIBLE = true;

    private CategoryEntity category;

    @BeforeEach
    public void setUp() {
        CategoryEntity categoryEntity = new CategoryEntity(NAME, BRAND, IS_VISIBLE);

        category = createCategory(categoryEntity).getCategory();
    }

    @Test
    public void checkingChangeCategory() {
        CategoryEntity changedCategory = new CategoryEntity(NEW_NAME, NEW_BRAND, NEW_IS_VISIBLE);

        SuccessActionWithCategoryResponse successEditCategoryResponse = changeCategory(category.getId(), changedCategory);

        assertAll(
                () -> assertEquals(EDIT, successEditCategoryResponse.getAction()),
                () -> assertEquals(category.getId(), successEditCategoryResponse.getCategory().getId()),
                () -> assertEquals(changedCategory.getName(), successEditCategoryResponse.getCategory().getName()),
                () -> assertEquals(changedCategory.getBrand(), successEditCategoryResponse.getCategory().getBrand()),
                () -> assertEquals(changedCategory.getIsVisible(), successEditCategoryResponse.getCategory().getIsVisible())
        );
    }

    @Test
    public void checkingChangeCategoryWithEmptyBody() {
        CategoryEntity changedCategory = new CategoryEntity();

        SuccessActionWithCategoryResponse successEditCategoryResponse = changeCategory(category.getId(), changedCategory);

        assertAll(
                () -> assertEquals(EDIT, successEditCategoryResponse.getAction()),
                () -> assertEquals(category.getId(), successEditCategoryResponse.getCategory().getId()),
                () -> assertEquals(category.getName(), successEditCategoryResponse.getCategory().getName()),
                () -> assertEquals(category.getBrand(), successEditCategoryResponse.getCategory().getBrand()),
                () -> assertEquals(category.getIsVisible(), successEditCategoryResponse.getCategory().getIsVisible())
        );
    }

    @Test
    public void checkingChangeCategoryWithoutBody() {
        ErrorStructureResponse errorStructureResponse = changeCategoryWithoutBody(category.getId());

        assertAll(
                () -> assertEquals(400, errorStructureResponse.getStatus()),
                () -> assertEquals("Bad Request", errorStructureResponse.getError())
        );
    }

    @Test
    public void checkingChangeNotExistCategory() {
        CategoryEntity changedCategory = new CategoryEntity(NEW_NAME, NEW_BRAND, NEW_IS_VISIBLE);
        String notExistCategoryId = generateUuid();

        ErrorStructureResponse errorStructureResponse = changeNotExistCategory(notExistCategoryId, changedCategory);

        assertAll(
                () -> assertEquals(404, errorStructureResponse.getStatus()),
                () -> assertEquals("Not Found", errorStructureResponse.getError())
        );
    }
}
