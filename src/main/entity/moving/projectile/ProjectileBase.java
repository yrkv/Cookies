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
    private double startingX;
    private double startingY;
    private double range;

    double damage;
    public ProjectileBase(double x, double y, double startingX, double startingY, double dir, double spd, double rnge, double dmg, Level level) {
        super(x,y,dir,spd,level);
        this.startingX = startingX;
        this.startingY = startingY;
        range = rnge;
        damage = dmg;
    }

    public double applyDamage(Actor target) {
        return -1 * target.takeDamage(damage);
    }

    public void colisionCheckOnlyPlayer() {
        if(colidesWith(getPlayer())) {
            applyDamage(getPlayer());
        } else if (getLevel().collideTiles(getX(), getY()))
            kill();
        else if(outOfRange()) kill();
    }

    public void colisionCheckNotPlayer() {
        for (Entity entity : getLevel().getEntities()) {
            if (entity.isActor() && entity != getPlayer() && colidesWith(entity)) {
                applyDamage((Actor) entity);
                kill();
            } else if (!getLevel().collideTiles(getX(), getY())) {
                kill();
            } else if (outOfRange()) kill();
        }
    }

    protected boolean outOfRange() {
        double xDiff = startingX - getX();
        double yDiff = startingY - getY();

        if(Math.sqrt((xDiff * xDiff) + (yDiff * yDiff)) < range) {
            return false;
        }
        return true;
    }

    public void move(double dir) {
        setX(getX() + getSpeed() * Math.cos(dir));
        setY(getY() - getSpeed() * Math.sin(dir));
    }
}
