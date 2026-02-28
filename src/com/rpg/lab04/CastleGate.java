package com.rpg.lab04;

public class CastleGate implements Destructible {
    private String name;
    private double hp;
    private double maxHp;
    private boolean isLocked;
    private boolean isReinforced;

    public CastleGate(String name, double hp, boolean isLocked, boolean isReinforced) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.isLocked = isLocked;
        this.isReinforced = isReinforced;
    }

    @Override
    public void takeDamage(int amount) {
        int actualDamage = amount;
        if (isReinforced) {
            actualDamage = amount / 2;
            System.out.println("🛡️ " + name + " is REINFORCED! (reduces damage from " + amount + " to " + actualDamage + ")");
        }
        this.hp = Math.max(0.0, this.hp - actualDamage);
        System.out.println("🧱 " + name + " takes " + actualDamage + " damage! (Durability: " + (int)hp + "/" + (int)maxHp + ")");
        if (isDestroyed()) {
            System.out.println("💥 " + name + " has been BREACHED! The gate COLLAPSES!");
        }
    }

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    public void displayGateDetails() {
        String status = (hp > 0) ? (isReinforced ? "REINFORCED" : "INTACT") : "BREACHED";
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("Status: " + status);
        System.out.println("Durability: " + (int)hp + "/" + (int)maxHp);
        System.out.println("Locked: " + (isLocked ? "Yes" : "No"));
        System.out.println("Reinforced: " + (isReinforced ? "Yes" : "No"));
    }

    public String getName() {
        return name;
    }
}
