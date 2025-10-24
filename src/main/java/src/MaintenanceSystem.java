package src;

import java.util.*;

public class MaintenanceSystem {
    private List<String> logs = new ArrayList<>();

    public void notifyLowStock() {
        logs.add("Warning: Low stock detected.");
        System.out.println("[Maintenance] Low ingredient stock detected!");
    }

    public void generateReport() {
        System.out.println("\n=== Maintenance Report ===");
        for (String log : logs) {
            System.out.println(log);
        }
        System.out.println("==========================");
    }
}
