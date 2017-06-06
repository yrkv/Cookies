package main.entity.moving.projectile;

import main.entity.moving.character.Player;
import main.level.Level;
import org.lwjgl.opengl.GL11;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class Bullet extends ProjectileBase {
    public Bullet(double x, double y, double dir, double spd, double dmg, Level level) {
        super(x,y,dir,spd,dmg,level);
    }

    public boolean render() {
        GL11.glColor3d(Math.random(), Math.random(), Math.random());
        GL11.glBegin(GL11.GL_POLYGON);
        for(double i = 0; i < 2 * Math.PI; i += Math.PI / 12)
            GL11.glVertex2d(Math.cos(i) * 5 + getPlayer().getX(), Math.sin(i) * 5 + getPlayer().getY());
        GL11.glEnd();
        return true;
    }

    public void update() {
        move(getDir());

        if(colidesWith(getPlayer())) {
            applyDamage(getPlayer());
        }
    }
}
