package com.rpg.lab01;

public class Character {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private Weapon weapon;
    private String jobClass;

    public Character(String name, int level, int hp, Weapon weapon, String jobClass) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.weapon = weapon;
        this.jobClass = jobClass;
    }

    public int attack() {
        int bonus = level * 2;
        int totalDamage = weapon.getDamage() + bonus;
        System.out.println(name + " (" + jobClass + ") attacks with " + weapon.getName() + "!");
        System.out.println("Attack Damage: " + totalDamage + " (Weapon Base: " + weapon.getDamage() + " + Level Bonus: " + bonus + ")");
        return totalDamage;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        System.out.println(name + " takes " + damage + " damage! Current HP: " + hp + "/" + maxHp);
    }

    public void levelUp() {
        this.level++;
        this.maxHp += 10;
        this.hp = maxHp;
        System.out.println(name + " leveled up to Level " + level + "!");
        System.out.println("Max Health increased to " + maxHp + " (full heal applied)");
    }

    public void displayCharacterDetails() {
        System.out.println("\n" + name.toUpperCase());
        System.out.println("Class: " + jobClass);
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + hp + "/" + maxHp);
        System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() +
                ", Damage: " + weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");
    }

    // Getters and Setters needed because fields are private
    public String getName() { return name; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getMaxHp() { return maxHp; }
    public int getLevel() { return level; }
}