package com.rpg.lab06;

/**
 * Component interface for decorator-based attack processing.
 */
public interface Attack {
    void attack(Character attacker, Destructible target);
}
