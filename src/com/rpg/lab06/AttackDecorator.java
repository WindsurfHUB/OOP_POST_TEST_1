package com.rpg.lab06;

/**
 * Abstract decorator that wraps another Attack component.
 */
public abstract class AttackDecorator implements Attack {
    protected final Attack wrappedAttack;

    protected AttackDecorator(Attack wrappedAttack) {
        if (wrappedAttack == null) {
            throw new IllegalArgumentException("Wrapped attack cannot be null.");
        }
        this.wrappedAttack = wrappedAttack;
    }
}
