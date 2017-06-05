package main.entity.moving;

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

    protected double getPlayerX() {
        return player1.getX();
    }

    protected double getPlayerY() {
        return player1.getY();
    }

}
