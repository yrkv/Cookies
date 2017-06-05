package main.entity.moving.character.enemy;

import main.entity.moving.character.Actor;
import main.entity.moving.character.Player;

/**
 * Created by Kaleb on 6/4/2017.
 */
public class EnemyBase extends Actor {

    Player player1;

    public EnemyBase(double x, double y, double dir, double spd, double hp, Player player) {
        super(x,y,dir,spd,hp);
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
