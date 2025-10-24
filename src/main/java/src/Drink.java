package src;

import java.util.List;

public class Drink {
    private String name;
    private double price;
    private List<String> ingredients;

    public Drink(String name, double price, List<String> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
