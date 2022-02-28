package praktikum;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IngredientTest {

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals("Неправильная цена ингредиента!", 100, ingredient.getPrice(), 0.0001);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals("Неправильное имя ингредиента!", "hot sauce", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals("Неправильный тип ингредиента!", IngredientType.SAUCE, ingredient.getType());
    }

}
