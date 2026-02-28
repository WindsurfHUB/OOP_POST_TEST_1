package com.rpg.lab04;

public class Character implements Destructible {
    private String name;
    private int level;
    private double hp;
    private double maxHp;
    private double baseDamage;
    private double defense;
    private Weapon weapon;
    private String jobClass;

    public Character(String name, int level, double hp, double baseDamage, double defense, Weapon weapon, String jobClass) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.weapon = weapon;
        this.jobClass = jobClass;
    }

    public void attack(Destructible target) {
        double rawDamage = baseDamage + weapon.getDamage();
        System.out.println(name + " (" + jobClass + ") attacks " + (target instanceof Character ? ((Character)target).getName() : "Target") + " with " + weapon.getName() + "!");
        System.out.println("Raw Attack Damage: " + (int)rawDamage);
        target.takeDamage((int)rawDamage);
    }

    @Override
    public void takeDamage(int amount) {
        double actualDamage = Math.max(0.0, amount - defense);
        this.hp = Math.max(0.0, this.hp - actualDamage);
        
        System.out.println(name + "'s Defense: " + (int)defense + " (reduces damage from " + amount + " to " + (int)actualDamage + ")");
        System.out.println("Actual Damage Taken: " + (int)actualDamage);
        System.out.println(name + "'s HP: " + (int)hp + "/" + (int)maxHp);
    }

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    public void displayCharacterDetails() {
        String status = (hp > 0) ? "Active" : "Fainted";
        System.out.println("\n--- " + name.toUpperCase() + " (" + jobClass.toUpperCase() + ") ---");
        System.out.println("Status: " + status);
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + (int)hp + "/" + (int)maxHp);
        System.out.println("Damage: " + (int)baseDamage);
        System.out.println("Defense: " + (int)defense);
        System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() + ", Damage: " + (int)weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = Math.min(hp, maxHp);
    }

    public double getMaxHp() {
        return maxHp;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public double getDefense() {
        return defense;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String getJobClass() {
        return jobClass;
    }
}
