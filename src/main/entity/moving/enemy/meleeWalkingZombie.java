package main.entity.moving.enemy;

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
        double px = getPlayerX();
        double py = getPlayerY();

        double dx = px - getX();
        double dy = py - getY();

        double slope = -dy/dx;

        if (dx == 0 && dy == 0)
            setSpeed(0);

        if(dx>0) {
            setDir(Math.atan(slope));
        } else if(dx<0) {
            setDir(Math.PI+Math.atan(slope));
        }
    }
}
