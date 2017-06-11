package main.items.weapons;

import main.entity.Entity;
import main.entity.moving.character.Actor;
import main.items.ItemBase;
import main.level.Level;

/**
 * Created by Kaleb on 6/6/2017.
 */
public class WeaponBase extends ItemBase {
    private double damage;
    private double range;

    public WeaponBase(double dmg, double rnge, double reloadTime, Level level) {
        super(reloadTime,level);
        setWeaponStatus(true);
        damage = dmg;
        range = rnge;
    }

    public boolean toggleEquipStatus() {
        return setEquipStatus(!isEquipped());
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
