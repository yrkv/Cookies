package main.entity.moving.Enemy;

import main.entity.moving.MovingEntity;
import main.entity.moving.Player;

/**
 * Created by Kaleb on 6/4/2017.
 */
public class meleeWalkingZombie extends Enemy {
    public meleeWalkingZombie(double x, double y, double dir, Player player) {
        super(x,y,dir,player);
    }
}
