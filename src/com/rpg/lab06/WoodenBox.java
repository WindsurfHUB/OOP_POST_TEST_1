package com.rpg.lab06;

public class WoodenBox implements Destructible {
    private String name;
    private int hp;
    private int maxHp;
    private boolean isLocked;
    private String contents;

    public WoodenBox(String name, int hp, boolean isLocked, String contents) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.isLocked = isLocked;
        this.contents = contents;
    }

    @Override
    public void takeDamage(int amount) {
        this.hp = Math.max(0, this.hp - amount);
        System.out.println("📦 " + name + " takes " + amount + " damage! (Durability: " + hp + "/" + maxHp + ")");
        if (isDestroyed()) {
            System.out.println("💥 " + name + " has been DESTROYED!");
        }
    }

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    public void displayBoxDetails() {
        String status = (hp > 0) ? "Intact" : "Destroyed";
        System.out.println("\n--- " + name.toUpperCase() + " (WOODEN BOX) ---");
        System.out.println("Status: " + status);
        System.out.println("Health: " + hp + "/" + maxHp);
        System.out.println("Locked: " + (isLocked ? "Yes 🔒" : "No 🔓"));
        System.out.println("Contains: " + contents);
    }

    public void breakOpen() {
        if (isDestroyed()) {
            if (isLocked) {
                System.out.println("🔓 The lock broke! " + name + " breaks open!");
            }
            System.out.println("🎁 Contents revealed: " + contents);
        } else {
            System.out.println("⚠️ Cannot break open " + name + " - it's still intact!");
        }
    }

    public String getName() {
        return name;
    }
}
