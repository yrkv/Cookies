package main.entity.moving.projectile;

import main.entity.Entity;
import main.entity.moving.MovingEntity;
import main.entity.moving.character.Actor;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class ProjectileBase extends MovingEntity {
    double damage;
    public ProjectileBase(double x, double y, double dir, double spd, double dmg) {
        super(x,y,dir,spd);
        damage = dmg;
    }

    //returns damage applied
    public double applyDamage(Actor target) {
        return -1 * target.takeDamage(damage);
    }
}
