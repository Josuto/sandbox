package org.sandbox.patterns.strategy;

public final class Princess extends Character {

    public Princess(final WeaponBehaviour weapon) {
        super(weapon);
    }

    @Override
    public String identify() {
        return "princess";
    }

}
