package main.entity.moving.character;

import main.entity.moving.MovingEntity;
import main.items.ItemBase;
import main.level.Level;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class Actor extends MovingEntity {
    double health;
    boolean alive = true;
    ArrayList<ItemBase> inventory;

    public Actor(double x, double y, double dir, double speed, double hp, Level level, int inventorySize) {
        super(x,y,dir,speed,level);
        inventory = new ArrayList<ItemBase>(inventorySize);
        health = hp;
    }

    public ArrayList<ItemBase> getInventory() {
        return inventory;
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
