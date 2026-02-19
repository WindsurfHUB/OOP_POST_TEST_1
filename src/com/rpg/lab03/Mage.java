package com.rpg.lab03;

public class Mage extends Character {
    private double mana;
    private double maxMana;

    public Mage(String name, int level, double hp, double baseDamage, double defense, double mana, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " (Mage) casts Magic Missile at " + target.getName() + "!");
        if (mana >= 30.0) { mana -= 30.0; }

        double rawDamage = getBaseDamage() + getWeapon().getDamage() + 15.0;
        System.out.println("Raw Attack Damage: " + (int)rawDamage);
        target.receiveDamage(rawDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println("Mana: " + (int)mana + "/" + (int)maxMana);
        System.out.println("Weapon: " + getWeapon().getName() + " (Type: " + getWeapon().getType() + ", Damage: " + getWeapon().getDamage() + ", Ability: " + getWeapon().getAbility() + ")");
    }
}