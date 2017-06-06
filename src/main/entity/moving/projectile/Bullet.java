package main.entity.moving.projectile;

import main.entity.moving.character.Player;
import main.level.Level;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class Bullet extends ProjectileBase {
    public Bullet(double x, double y, double dir, double spd, double dmg, Level level) {
        super(x,y,dir,spd,dmg,level);
    }

    public void update() {
        move(getDir());

        if(colidesWith(getPlayer())) {
            applyDamage(getPlayer());
        }
    }
}
