package praktikum;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IngredientTest {

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"hot sauce", 100);
        assertEquals(100, ingredient.getPrice(), 0.0001);
    }

    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"hot sauce", 100);
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"hot sauce", 100);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

}
