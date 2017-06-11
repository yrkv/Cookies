package main.entity.moving.character;

import main.entity.moving.MovingEntity;
import main.items.ItemBase;
import main.items.weapons.WeaponBase;
import main.level.Level;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kaleb on 6/5/2017.
 */
public class Actor extends MovingEntity {
    double health;
    ArrayList<ItemBase> inventory;
    ItemBase equippedItem;

    public Actor(double x, double y, double dir, double speed, double hp, Level level, int inventorySize) {
        super(x,y,dir,speed,level);
        inventory = new ArrayList<>(inventorySize);
        health = hp;
    }

    public ArrayList<ItemBase> getInventory() {
        return inventory;
    }

    public void addItem(ItemBase item) {
        inventory.add(item);
        item.setOwner(this);
    }

    public void equipItem(int index) {
        equippedItem = inventory.get(index);
    }

    public void equipItem(ItemBase item) {
        equippedItem = item;
    }

    public ItemBase getEquippedItem() {
        return equippedItem;
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
}
