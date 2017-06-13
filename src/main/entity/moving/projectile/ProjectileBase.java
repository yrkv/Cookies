package main.entity.moving.projectile;

import main.entity.Entity;
import main.entity.moving.MovingEntity;
import main.entity.moving.character.Actor;
import main.entity.moving.character.Player;
import main.level.Level;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class ProjectileBase extends MovingEntity {
    private Entity parent;

    double damage;
    public ProjectileBase(double x, double y, double dir, double spd, double dmg, Level level) {
        super(x,y,dir,spd,level);
        damage = dmg;
    }

    public double applyDamage(Actor target) {
        return -1 * target.takeDamage(damage);
    }


    public void move(double dir) {
        setX(getX() + getSpeed() * Math.cos(dir));
        setY(getY() - getSpeed() * Math.sin(dir));
    }
}
