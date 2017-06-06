package main.entity.moving.character.enemy;

import main.display.Sprite;
import main.entity.moving.character.Player;

/**
 * Created by Kaleb on 6/4/2017.
 */
public class meleeWalkingZombie extends EnemyBase {
    public meleeWalkingZombie(double x, double y, double dir, double speed, double hp, Player player) {
        super(x,y,dir,speed,hp,player);

        setSprite(Sprite.meleeWalkingZombie);
    }

    public void selectMove() {

        if(getPlayer().isAlive()) {
            setDirTowards(getPlayer());
        } else {
            setDir(Math.random() * 2);
            takeDamage(1.0);
        }


        double dx = getPlayerX() - getX();
        double dy = getPlayerY() - getY();
        if(dx < 15 && dy < 15 && dx > -15 && dy > -15) {
            getPlayer().takeDamage(1.0);
        }
    }

    public void update() {
        if(isAlive()) {
            selectMove();
            move(getDir());
        }
    }
}
