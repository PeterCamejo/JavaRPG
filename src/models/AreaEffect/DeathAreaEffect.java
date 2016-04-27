package models.AreaEffect;

import models.Buff.HealthBuff;

/**
 *
 */
public class DeathAreaEffect extends AreaEffect {
    public DeathAreaEffect() {
        buff = new HealthBuff(-999999999);
    }
}
