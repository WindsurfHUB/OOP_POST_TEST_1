package com.rpg.lab04;

public class HealthPotion implements Consumable {
    private String name;
    private double hpRestore;
    private int quantity;

    public HealthPotion(String name, double hpRestore, int quantity) {
        this.name = name;
        this.hpRestore = hpRestore;
        this.quantity = quantity;
    }

    @Override
    public void use(Character user) {
        if (quantity > 0) {
            double oldHp = user.getHp();
            user.setHp(user.getHp() + hpRestore);
            double actualRestored = user.getHp() - oldHp;
            quantity--;
            System.out.println("\n🧪 " + user.getName() + " drinks " + name + "!");
            System.out.println("❤️ Health restored: " + (int)oldHp + " → " + (int)user.getHp() + " (+" + (int)actualRestored + ")");
            System.out.println("📊 " + name + " remaining: " + quantity);
        } else {
            System.out.println("⚠️ No " + name + " left!");
        }
    }

    public void displayPotionDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("Healing Power: " + (int)hpRestore + " HP");
        System.out.println("Quantity: " + quantity);
        System.out.println("Type: Consumable");
    }
}
