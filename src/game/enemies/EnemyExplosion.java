package game.enemies;

import bases.GameObjects;
import bases.Vector2D;
import bases.renderers.Animation;
import game.Utils;

/**
 * Created by SNOW on 7/31/2017.
 */
public class EnemyExplosion extends GameObjects{
    private Animation animation;

    public EnemyExplosion() {
        animation = new Animation(
                3,
                false,
                Utils.loadAssetsImage("enemies/explosion/0.png"),
                Utils.loadAssetsImage("enemies/explosion/2.png"),
                Utils.loadAssetsImage("enemies/explosion/4.png"),
                Utils.loadAssetsImage("enemies/explosion/6.png")
        );

        this.renderer = animation;
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        if (this.animation.isFinished()){
            this.isActive = false;
        }
    }

    @Override
    public void refresh() {
        super.refresh();
        animation.reset();
    }
}
