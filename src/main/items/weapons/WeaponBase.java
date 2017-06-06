package main.items.weapons;

import main.entity.Entity;
import main.items.ItemBase;

/**
 * Created by Kaleb on 6/6/2017.
 */
public class WeaponBase extends ItemBase {
    private double damage;
    private double range;

    public WeaponBase(double dmg, double rnge, Entity owner) {
        super(owner);
        damage = dmg;
        range = rnge;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}
