package com.rpg.lab03;

public class Warrior extends Character {
    private double armorValue;

    public Warrior(String name, int level, double hp, double baseDamage, double defense, double armorValue, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    @Override
    public void attack(Character target) {
        double rawDamage = (getBaseDamage() + getWeapon().getDamage()) * 1.5;
        System.out.println(getName() + " (Warrior) attacks " + target.getName() + " with a heavy strike!");
        System.out.println("Raw Attack Damage: " + (int)rawDamage);
        target.receiveDamage(rawDamage);
    }

    @Override
    public void receiveDamage(double rawDamage) {
        double damageAfterArmor = Math.max(0.0, rawDamage - armorValue);
        System.out.println(getName() + "'s Armor absorbs " + (int)armorValue + " damage!");
        super.receiveDamage(damageAfterArmor);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Armor Value: " + (int)armorValue);
        System.out.println("Weapon: " + getWeapon().getName() + " (Type: " + getWeapon().getType() + ", Damage: " + getWeapon().getDamage() + ", Ability: " + getWeapon().getAbility() + ")");
    }
}