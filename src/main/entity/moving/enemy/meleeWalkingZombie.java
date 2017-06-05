package main.entity.moving.enemy;

import main.display.Sprite;
import main.entity.moving.Player;

/**
 * Created by Kaleb on 6/4/2017.
 */
public class meleeWalkingZombie extends EnemyBase {
    public meleeWalkingZombie(double x, double y, double dir, double speed, Player player) {
        super(x,y,dir,speed,player);

        setSprite(Sprite.meleeWalkingZombie);
    }

    public void selectMove() {
        setDirTowards(getPlayer());
    }
}
