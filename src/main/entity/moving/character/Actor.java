package main.entity.moving.character;

import main.entity.moving.MovingEntity;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class Actor extends MovingEntity {
    double health;
    boolean alive = true;

    public Actor(double x, double y, double dir, double speed, double hp) {
        super(x,y,dir,speed);
        health = hp;
    }

    //returns change in health
    public double takeDamage(double dmg) {
        double originalHealth = health;
        if(health - dmg < 0) {
            health = 0;
        } else {
            health -= dmg;
        }
        return health-originalHealth;
    }

    public void kill() {
        alive = false;
    }
}
