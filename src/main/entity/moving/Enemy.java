package main.entity.moving;

import main.entity.moving.MovingEntity;
import main.entity.moving.Player;

/**
 * Created by Kaleb on 6/4/2017.
 */
public class Enemy extends MovingEntity {

    Player player1;

    public Enemy(double x, double y, double dir, double spd, Player player) {
        super(x,y,dir,spd);
        player1 = player;
    }

    protected double getPlayerX() {
        return player1.getX();
    }

    protected Player getPlayer() {
        return player1;
    }

    protected double getPlayerY() {
        return player1.getY();
    }

}
