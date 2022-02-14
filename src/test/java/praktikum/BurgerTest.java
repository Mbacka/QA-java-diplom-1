package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mock_Bun;
    @Mock
    private Ingredient mock_Ingredient;


    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(mock_Bun);
        assertThat(burger.bun, equalTo(mock_Bun));
    }

    @Test
    public void addIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(mock_Ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(mock_Ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        Burger burger = new Burger();
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Shot sauce", 100);
        Ingredient filling = new Ingredient(IngredientType.FILLING,"cutlet", 100);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        assertEquals(1, burger.ingredients.indexOf(sauce));
    }

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();
        burger.setBuns(mock_Bun);
        burger.addIngredient(mock_Ingredient);
        when(mock_Bun.getPrice()).thenReturn(100f);
        when(mock_Ingredient.getPrice()).thenReturn(20f);
        assertEquals(220, burger.getPrice(), 0.0001);
    }

    @Test
    public void canBeShowedBurgerReceiptTest(){
        Burger burger = new Burger();
        burger.setBuns(mock_Bun);
        burger.addIngredient(mock_Ingredient);
        when(mock_Bun.getName()).thenReturn("Bun R2-D3");
        when(mock_Ingredient.getType()).thenReturn(IngredientType.FILLING);
        when(mock_Ingredient.getName()).thenReturn("Nitro-Burito");
        when(burger.getPrice()).thenReturn(250f);
        String expectedReceipt = "(==== Bun R2-D3 ====)\r\n= filling Nitro-Burito =\r\n(==== Bun R2-D3 ====)\r\n\r\nPrice: 250,000000\r\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }




}
