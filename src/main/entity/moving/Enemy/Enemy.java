package main.entity.moving.Enemy;

import main.entity.moving.MovingEntity;
import main.entity.moving.Player;

/**
 * Created by Kaleb on 6/4/2017.
 */
public class Enemy extends MovingEntity {

    Player player1;

    public Enemy(double x, double y, double dir, Player player) {
        super(x,y,dir);
        player1 = player;
    }

    protected

}
