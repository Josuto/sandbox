package org.sandbox.patterns.strategy;

public abstract class Character {

    private WeaponBehaviour weapon;
    
    
    public Character(final WeaponBehaviour weapon) {
        this.setWeapon(weapon);
    }
    
    public abstract String identify();

    public WeaponBehaviour getWeapon() {
        return weapon;
    }

    public void setWeapon(final WeaponBehaviour weapon) {
        this.weapon = weapon;
    }
    
    public void attack() {
        System.out.println("The " + this.identify() + " caused a damage of " + weapon.use() + " points!");
    }
    
}
