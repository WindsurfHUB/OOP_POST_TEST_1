package com.rpg.lab06;

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

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getBaseDamage() {
        return damage;
    }

    public String getAbility() {
        return ability;
    }
}
