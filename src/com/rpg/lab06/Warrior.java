package com.rpg.lab06;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int hp, int baseDamage, int defense, int armorValue, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
        setAttack(new WarriorStyleDecorator(getAttack()));
    }

    @Override
    public void takeDamage(int amount) {
        int damageAfterArmor = Math.max(0, amount - armorValue);
        System.out.println("🛡️ " + getName() + "'s Armor: " + armorValue + " (reduces damage from " + amount + " to " + damageAfterArmor + ")");
        super.takeDamage(damageAfterArmor);
    }

    @Override
    public void displayCharacterDetails() {
        String status = (getHealthPoints() > 0) ? "Active" : "Fainted";
        System.out.println("\n--- " + getName().toUpperCase() + " (WARRIOR) ---");
        System.out.println("Status: " + status);
        System.out.println("Level: 12"); 
        System.out.println("Health Points: " + getHealthPoints() + "/" + getMaxHealthPoints());
        System.out.println("Damage: " + getDamage());
        System.out.println("Defense: " + getDefense());
        System.out.println("Armor Value: " + armorValue);
        System.out.println("Weapon: " + getWeapon().getName() + " (Type: " + getWeapon().getType() + ", Damage: " + getWeapon().getDamage() + ", Ability: " + getWeapon().getAbility() + ")");
    }
}
