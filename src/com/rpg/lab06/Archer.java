package com.rpg.lab06;

public class Archer extends Character {
    private int accuracy;

    public Archer(String name, int level, int hp, int baseDamage, int defense, int accuracy, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Archer");
        this.accuracy = accuracy;
        setAttack(new ArcherStyleDecorator(getAttack()));
    }

    public int getAccuracy() {
        return accuracy;
    }

    public boolean hasRangeAdvantage() {
        return true; // As per the original Archer logic and displayDetails
    }

    @Override
    public void displayCharacterDetails() {
        String status = (getHealthPoints() > 0) ? "Active" : "Fainted";
        System.out.println("\n--- " + getName().toUpperCase() + " (ARCHER) ---");
        System.out.println("Status: " + status);
        System.out.println("Level: 13");
        System.out.println("Health Points: " + getHealthPoints() + "/" + getMaxHealthPoints());
        System.out.println("Damage: " + getDamage());
        System.out.println("Defense: " + getDefense());
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        System.out.println("Weapon: " + getWeapon().getName() + " (Type: " + getWeapon().getType() + ", Damage: " + getWeapon().getDamage() + ", Ability: " + getWeapon().getAbility() + ")");
    }
}
