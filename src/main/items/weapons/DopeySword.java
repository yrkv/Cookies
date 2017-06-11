package main.items.weapons;

import main.display.Sprite;
import main.entity.Entity;
import main.entity.moving.character.Actor;
import main.level.Level;

/**
 * Created by Kaleb on 6/6/2017.
 */
public class DopeySword extends WeaponBase {

    public DopeySword(double dmg, double rnge, double reloadTime, Level level) {
        super(dmg,rnge,reloadTime,level);

        setSprite(Sprite.tile1);
    }

    public double onHit(Actor target) {
        return target.takeDamage(getDamage());
    }

    //TODO: loop through entities and check for colision. If colides, store lowest distanceTo() as the target of onHit();

    @Override
    public void onUse() {
        Entity closestTarget = null;
        double distance = -1;

        for(Entity entity : getLevel().getEntities()) {
            if(!entity.isActor()) {
                continue;
            }
            if(getOwner().distanceTo(entity) < getRange()) {
                if(distance == -1) {
                    distance = getOwner().distanceTo(entity);
                    closestTarget = entity;
                } else if(distance > getOwner().distanceTo(entity)){
                    distance = getOwner().distanceTo(entity);
                    closestTarget = entity;
                }
            }
        }

        if((System.currentTimeMillis() - getLastUse()) > getReloadTime()) {
            if (closestTarget != null) {
                onHit((Actor) closestTarget);
                setLastUse(System.currentTimeMillis());
            }
        }
    }
}