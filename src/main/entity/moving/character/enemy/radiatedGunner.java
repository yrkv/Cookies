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
    double range;
    long timer = 0;

    public radiatedGunner(double x, double y, double dir, double spd, double hp, double rldTime, double rnge, Level level) {
        super(x,y,dir,spd,hp,level);
        reloadTime = rldTime;
        range = rnge;

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
        if((System.currentTimeMillis() - timer) > reloadTime) {
            Bullet bullet = new Bullet(getX(),getY(),0, 9,10, getLevel());
            bullet.setDirTowards(getLevel().getPlayer());
            timer = System.currentTimeMillis();
        }
    }

    public void update() {
        if(distanceTo(getPlayer()) > range/2) {
            selectMove();
            move(getDir());
        }
        if(distanceTo(getPlayer()) < range) {
            tryShoot();
        }
     }

}
