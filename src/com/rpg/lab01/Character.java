package com.rpg.lab01;

public class Character {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private int baseDamage;
    private int defense;
    private Weapon weapon;
    private String jobClass;

    public Character(String name, int level, int hp, int baseDamage, int defense, Weapon weapon, String jobClass) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.weapon = weapon;
        this.jobClass = jobClass;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void attack(Character target) {
        System.out.println(name + " (" + jobClass + ") attacks " + target.getName() + " with " + weapon.getName() + "!");

        int rawDamage = baseDamage + weapon.getDamage();
        System.out.println("Raw Attack Damage: " + rawDamage);

        target.takeDamage(rawDamage);
    }

    public void takeDamage(int rawDamage) {
        System.out.println(name + "'s Defense: " + defense + " (reduces damage by " + defense + ")");

        int actualDamage = Math.max(0, rawDamage - defense);
        this.hp = Math.max(0, this.hp - actualDamage);

        System.out.println("Actual Damage Taken: " + actualDamage);
        System.out.println(name + "'s HP: " + hp + "/" + maxHp);
    }

    public void levelUp() {
        this.level++;
        this.maxHp += 10;
        this.hp = maxHp;
        System.out.println(name + " leveled up to Level " + level + "!");
        System.out.println("Max Health increased to " + maxHp + " (full heal applied)");
    }

    public void displayCharacterDetails() {
        String status = isAlive() ? "Active" : "Fainted";
        System.out.println("\n" + name.toUpperCase());
        System.out.println("Class: " + jobClass);
        System.out.println("Status: " + status);
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + hp + "/" + maxHp);
        System.out.println("Damage: " + baseDamage);
        System.out.println("Defense: " + defense);
        System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() +
                ", Damage: " + weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getMaxHp() { return maxHp; }
    public int getLevel() { return level; }
}