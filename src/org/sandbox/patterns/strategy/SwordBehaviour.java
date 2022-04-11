package org.sandbox.patterns.strategy;

public final class SwordBehaviour implements WeaponBehaviour {

    @Override
    public int use() {
        return 20;
    }

}
