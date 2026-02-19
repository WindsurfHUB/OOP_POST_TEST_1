package com.rpg.lab03;

public class Character {
    private String name;
    private int level;
    private double hp;
    private double maxHp;
    private double baseDamage;
    private double defense;
    private Weapon weapon;
    private String jobClass;

    // Constructor updated to accept doubles
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

    public void attack(Character target) {
        double rawDamage = baseDamage + weapon.getDamage();
        System.out.println(name + " (" + jobClass + ") attacks " + target.getName() + " with " + weapon.getName() + "!");
        System.out.println("Raw Attack Damage: " + (int)rawDamage);
        target.receiveDamage(rawDamage);
    }

    public void receiveDamage(double rawDamage) {
        double actualDamage = Math.max(0.0, rawDamage - defense);
        this.hp = Math.max(0.0, this.hp - actualDamage);
        
        System.out.println(name + "'s Defense: " + (int)defense + " (reduces damage from " + (int)rawDamage + " to " + (int)actualDamage + ")");
        System.out.println("Actual Damage Taken: " + (int)actualDamage);
        System.out.println(name + "'s HP: " + (int)hp + "/" + (int)maxHp);
    }

    public void displayCharacterDetails() {
        String status = (hp > 0) ? "Active" : "Fainted";
        System.out.println("\n" + name.toUpperCase() + " (" + jobClass.toUpperCase() + ")");
        System.out.println("Status: " + status);
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + (int)hp + "/" + (int)maxHp);
        System.out.println("Damage: " + (int)baseDamage);
        System.out.println("Defense: " + (int)defense);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getHp() {
        return hp;
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