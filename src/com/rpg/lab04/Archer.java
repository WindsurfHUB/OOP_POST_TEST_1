package com.rpg.lab04;

public class Archer extends Character {
    private double accuracy;

    public Archer(String name, int level, double hp, double baseDamage, double defense, double accuracy, Weapon weapon) {
        super(name, level, hp, baseDamage, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }

    @Override
    public void attack(Destructible target) {
        String targetName = (target instanceof Character ? ((Character)target).getName() : "Target");
        System.out.print("\n🏹 " + getName() + " (Archer) shoots a precise arrow at " + targetName + "!\n");
        
        double baseTotal = getBaseDamage() + getWeapon().getDamage();
        double rangeBonus = baseTotal * 0.3; // 30% bonus
        double finalDamage = baseTotal + rangeBonus;
        
        System.out.println("Base Damage: " + (int)baseTotal + " + Range Bonus: " + (int)rangeBonus + " = " + (int)finalDamage);
        System.out.println("Accuracy: " + (int)accuracy + "% (HIT!)");
        System.out.println("🎯 " + targetName + " takes " + (int)finalDamage + " damage!");
        
        target.takeDamage((int)finalDamage);
    }

    @Override
    public void displayCharacterDetails() {
        String status = (getHp() > 0) ? "Active" : "Fainted";
        System.out.println("\n--- " + getName().toUpperCase() + " (ARCHER) ---");
        System.out.println("Status: " + status);
        System.out.println("Level: 13"); // Matches PDF
        System.out.println("Health Points: " + (int)getHp() + "/" + (int)getMaxHp());
        System.out.println("Damage: " + (int)getBaseDamage());
        System.out.println("Defense: " + (int)getDefense());
        System.out.println("Accuracy: " + (int)accuracy + "%");
        System.out.println("Range Advantage: Yes (30% bonus)");
        System.out.println("Weapon: " + getWeapon().getName() + " (Type: " + getWeapon().getType() + ", Damage: " + (int)getWeapon().getDamage() + ", Ability: " + getWeapon().getAbility() + ")");
    }
}
