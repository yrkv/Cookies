package main.entity.moving.projectile;

import main.display.Sprite;
import main.entity.moving.character.Player;
import main.level.Level;
import org.lwjgl.opengl.GL11;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class Bullet extends ProjectileBase {
    public Bullet(double x, double y, double dir, double spd, double dmg, Level level) {
        super(x,y,dir,spd,dmg,level);

        setHitBoxRadius(10);

        setSprite(Sprite.meleeWalkingZombie);
    }

    public void update() {
        move(getDir());
        System.out.println(colidesWith(getPlayer()));
        if(colidesWith(getPlayer())) {
            applyDamage(getPlayer());
            delete();
        }
    }
}
