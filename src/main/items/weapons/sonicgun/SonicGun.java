package main.items.weapons.sonicgun;

import main.entity.moving.character.Player;
import main.entity.moving.projectile.sonicgun.SonicShot;
import main.items.weapons.WeaponBase;
import main.level.Level;

/**
 * Created by Kaleb on 6/22/2017.
 */
public class SonicGun extends WeaponBase {
    //CONFIG
    private static final double DAMAGE = 1;
    private static final double RANGE = 160;
    private static final double PROJECTILESPEED = 20;
    private static final double RELOADTIME = 100;
    //END CONFIG

    public SonicGun(Level level) {
        super(DAMAGE, RANGE, PROJECTILESPEED, RELOADTIME, level);
    }

    @Override
    public void onUse() {
        if(System.currentTimeMillis() - getLastUse() > RELOADTIME) {
            Player player = getLevel().getPlayer();
            SonicShot pewpew = new SonicShot(player.getX(), player.getY(), player.getX(), player.getY(), player.getDir(), PROJECTILESPEED, RANGE, DAMAGE, getLevel());
            getLevel().addEntity(pewpew);
        }
    }
}
