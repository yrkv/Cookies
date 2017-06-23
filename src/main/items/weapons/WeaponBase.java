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
    private double projectileSpeed;

    public WeaponBase(double dmg, double rnge, double projectileSpeed, double reloadTime, Level level) {
        super(reloadTime,level);
        setWeaponStatus(true);
        this.projectileSpeed = projectileSpeed;
        damage = dmg;
        range = rnge;
    }

    public boolean toggleEquipStatus() {
        return setEquipStatus(!isEquipped());
    }

    public double getDamage() {
        return damage;
    }

    public double setDamage(double damage) {
        this.damage = damage;
        return this.damage;
    }

    public double getRange() {
        return range;
    }

    public double setRange(double range) {
        this.range = range;
        return this.range;
    }

    public double getProjectileSpeed() {
        return projectileSpeed;
    }

    public double setProjectileSpeed(double projectileSpeed) {
        this.projectileSpeed = projectileSpeed;
        return this.projectileSpeed;
    }
}
