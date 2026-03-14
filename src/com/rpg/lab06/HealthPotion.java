package com.rpg.lab06;

public class HealthPotion implements Consumable {
    private String name;
    private int hpRestore;
    private int quantity;

    public HealthPotion(String name, int hpRestore, int quantity) {
        this.name = name;
        this.hpRestore = hpRestore;
        this.quantity = quantity;
    }

    @Override
    public void use(Character user) {
        if (quantity > 0) {
            int oldHp = user.getHealthPoints();
            user.setHealthPoints(user.getHealthPoints() + hpRestore);
            int actualRestored = user.getHealthPoints() - oldHp;
            quantity--;
            System.out.println("\n🧪 " + user.getName() + " drinks " + name + "!");
            System.out.println("❤️ Health restored: " + oldHp + " → " + user.getHealthPoints() + " (+" + actualRestored + ")");
            System.out.println("📊 " + name + " remaining: " + quantity);
        } else {
            System.out.println("⚠️ No " + name + " left!");
        }
    }

    public void displayPotionDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("Healing Power: " + hpRestore + " HP");
        System.out.println("Quantity: " + quantity);
        System.out.println("Type: Consumable");
    }
}
