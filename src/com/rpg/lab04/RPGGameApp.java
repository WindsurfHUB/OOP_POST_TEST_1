package com.rpg.lab04;

import java.util.ArrayList;
import java.util.List;

public class RPGGameApp {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" SCENARIO 4: INTERFACES - DESTRUCTIBLE & CONSUMABLE");
        System.out.println("=".repeat(70));

        // [STEP 1] Creating Weapons
        System.out.println("\n[STEP 1] Creating Weapons...");
        Weapon swordWeapon = new Weapon("Excalibur", "Melee", 30, "Slash Attack");
        Weapon staffWeapon = new Weapon("Staff of Mysticism", "Magic", 20, "Spell Cast");
        Weapon bowWeapon = new Weapon("Bow of Elven Make", "Ranged", 18, "Precise Shot");

        // [STEP 2] Creating Characters
        System.out.println("\n[STEP 2] Creating Characters...");
        Warrior warrior = new Warrior("Aragorn", 12, 2000, 25, 8, 15, swordWeapon);
        Mage mage = new Mage("Gandalf", 14, 1200, 20, 5, 150, staffWeapon);
        Archer archer = new Archer("Legolas", 13, 1400, 22, 6, 85, bowWeapon);

        // [STEP 3] Creating Destructible Objects (Non-Character)
        System.out.println("\n[STEP 3] Creating Destructible Objects (Non-Character)...");
        WoodenBox treasureBox = new WoodenBox("Treasure Chest", 300, true, "1000 Gold Coins");
        WoodenBox crate = new WoodenBox("Supply Crate", 150, false, "Medicine & Supplies");

        // [STEP 4] Creating Consumable Items
        System.out.println("\n[STEP 4] Creating Consumable Items...");
        HealthPotion potionGreater = new HealthPotion("Greater Health Potion", 100, 3);
        HealthPotion potionMinor = new HealthPotion("Minor Health Potion", 10, 10);

        // [STEP 5] Initial Status
        System.out.println("\n[STEP 5] Initial Status:");
        System.out.println("\n--- CHARACTERS (Destructible) ---");
        warrior.displayCharacterDetails();
        mage.displayCharacterDetails();
        archer.displayCharacterDetails();

        System.out.println("\n--- DESTRUCTIBLE OBJECTS (Non-Character) ---");
        treasureBox.displayBoxDetails();
        crate.displayBoxDetails();

        System.out.println("\n--- CONSUMABLE ITEMS ---");
        potionGreater.displayPotionDetails();
        potionMinor.displayPotionDetails();

        // [STEP 6] INTERFACE POLYMORPHISM: DESTRUCTIBLE
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 6] INTERFACE POLYMORPHISM: Destructible Objects");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ KEY CONCEPT: Warriors can attack BOTH Characters and Objects!");
        System.out.println(" Both implement Destructible, but DON'T share inheritance.\n");

        List<Destructible> battleTargets = new ArrayList<>();
        battleTargets.add(mage);       // Character is Destructible
        battleTargets.add(warrior);    // Another Character is Destructible
        battleTargets.add(treasureBox); // WoodenBox is Destructible (NOT a Character!)
        battleTargets.add(crate);       // Another WoodenBox

        System.out.println("--- Aragorn and Mage attacks each other (Character - Destructible) ---");
        for (int i = 0; i < 5; i++) {
            warrior.attack(battleTargets.get(0)); // warrior attacks mage
            mage.attack(battleTargets.get(1));    // mage attacks warrior
        }

        System.out.println("\n--- Aragorn continues attacking the Treasure Chest ---");
        while (!battleTargets.get(2).isDestroyed()) {
            warrior.attack(battleTargets.get(2));
        }

        System.out.println("\n--- Legolas attacks a Supply Crate (Object - Destructible) ---");
        archer.attack(battleTargets.get(3));

        // [STEP 7] Status After Combat
        System.out.println("\n[STEP 7] Status After Combat:");
        mage.displayCharacterDetails();
        System.out.println("\n--- Destructible Objects Status ---");
        treasureBox.displayBoxDetails();
        crate.displayBoxDetails();

        // [STEP 8] INTERFACE POLYMORPHISM: CONSUMABLE
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 8] INTERFACE POLYMORPHISM: Consumable Items");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ KEY CONCEPT: Different consumable items, same 'use' method!");

        List<Consumable> inventory = new ArrayList<>();
        inventory.add(potionGreater);
        inventory.add(potionMinor);

        System.out.println("\n--- Gandalf uses a Greater Health Potion ---");
        inventory.get(0).use(mage);

        System.out.println("\n--- Gandalf uses a Minor Health Potion ---");
        inventory.get(1).use(mage);

        // [STEP 9] Breaking Open Boxes
        System.out.println("\n[STEP 9] Breaking Open Boxes:");
        System.out.println("\n--- Breaking open the Treasure Chest ---");
        treasureBox.breakOpen();

        System.out.println("\n--- Attempting to break the Supply Crate (still intact) ---");
        crate.breakOpen();

        // [STEP 10] CHALLENGE: CROSS-HIERARCHY INTERACTION
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 10] CROSS-HIERARCHY INTERACTION: Stone Walls & Castle Gates");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ KEY CONCEPT: Warrior can attack NEW object types WITHOUT recomputation!");
        System.out.println(" StoneWall and CastleGate implement Destructible - NO changes to Warrior!\n");

        System.out.println("[Creating New Structures]");
        StoneWall northWall = new StoneWall("North Wall", 500);
        StoneWall eastWall = new StoneWall("East Wall", 400);
        CastleGate mainGate = new CastleGate("Main Gate", 600, true, true);
        CastleGate sideGate = new CastleGate("Side Gate", 300, false, false);

        System.out.println("\n--- Initial Structure Status ---");
        northWall.displayWallDetails();
        eastWall.displayWallDetails();
        mainGate.displayGateDetails();
        sideGate.displayGateDetails();

        System.out.println("\n--- Aragorn (Warrior) attacks the North Wall ---");
        for (int i = 0; i < 8; i++) {
            warrior.attack(northWall);
            if (northWall.isDestroyed()) break;
        }

        System.out.println("\n--- Legolas (Archer) attacks the Main Gate (Reinforced!) ---");
        for (int i = 0; i < 10; i++) {
            archer.attack(mainGate);
            if (mainGate.isDestroyed()) break;
        }

        System.out.println("\n--- Aragorn (Warrior) attacks the Side Gate ---");
        while (!sideGate.isDestroyed()) {
            warrior.attack(sideGate);
        }

        System.out.println("\n--- Final Structure Status ---");
        northWall.displayWallDetails();
        mainGate.displayGateDetails();
        sideGate.displayGateDetails();

        // [STEP 11] POLYMORPHIC LIST: Mixed Destructible Objects
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 11] POLYMORPHIC LIST: Mixed Destructible Objects");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ All objects in one list - Characters, Boxes, Walls, Gates!\n");

        List<Destructible> allDestructibles = new ArrayList<>();
        allDestructibles.add(eastWall);
        allDestructibles.add(crate);
        allDestructibles.add(archer);

        System.out.println("--- Mage attacking various targets from polymorphic list ---");
        for (Destructible target : allDestructibles) {
            if (target instanceof StoneWall) {
                System.out.println("\n>> Target: " + ((StoneWall) target).getLocation());
            } else if (target instanceof WoodenBox) {
                // WoodenBox doesn't have getName but we know what it is
                System.out.println("\n>> Target: Supply Crate");
            } else if (target instanceof Character) {
                System.out.println("\n>> Target: " + ((Character) target).getName());
            }
            mage.attack(target);
        }
    }
}
