package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String type;
    private final int expectedNumber;

    public IngredientTypeTest(String type, int expectedNumber) {
        this.type = type;
        this.expectedNumber = expectedNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getTypes() {
        return new Object[][]{
                {"SAUCE", 0},
                {"FILLING", 1}
        };
    }

    @Test
    public void enumContainTypeTest() {
        int actualNumber = IngredientType.valueOf(IngredientType.class, type).ordinal();
        assertEquals("Ожидалось другое количество типов ингредиентов!", expectedNumber, actualNumber);
    }
}
