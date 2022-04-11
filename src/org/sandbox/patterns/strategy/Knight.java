package org.sandbox.patterns.strategy;

public final class Knight extends Character {

    public Knight(final WeaponBehaviour weapon) {
        super(weapon);
    }

    @Override
    public String identify() {
        return "knight";
    }

}
