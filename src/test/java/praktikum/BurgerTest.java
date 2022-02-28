package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;


    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertThat(burger.bun, equalTo(bun));
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals("Ингредиент не добавлен!", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ингредиент не удален!", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Shot sauce", 100);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        assertEquals("Ингредиент не перемещен!", 1, burger.ingredients.indexOf(sauce));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getPrice()).thenReturn(100f);
        when(ingredient.getPrice()).thenReturn(20f);
        assertEquals("Получена неверная цена ингредиента!", 220, burger.getPrice(), 0.0001);
    }

    @Test
    public void canBeShowedBurgerReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        when(bun.getName()).thenReturn("Bun R2-D3");
        when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient.getName()).thenReturn("Nitro-Burito");
        when(burger.getPrice()).thenReturn(250f);
        String expectedReceipt = "(==== Bun R2-D3 ====)\r\n= filling Nitro-Burito =\r\n(==== Bun R2-D3 ====)\r\n\r\nPrice: 250,000000\r\n";
        assertEquals("Получена неверный рецепт!", expectedReceipt, burger.getReceipt());
    }


}
