package com.rpg.lab06;

/**
 * Concrete base component that performs a regular attack.
 */
public class BaseAttack implements Attack {
    @Override
    public void attack(Character attacker, Destructible target) {
        if (!attacker.isAlive()) {
            System.out.println(attacker.getName() + " cannot attack because they have fainted.");
            return;
        }

        int totalDamage = attacker.getDamage() + attacker.getWeapon().getBaseDamage();
        System.out.println("⚔️ Raw Attack Damage: " + totalDamage);
        target.takeDamage(totalDamage);
    }
}
