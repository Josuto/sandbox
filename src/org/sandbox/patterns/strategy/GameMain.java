package org.sandbox.patterns.strategy;

/**
 * This class illustrates the Strategy design pattern. It represents a client
 * that plays a very basic role game based on some characters that attack with
 * some weapon and can dynamically change this weapon at will. Furthermore, the
 * code of the concrete weapons can be changed in further versions transparently
 * for this class.
 * 
 * @author josumartinez
 *
 */
public final class GameMain {

    public static void main(String[] args) {
        WeaponBehaviour sword = new SwordBehaviour();
        WeaponBehaviour axe = new AxeBehaviour();
        
        Character princess = new Princess(sword);
        Character knight = new Knight(sword);
        
        princess.attack();
        knight.attack();
        princess.setWeapon(axe); // the princess decides to change her weapon to a more damaging one
        princess.attack();
    }

}
