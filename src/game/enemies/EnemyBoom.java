package game.enemies;

import bases.FrameCounter;
import bases.GameObjects;
import bases.Vector2D;
import bases.renderers.Animation;
import game.Utils;

/**
 * Created by SNOW on 7/27/2017.
 */
public class EnemyBoom extends GameObjects{
    FrameCounter frameCounter;

    public EnemyBoom(){
        this.renderer = new Animation(5,Utils.loadAssetsImage("enemies/explosion/0.png"),
                Utils.loadAssetsImage("enemies/explosion/1.png"),
                Utils.loadAssetsImage("enemies/explosion/2.png"),
                Utils.loadAssetsImage("enemies/explosion/3.png"),
                Utils.loadAssetsImage("enemies/explosion/4.png"),
                Utils.loadAssetsImage("enemies/explosion/5.png"),
                Utils.loadAssetsImage("enemies/explosion/6.png"),
                Utils.loadAssetsImage("enemies/explosion/7.png"));

        this.frameCounter = new FrameCounter(40);
        frameCounter.reset();
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        if (frameCounter.run()){
            this.isActive = false;
        }
    }
}
