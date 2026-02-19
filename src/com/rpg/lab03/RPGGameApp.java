package com.rpg.lab03;

import java.util.*;

public class RPGGameApp {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" SCENARIO 3: RPG BATTLEFIELD - POLYMORPHISM & METHOD OVERRIDING");
        System.out.println("=".repeat(70));

        System.out.println("\n [STEP 1] Creating Weapons...");
        Weapon swordWeapon = new Weapon("Excalibur", "Melee", 30, "Slash Attack");
        Weapon staffWeapon = new Weapon("Staff of Mysticism", "Magic", 20, "Spell Cast");
        Weapon bowWeapon = new Weapon("Bow of Elven Make", "Ranged", 18, "Precise Shot");

        System.out.println("\n[STEP 2] Creating Battlefield Team...");
        List<Character> team = new ArrayList<>();
        Warrior warrior = new Warrior("Aragorn", 12, 2000, 25, 8, 15, swordWeapon);
        team.add(warrior);
        Mage mage = new Mage("Gandalf", 14, 1200, 20, 5, 150, staffWeapon);
        team.add(mage);
        Archer archer = new Archer("Legolas", 13, 1400, 22, 6, 85, bowWeapon);
        team.add(archer);

        Character enemy = new Character("Dragon", 15, 2500, 30, 10, new Weapon("Claws", "Melee", 25, "Bite"), "Boss");

        System.out.println("\n[STEP 3] Initial Team Status:");
        for (Character member : team) {
            member.displayCharacterDetails();
        }
        System.out.println("\n--- ENEMY ---");
        enemy.displayCharacterDetails();

        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 4] POLYMORPHIC COMBAT: Team Attacks Enemy");
        System.out.println(" Same method call (attack), DIFFERENT behavior for each type!");
        System.out.println("=".repeat(70));

        for (Character member : team) {
            System.out.println("\n--- " + member.getName() + "'s Turn ---");
            if (member instanceof Warrior) {
                System.out.println(" (Using Warrior.attack() - 1.5x damage bonus)");
            } else if (member instanceof Mage) {
                System.out.println(" (Using Mage.attack() - Magic Missile spell)");
            } else if (member instanceof Archer) {
                System.out.println(" (Using Archer.attack() - Ranged arrow attack with accuracy)");
            }
            member.attack(enemy);
        }

        System.out.println("\n\n [STEP 5] Enemy Status After Team Attacks:");
        enemy.displayCharacterDetails();

        System.out.println("\n [STEP 6] Enemy Counterattacks!");
        System.out.println("\n--- Dragon attacks Warrior ---");
        enemy.attack(warrior);
        System.out.println("\n--- Dragon attacks Mage ---");
        enemy.attack(mage);
        System.out.println("\n--- Dragon attacks Archer ---");
        enemy.attack(archer);

        System.out.println("\n [STEP 7] Final Team Status:");
        for (Character member : team) {
            member.displayCharacterDetails();
        }
    }
}