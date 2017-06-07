package main.items;

import main.display.Sprite;
import main.entity.Entity;
import main.level.Level;

/**
 * Created by Kaleb on 6/6/2017.
 */
public class ItemBase {
    private Sprite sprite = null;
    private double reloadTime;
    private boolean isEquipped = false;
    private boolean isWeapon = false;
    private long lastUse = 0;
    private Entity owner;
    private Level level;

    public ItemBase(double reloadTime, Entity ownr, Level level) {
        this.reloadTime = reloadTime;
        owner = ownr;
        this.level = level;
    }

    public long getLastUse() {
        return lastUse;
    }

    public void setLastUse(long lastUse) {
        this.lastUse = lastUse;
    }

    public boolean isWeapon() {
        return isWeapon;
    }

    public boolean setWeaponStatus(boolean newStatus) {
        isWeapon = newStatus;
        return isWeapon;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public boolean setEquipStatus(boolean newState) {
        isEquipped = newState;
        return isEquipped;
    }

    public void setReloadTime(double reloadTime) {
        this.reloadTime = reloadTime;
    }

    public double getReloadTime() {
        return reloadTime;
    }

    protected void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Entity getOwner() {
        return owner;
    }

    public void onUse() {

    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public Level getLevel() {
        return level;
    }
}
