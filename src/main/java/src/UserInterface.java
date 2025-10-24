package src;

import java.util.*;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void displayWelcome() {
        System.out.println("=== Welcome to the Public Coffee Machine ===");
    }

    public String askDrink(Set<String> menuItems) {
        System.out.println("Available drinks:");
        for (String drink : menuItems) {
            System.out.println("- " + drink);
        }
        System.out.print("Select your drink: ");
        return scanner.nextLine();
    }

    public double askForPayment(double price) {
        System.out.printf("Price: $%.2f. Please insert money: ", price);
        return Double.parseDouble(scanner.nextLine());
    }

    public boolean askContinue() {
        System.out.print("Do you want another drink? (y/n): ");
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
