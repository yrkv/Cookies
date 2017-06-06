package main.entity.moving.character.enemy;

import main.entity.moving.character.Actor;
import main.entity.moving.character.Player;
import main.level.Level;

/**
 * Created by Kaleb on 6/4/2017.
 */
public class EnemyBase extends Actor {

    public EnemyBase(double x, double y, double dir, double spd, double hp, Level level) {
        super(x,y,dir,spd,hp, level);
    }

    protected double getPlayerX() {
        return getPlayer().getX();
    }

    protected double getPlayerY() {
        return getPlayer().getY();
    }

}
