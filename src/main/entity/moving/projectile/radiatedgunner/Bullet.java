package main.entity.moving.projectile.radiatedgunner;

import main.display.Sprite;
import main.entity.moving.character.Player;
import main.entity.moving.projectile.ProjectileBase;
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
        colisionCheckOnlyPlayer();
    }
}
