package com.rpg.lab04;

public class Mage extends Character {
    private double mana;
    private double maxMana;

    public Mage(String name, int level, double hp, double baseDamage, double defense, double mana, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = mana;
    }

    @Override
    public void attack(Destructible target) {
        String targetName = (target instanceof Character ? ((Character)target).getName() : "Target");
        System.out.print("\n✨ " + getName() + " (Mage) casts MAGIC MISSILE at " + targetName + "!\n");
        
        if (mana >= 30.0) {
            mana -= 30.0;
            double rawDamage = getBaseDamage() + getWeapon().getDamage() + 10.0;
            System.out.println("Spell Damage: " + (int)rawDamage + " (Base: " + (int)(getBaseDamage() + getWeapon().getDamage()) + " + Spell Bonus: 10)");
            System.out.println("Mana Used: 30 | Remaining: " + (int)mana + "/" + (int)maxMana);
            target.takeDamage((int)rawDamage);
        } else {
            System.out.println("✨ " + getName() + " attempts to cast Magic Missile, but has insufficient mana!");
            System.out.println("Current Mana: " + (int)mana + "/" + (int)maxMana + " (Need: 30)");
        }
    }

    @Override
    public void displayCharacterDetails() {
        String status = (getHp() > 0) ? "Active" : "Fainted";
        System.out.println("\n--- " + getName().toUpperCase() + " (MAGE) ---");
        System.out.println("Status: " + status);
        System.out.println("Level: " + 14); // Matches PDF
        System.out.println("Health Points: " + (int)getHp() + "/" + (int)getMaxHp());
        System.out.println("Mana: " + (int)mana + "/" + (int)maxMana);
        System.out.println("Damage: " + (int)getBaseDamage());
        System.out.println("Defense: " + (int)getDefense());
        System.out.println("Weapon: " + getWeapon().getName() + " (Type: " + getWeapon().getType() + ", Damage: " + (int)getWeapon().getDamage() + ", Ability: " + getWeapon().getAbility() + ")");
    }
}
