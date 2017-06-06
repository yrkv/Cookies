package main.entity.moving.projectile;

import main.entity.moving.character.Player;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class Bullet extends ProjectileBase {
    public Bullet(double x, double y, double dir, double spd, double dmg) {
        super(x,y,dir,spd,dmg);
    }

    public void update() {
        move(getDir());

        if(colidesWith(getPlayer())) {
            applyDamage(getPlayer());
        }
    }
}
