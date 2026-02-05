package com.rpg.lab01;

public class Weapon {
    private String name;
    private String type;
    private int damage;
    private String ability;

    public Weapon(String name, String type, int damage, String ability) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.ability = ability;
    }

    // Getters
    public String getName() { return name; }
    public int getDamage() { return damage; }
    public String getType() { return type; }
    public String getAbility() { return ability; }
}