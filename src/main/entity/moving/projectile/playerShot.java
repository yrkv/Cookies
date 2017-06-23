package main.entity.moving.projectile;

import main.display.Sprite;
import main.entity.Entity;
import main.entity.moving.character.Actor;
import main.level.Level;

/**
 * Created by Yegor Kuznetsov on 6/11/2017.
 */
public class playerShot extends ProjectileBase {
	public playerShot(double x, double y, double startingX, double startingY, double dir, double spd, double rnge, double dmg, Level level, Sprite sprite) {
		super(x, y, startingX, startingY, dir, spd, rnge, dmg, level);

		setHitBoxRadius(20);
		setSprite(sprite);
	}

	public void update() {
		move(getDir());
		for (Entity entity : getLevel().getEntities())
		if(entity.isActor() && entity != getPlayer() && colidesWith(entity)) {
			applyDamage((Actor) entity);
			kill();
		} else if (!getLevel().collideTiles(getX(), getY())) {
			kill();
		} else if(outOfRange()) kill();
	}
}
