package com.rpg.lab03;

public class Archer extends Character {
    private double accuracy;

    public Archer(String name, int level, double hp, double baseDamage, double defense, double accuracy, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " (Archer) attacks " + target.getName() + " with a Precise Shot!");
        double rawDamage = (getBaseDamage() + getWeapon().getDamage()) * 1.3;
        System.out.println("Raw Attack Damage: " + (int)rawDamage);
        target.receiveDamage(rawDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Accuracy: " + (int)accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        System.out.println("Weapon: " + getWeapon().getName() + " (Type: " + getWeapon().getType() + ", Damage: " + getWeapon().getDamage() + ", Ability: " + getWeapon().getAbility() + ")");
    }
}