package src;

import java.util.*;

public class CoffeeMachine {
    private UserInterface ui;
    private PaymentSystem paymentSystem;
    private MaintenanceSystem maintenanceSystem;
    private Dispenser dispenser;
    private Map<String, Drink> menu;

    public CoffeeMachine() {
        ui = new UserInterface();
        paymentSystem = new PaymentSystem();
        maintenanceSystem = new MaintenanceSystem();
        dispenser = new Dispenser();
        menu = new HashMap<>();

        initializeMenu();
        initializeIngredients();
    }

    private void initializeMenu() {
        menu.put("Espresso", new Drink("Espresso", 2.0, List.of("Water", "CoffeeBeans")));
        menu.put("Latte", new Drink("Latte", 2.5, List.of("Water", "CoffeeBeans", "Milk")));
        menu.put("Cappuccino", new Drink("Cappuccino", 3.0, List.of("Water", "CoffeeBeans", "Milk", "Foam")));
    }

    private void initializeIngredients() {
        dispenser.addContainer(new IngredientContainer(new Ingredient("Water"), 1000));
        dispenser.addContainer(new IngredientContainer(new Ingredient("CoffeeBeans"), 500));
        dispenser.addContainer(new IngredientContainer(new Ingredient("Milk"), 800));
        dispenser.addContainer(new IngredientContainer(new Ingredient("Foam"), 300));
    }

    public void run() {
        ui.displayWelcome();
        while (true) {
            String drinkName = ui.askDrink(menu.keySet());
            Drink drink = menu.get(drinkName);

            if (drink == null) {
                ui.showMessage("Invalid selection. Try again.");
                continue;
            }

            double paid = ui.askForPayment(drink.getPrice());
            boolean success = paymentSystem.processPayment(paid, drink.getPrice());

            if (!success) {
                ui.showMessage("Payment failed. Returning money...");
                paymentSystem.refund(paid);
                continue;
            }

            boolean prepared = dispenser.prepareDrink(drink);
            if (prepared) {
                ui.showMessage(drink.getName() + " is ready. Enjoy!");
            } else {
                ui.showMessage("Error: Not enough ingredients.");
                maintenanceSystem.notifyLowStock();
            }

            if (!ui.askContinue()) {
                ui.showMessage("Goodbye!");
                break;
            }
        }

        maintenanceSystem.generateReport();
    }
}
