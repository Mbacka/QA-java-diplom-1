package praktikum;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class DatabaseTest {

    @Test
    public void availableBunsTest() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertEquals("Доступно неверное количество булок!", 3, buns.size());
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals("Доступно неверное количество ингредиентов!", 6, ingredients.size());
    }

}