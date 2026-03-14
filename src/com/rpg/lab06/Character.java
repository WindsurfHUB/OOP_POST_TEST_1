package com.rpg.lab06;

public class Character implements Destructible {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private int baseDamage;
    private int defense;
    private Weapon weapon;
    private String jobClass;
    private Attack attackBehavior;

    public Character(String name, int level, int hp, int baseDamage, int defense, Weapon weapon, String jobClass) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.weapon = weapon;
        this.jobClass = jobClass;
        this.attackBehavior = new BaseAttack();
    }

    public void attack(Destructible target) {
        attackBehavior.attack(this, target);
    }

    public Attack getAttack() {
        return attackBehavior;
    }

    public void setAttack(Attack attack) {
        this.attackBehavior = attack;
    }

    @Override
    public void takeDamage(int amount) {
        int actualDamage = Math.max(0, amount - defense);
        this.hp = Math.max(0, this.hp - actualDamage);
        
        System.out.println(name + "'s Defense: " + defense + " (reduces damage from " + amount + " to " + actualDamage + ")");
        System.out.println("Actual Damage Taken: " + actualDamage);
        System.out.println(name + "'s HP: " + hp + "/" + maxHp);
    }

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void displayCharacterDetails() {
        String status = (hp > 0) ? "Active" : "Fainted";
        System.out.println("\n--- " + name.toUpperCase() + " (" + jobClass.toUpperCase() + ") ---");
        System.out.println("Status: " + status);
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + hp + "/" + maxHp);
        System.out.println("Damage: " + baseDamage);
        System.out.println("Defense: " + defense);
        System.out.println("Weapon: " + weapon.getName() + " (Type: " + weapon.getType() + ", Damage: " + weapon.getDamage() + ", Ability: " + weapon.getAbility() + ")");
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return hp;
    }

    public void setHealthPoints(int hp) {
        this.hp = Math.min(hp, maxHp);
    }

    public int getMaxHealthPoints() {
        return maxHp;
    }

    public int getDamage() {
        return baseDamage;
    }

    public void setDamage(int damage) {
        this.baseDamage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String getJobClass() {
        return jobClass;
    }

    // Existing getters for backward compatibility or if needed by decorators
    public int getHp() {
        return hp;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public int getMaxHp() {
        return maxHp;
    }
}
