package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("R2-D3", 85);

    @Test
    public void testGetName() {
        String expectedName = "R2-D3";
        String actualName = bun.getName();
        assertEquals("Получено неверное имя!", expectedName, actualName);
    }

    @Test
    public void testGetPrice() {
        float expectedPrice = 85;
        float actualPrice = bun.getPrice();
        assertEquals("Получена неверная стоимость!", expectedPrice, actualPrice, 0.0001);
    }

}
