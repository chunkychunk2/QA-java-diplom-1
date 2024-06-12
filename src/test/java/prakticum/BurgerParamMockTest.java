package prakticum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class BurgerParamMockTest {

    public String bunName;
    public float bunPrice;

    public IngredientType ingredientType;

    public String ingredientName;

    public float ingredientPrice;

    public double delta = 0.0001;

    public BurgerParamMockTest(String bunName, float bunPrice, IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"black bun", 100F, IngredientType.SAUCE, "hot sauce", 100F},
                {"white bun", 200F, IngredientType.SAUCE, "sour cream", 200F},
                {"red bun", 300F, IngredientType.FILLING, "sausage", 300F}
        };
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        Bun bun = mock(Bun.class);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Ingredient ingredient = mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.addIngredient(ingredient);
        assertEquals(bunPrice * 2 + ingredientPrice, burger.getPrice(), delta);
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        Bun bun = mock(Bun.class);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Ingredient ingredient = mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.addIngredient(ingredient);
        assertEquals("(==== " + bunName + " ====)\n" +
                "= " + ingredientType.toString().toLowerCase() + " " + ingredientName + " =\r\n" +
                "(==== " + bunName + " ====)\r\n" +
                "\n" +
                "Price: " + String.format("%.6f", burger.getPrice()) + "\r\n", burger.getReceipt());
    }
}
