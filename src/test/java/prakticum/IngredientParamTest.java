package prakticum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParamTest {


    public IngredientType type;
    public String name;
    public float price;

    public double delta = 0.0001;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1377},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000},
                {IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424},
                {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988},
                {IngredientType.FILLING, "Хрустящие минеральные кольца", 300},
                {IngredientType.FILLING, "Плоды Фалленианского дерева", 874},
                {IngredientType.FILLING, "Кристаллы марсианских альфа-сахаридов", 762},
                {IngredientType.FILLING, "Мини-салат Экзо-Плантаго", 4400},
                {IngredientType.FILLING, "Сыр с астероидной плесенью", 4142},
                {IngredientType.SAUCE, "Соус Spicy-X", 90},
                {IngredientType.SAUCE, "Соус фирменный Space Sauce", 80},
                {IngredientType.SAUCE, "Соус традиционный галактический", 15},
                {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88}
        };
    }

    @Test
    public void getIngredientTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(type, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(),delta);
    }
}
