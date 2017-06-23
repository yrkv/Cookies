package main.items.weapons.dopeysword;

import main.display.Sprite;
import main.entity.Entity;
import main.entity.moving.character.Actor;
import main.items.weapons.WeaponBase;
import main.level.Level;

/**
 * Created by Kaleb on 6/6/2017.
 */
public class DopeySword extends WeaponBase {
    //CONFIG
    private static final double DAMAGE = 50;
    private static final double RANGE = 150;
    private static final double PROJECTILESPEED = 10;
    private static final double RELOADTIME = 500;
    //END CONFIG

    public DopeySword(Level level) {
        super(DAMAGE,RANGE,PROJECTILESPEED,RELOADTIME,level);

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
            //long ass Banana making -- also its supposed to not be a projectile
//            Banana Banana = new Banana(getLevel().getPlayer().getX(), getLevel().getPlayer().getY(), getLevel().getPlayer().getX(), getLevel().getPlayer().getY(), getLevel().getPlayer().getDir(), getProjectileSpeed(), getRange(), getDamage(), getLevel());
//            getLevel().addEntity(Banana);
            if (closestTarget != null) {
                onHit((Actor) closestTarget);
            }
            setLastUse(System.currentTimeMillis());
        }
    }
}