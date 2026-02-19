package com.rpg.lab01;

public class Healer extends Character {
    private int baseHealingPower;

    public Healer(String name, int level, int hp, int baseDamage, int defense, Weapon weapon, int healPower) {
        super(name, level, hp, baseDamage, defense, weapon, "Healer");
        this.baseHealingPower = healPower;
    }

    public void heal() {
        int healAmount = baseHealingPower + (getLevel() * 3);
        int newHp = Math.min(getMaxHp(), getHp() + healAmount);
        setHp(newHp);
        System.out.println(getName() + " (Healer) casts a healing spell!");
        System.out.println("Healing Amount: " + healAmount + " (Base: " + baseHealingPower + " + Level Bonus: " + (getLevel() * 3) + ")");
        System.out.println("Restored " + healAmount + " HP! Current HP: " + getHp() + "/" + getMaxHp());
    }

    public void healAlly(Character ally) {
        int healAmount = baseHealingPower + (getLevel() * 3);
        int newHp = Math.min(ally.getMaxHp(), ally.getHp() + healAmount);
        ally.setHp(newHp);
        System.out.println(getName() + " (Healer) casts healing spell on " + ally.getName() + "!");
        System.out.println("Restored " + healAmount + " HP to " + ally.getName() + "! Their HP: " + ally.getHp());
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        int currentHealingPower = baseHealingPower + (getLevel() * 3);
        System.out.println(" Healing Power: " + currentHealingPower);
    }
}