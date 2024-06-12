package prakticum;

import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BurgerMockTest {

    @Test
    public void removeIngredientTestShouldRemoveIngredientFromList() {
        Burger burger = new Burger();
        Ingredient ingredient = mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTestShouldChangeIngredientIndex() {
        Burger burger = new Burger();
        Ingredient ingredient = mock(Ingredient.class);
        Ingredient secondIngredient = mock(Ingredient.class);
        Mockito.when(ingredient.getName()).thenReturn("RexBurger");
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("RexBurger", burger.ingredients.get(1).getName());
    }
}

