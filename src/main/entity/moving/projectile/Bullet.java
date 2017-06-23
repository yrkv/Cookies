package main.entity.moving.projectile;

import main.display.Sprite;
import main.entity.moving.character.Player;
import main.level.Level;
import org.lwjgl.opengl.GL11;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class Bullet extends ProjectileBase {
    public Bullet(double x, double y, double startingX, double startingY, double dir, double spd, double rnge, double dmg, Level level) {
        super(x,y,startingX,startingY,dir,spd,rnge,dmg,level);

        setHitBoxRadius(100);

        setSprite(Sprite.banana);
    }

    public void update() {
        move(getDir());
        if(colidesWith(getPlayer())) {
            applyDamage(getPlayer());
        } else if (getLevel().collideTiles(getX(), getY()))
            kill();
        else if(outOfRange()) kill();
    }
}
