package main.entity.moving.character;

import main.entity.moving.MovingEntity;
import main.level.Level;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class Actor extends MovingEntity {
    double health;
    boolean alive = true;

    public Actor(double x, double y, double dir, double speed, double hp, Level level) {
        super(x,y,dir,speed,level);
        health = hp;
    }

    //returns change in health
    public double takeDamage(double dmg) {
        double originalHealth = health;
        if(health - dmg < 0) {
            health = 0;
            kill();
        } else {
            health -= dmg;
            if(health == 0) {
                kill();
            }
        }
        return health-originalHealth;
    }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        alive = false;
        delete();
    }
}
