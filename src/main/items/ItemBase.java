package main.items;

import main.display.Sprite;
import main.entity.Entity;
import main.level.Level;

/**
 * Created by Kaleb on 6/6/2017.
 */
public class ItemBase {
    private Sprite sprite = null;
    private Entity owner;
    private Level level;

    public ItemBase(Entity ownr, Level level) {
        owner = ownr;
        this.level = level;
    }

    protected void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Entity getOwner() {
        return owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public Level getLevel() {
        return level;
    }
}
