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

    public void chooseDirection() {
        double dX = getPlayerX() - getX();
        double dY = getPlayerY() - getY();

        if(dX == 0) {
            if(dY > 0) {
                setDir(0.5);
                return;
            }
            else if(dY < 0) {
                setDir(1.5);
                return;
            }
        }

        if(dY == 0) {
            if(dX > 0) {
                setDir(0.0);
                return;
            }
            else if(dX < 0) {
                setDir(1.0);
                return;
            }

        }

        setDir(Math.atan((dY/dX)));
    }
}
