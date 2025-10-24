package src;

public class IngredientContainer {
    private Ingredient ingredient;
    private double quantity; // in ml or grams

    public IngredientContainer(Ingredient ingredient, double quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public boolean use(double amount) {
        if (quantity >= amount) {
            quantity -= amount;
            return true;
        }
        return false;
    }

    public void refill(double amount) {
        quantity += amount;
    }

    public String getIngredientName() {
        return ingredient.getName();
    }

    public double getQuantity() {
        return quantity;
    }
}
