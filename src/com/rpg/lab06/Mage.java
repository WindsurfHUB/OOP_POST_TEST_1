package com.rpg.lab06;

public class Mage extends Character {
    private int mana;
    private int maxMana;

    public Mage(String name, int level, int hp, int baseDamage, int defense, int mana, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;
        setAttack(new MageStyleDecorator(getAttack()));
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.min(mana, maxMana);
    }

    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public void displayCharacterDetails() {
        String status = (getHealthPoints() > 0) ? "Active" : "Fainted";
        System.out.println("\n--- " + getName().toUpperCase() + " (MAGE) ---");
        System.out.println("Status: " + status);
        System.out.println("Level: 14");
        System.out.println("Health Points: " + getHealthPoints() + "/" + getMaxHealthPoints());
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Damage: " + getDamage());
        System.out.println("Defense: " + getDefense());
        System.out.println("Weapon: " + getWeapon().getName() + " (Type: " + getWeapon().getType() + ", Damage: " + getWeapon().getDamage() + ", Ability: " + getWeapon().getAbility() + ")");
    }
}
