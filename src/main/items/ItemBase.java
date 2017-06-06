package main.items;

import main.display.Sprite;
import main.entity.Entity;

/**
 * Created by Kaleb on 6/6/2017.
 */
public class ItemBase {
    private Sprite sprite = null;
    private Entity owner;

    public ItemBase(Entity ownr) {
        owner = ownr;
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
}
