package com.rpg.lab04;

public class Warrior extends Character {
    private double armorValue;

    public Warrior(String name, int level, double hp, double baseDamage, double defense, double armorValue, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    @Override
    public void attack(Destructible target) {
        double rawDamage = (getBaseDamage() + getWeapon().getDamage()) * 1.5;
        System.out.print("\n⚔️ " + getName() + " (Warrior) performs a POWERFUL STRIKE on " + (target instanceof Character ? ((Character)target).getName() : "Target") + "!\n");
        System.out.println("Base Damage: " + (int)(getBaseDamage() + getWeapon().getDamage()) + " -> Enhanced: " + (int)rawDamage + " (1.5x multiplier)");
        target.takeDamage((int)rawDamage);
    }

    @Override
    public void takeDamage(int amount) {
        double damageAfterArmor = Math.max(0.0, amount - armorValue);
        System.out.println("🛡️ " + getName() + "'s Armor: " + (int)armorValue + " (reduces damage from " + amount + " to " + (int)damageAfterArmor + ")");
        super.takeDamage((int)damageAfterArmor);
    }

    @Override
    public void displayCharacterDetails() {
        String status = (getHp() > 0) ? "Active" : "Fainted";
        System.out.println("\n--- " + getName().toUpperCase() + " (WARRIOR) ---");
        System.out.println("Status: " + status);
        System.out.println("Level: 12"); 
        System.out.println("Health Points: " + (int)getHp() + "/" + (int)getMaxHp());
        System.out.println("Damage: " + (int)getBaseDamage());
        System.out.println("Defense: " + (int)getDefense());
        System.out.println("Armor Value: " + (int)armorValue);
        System.out.println("Weapon: " + getWeapon().getName() + " (Type: " + getWeapon().getType() + ", Damage: " + (int)getWeapon().getDamage() + ", Ability: " + getWeapon().getAbility() + ")");
    }
}
