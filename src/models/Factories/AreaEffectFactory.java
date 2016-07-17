package models.Factories;

import models.AreaEffect.AreaEffect;
import models.AreaEffect.HealthAreaEffect;
import views.Assets;

/**
 * Created by The Alex on 7/17/2016.
 */
public class AreaEffectFactory {

    /* Methods */

    public static AreaEffect getDamageHealthEffect(double modifier){
        modifier = Math.abs(modifier); //ensure pos number in case negative given.
        HealthAreaEffect areaEffect = new HealthAreaEffect(-modifier);
        areaEffect.setImage(Assets.healingAreaEffect);
        return areaEffect;
    }
}
