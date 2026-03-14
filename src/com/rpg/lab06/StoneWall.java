package com.rpg.lab06;

public class StoneWall implements Destructible {
    private String location;
    private int hp;
    private int maxHp;

    public StoneWall(String location, int hp) {
        this.location = location;
        this.hp = hp;
        this.maxHp = hp;
    }

    @Override
    public void takeDamage(int amount) {
        this.hp = Math.max(0, this.hp - amount);
        System.out.println("🧱 " + location + " takes " + amount + " damage! (Durability: " + hp + "/" + maxHp + ")");
        if (isDestroyed()) {
            System.out.println("💥 " + location + " has CRUMBLED to pieces!");
        }
    }

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    public void displayWallDetails() {
        String status = (hp > 0) ? "STANDING" : "DESTROYED";
        System.out.println("\n--- " + location.toUpperCase() + " ---");
        System.out.println("Type: Outer Wall");
        System.out.println("Status: " + status);
        System.out.println("Durability: " + hp + "/" + maxHp);
    }

    public String getLocation() {
        return location;
    }

    // Add getName to match Character if needed by decorators
    public String getName() {
        return location;
    }
}
