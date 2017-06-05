package main.entity.moving.enemy;

import main.entity.Entity;
import main.entity.moving.Enemy;
import main.entity.moving.Player;

/**
 * Created by Kaleb on 6/4/2017.
 */
public class meleeWalkingZombie extends Enemy {
    public meleeWalkingZombie(double x, double y, double dir, double speed, Player player) {
        super(x,y,dir,speed,player);
    }

    public void selectMove() {

        Entity.setDirFromTo(this,getPlayer());

        if (dx < 8 && dy < 8 && dx > -8 && dy > -8) {
            setSpeed(0);
        }
        else {
            setSpeed(1.5);
        }
    }
}
