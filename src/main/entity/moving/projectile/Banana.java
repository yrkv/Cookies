package main.entity.moving.projectile;

import main.display.Sprite;
import main.entity.Entity;
import main.entity.moving.character.Actor;
import main.level.Level;

/**
 * Created by Yegor Kuznetsov on 6/11/2017.
 */
public class Banana extends ProjectileBase {
	public Banana(double x, double y, double dir, double spd, double dmg, Level level) {
		super(x, y, dir, spd, dmg, level);

		setHitBoxRadius(20);
		setSprite(Sprite.banana);
	}

	public void update() {
		move(getDir());
		for (Entity entity : getLevel().getEntities())
		if(entity.isActor() && entity != getPlayer() && colidesWith(entity)) {
			applyDamage((Actor) entity);
		} else if (!getLevel().collideTiles(getX(), getY())) {
			kill();
		}
	}
}
