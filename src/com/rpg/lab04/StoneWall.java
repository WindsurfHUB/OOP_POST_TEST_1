package com.rpg.lab04;

public class StoneWall implements Destructible {
    private String location;
    private double hp;
    private double maxHp;

    public StoneWall(String location, double hp) {
        this.location = location;
        this.hp = hp;
        this.maxHp = hp;
    }

    @Override
    public void takeDamage(int amount) {
        this.hp = Math.max(0.0, this.hp - amount);
        System.out.println("🧱 " + location + " takes " + amount + " damage! (Durability: " + (int)hp + "/" + (int)maxHp + ")");
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
        System.out.println("Durability: " + (int)hp + "/" + (int)maxHp);
    }

    public String getLocation() {
        return location;
    }
}
