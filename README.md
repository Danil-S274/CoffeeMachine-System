# ☕ Public Coffee Machine System

### 🧩 Description  
**Public Coffee Machine System** is a Java-based simulation that models the operation of a public coffee vending machine — like those found in universities, hospitals, or on the street.  
The system simulates user interaction, payment processing, drink preparation, ingredient management, and maintenance alerts.

---

##  Features
- Choose from multiple drinks (Espresso, Latte, Cappuccino)
- Process payments and calculate change
- Manage and track ingredients
- Prepare drinks automatically if ingredients are available
- Maintenance alerts when stock is low
- Console-based user interface

---

## System Requirements

### Functional Requirements
1. The user can select a drink from the menu.  
2. The system accepts payments and returns change if needed.  
3. The system checks ingredient availability before preparing a drink.  
4. The drink is prepared and dispensed if ingredients are sufficient.  
5. The system alerts maintenance when ingredients run low.  
6. The system generates a maintenance and transaction report.

### Non-Functional Requirements
1. **Reliability:** The system should be available 99% of the time.  
2. **Performance:** Drink preparation should not exceed 2 minutes.  
3. **Usability:** Simple and intuitive user interface.  
4. **Security:** Payment data should be handled safely.  
5. **Scalability:** New drink types can be easily added.

---

## Use Cases

| Use Case | Description | Actors | Preconditions | Postconditions |
|-----------|--------------|---------|----------------|----------------|
| Select Drink | The user selects a coffee type from the menu | User | Machine is operational | Selected drink is stored |
| Make Payment | The user pays for the selected drink | User, Payment System | Drink selected | Payment confirmed |
| Dispense Drink | The machine prepares and serves the drink | Coffee Machine | Payment confirmed | Drink dispensed |
| Refill Ingredients | Maintenance staff refills the machine | Maintenance Staff | Ingredient level low | Ingredients refilled |
| Generate Report | System creates a service report | Administrator | System running | Report generated |

---

## Objects, Classes, and Relationships

### Main Classes:
- `CoffeeMachine` — main system controller  
- `UserInterface` — handles user interaction  
- `PaymentSystem` — processes payments  
- `Drink` — represents a coffee drink  
- `Ingredient` — defines an ingredient  
- `IngredientContainer` — stores ingredient quantities  
- `Dispenser` — manages drink preparation  
- `MaintenanceSystem` — monitors stock and logs reports  

**Relationships:**
- CoffeeMachine *has a* UserInterface  
- CoffeeMachine *has a* PaymentSystem  
- CoffeeMachine *uses* Dispenser  
- Dispenser *contains many* IngredientContainers  
- MaintenanceSystem *monitors* CoffeeMachine  

