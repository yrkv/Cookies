package main.entity.moving.projectile.dopeysword;

import main.display.Sprite;
import main.entity.Entity;
import main.entity.moving.character.Actor;
import main.entity.moving.projectile.ProjectileBase;
import main.level.Level;

/**
 * Created by Yegor Kuznetsov on 6/11/2017.
 */
public class Banana extends ProjectileBase {
	public Banana(double x, double y, double startingX, double startingY, double dir, double spd, double rnge, double dmg, Level level) {
		super(x, y, startingX, startingY, dir, spd, rnge, dmg, level);

		setHitBoxRadius(20);
		setSprite(Sprite.banana);
	}

	public void update() {
		move(getDir());
		colisionCheckNotPlayer();
	}
}
