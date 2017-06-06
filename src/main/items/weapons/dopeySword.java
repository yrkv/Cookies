package main.items.weapons;

import main.entity.Entity;
import main.entity.moving.character.Actor;

/**
 * Created by Kaleb on 6/6/2017.
 */
public class dopeySword extends WeaponBase {

    public dopeySword(double dmg, double rnge, Entity owner) {
        super(dmg,rnge,owner);
    }

    private double onHit(Actor target) {
        return target.takeDamage(getDamage());
    }
}
