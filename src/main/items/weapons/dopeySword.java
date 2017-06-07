package main.items.weapons;

import main.display.Sprite;
import main.entity.Entity;
import main.entity.moving.character.Actor;
import main.items.weapons.WeaponBase;
import main.level.Level;

/**
 * Created by Kaleb on 6/6/2017.
 */
public class dopeySword extends WeaponBase {

    public dopeySword(double dmg, double rnge, Entity owner, Level level) {
        super(dmg,rnge,owner,level);

        setSprite(Sprite.tile1);
    }

    private double onHit(Actor target) {
        return target.takeDamage(getDamage());
    }

    //TODO: loop through entities and check for colision. If colides, store lowest distanceTo() as the target of onHit();

    private Actor onAttack() {
        Entity closestTarget = null;
        double distance = -1;

        for(Entity entity : getLevel().getEntities()) {
            if(!entity.getActorStatus()) {
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

        onHit((Actor)closestTarget);
        return (Actor)closestTarget;
    }
}