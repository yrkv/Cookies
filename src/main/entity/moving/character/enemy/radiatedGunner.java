package main.entity.moving.character.enemy;

import main.display.Sprite;
import main.entity.moving.character.Player;
import main.entity.moving.projectile.Bullet;
import main.level.Level;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class radiatedGunner extends EnemyBase {
    double reloadTime;
    long timer = 0;

    public radiatedGunner(double x, double y, double dir, double spd, double hp, double rldTime, Level level) {
        super(x,y,dir,spd,hp,level);
        reloadTime = rldTime;

        setSprite(Sprite.meleeWalkingZombie);
    }

    public void selectMove() {
        if(getPlayer().isAlive()) {
            setDirTowards(getPlayer());
        } else {
            setDir(Math.random() * 2.0);
            takeDamage(1.0);
        }
    }

    public void tryShoot() {
        if((System.currentTimeMillis() - 0) > reloadTime) {
            Bullet bullet = new Bullet(getX(),getY(),0, 9,10, getLevel());
            timer = System.currentTimeMillis();
        }
    }

}