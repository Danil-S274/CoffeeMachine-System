package src;

import java.util.*;

public class Dispenser {
    private Map<String, IngredientContainer> containers = new HashMap<>();

    public void addContainer(IngredientContainer container) {
        containers.put(container.getIngredientName(), container);
    }

    public boolean prepareDrink(Drink drink) {
        for (String ingredient : drink.getIngredients()) {
            IngredientContainer container = containers.get(ingredient);
            if (container == null || container.getQuantity() < 50) {
                return false;
            }
        }

        for (String ingredient : drink.getIngredients()) {
            containers.get(ingredient).use(50);
        }
        System.out.println("Preparing " + drink.getName() + "...");
        return true;
    }
}
