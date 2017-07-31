package game.players;

import bases.GameObjects;
import bases.Vector2D;
import bases.renderers.Animation;
import game.Utils;

/**
 * Created by SNOW on 7/31/2017.
 */
public class PlayerExplosion extends GameObjects{
    private Animation animation;

    public PlayerExplosion() {
        animation = new Animation(
                5,
                false,
                Utils.loadAssetsImage("players/explosions/0.png"),
                Utils.loadAssetsImage("players/explosions/1.png"),
                Utils.loadAssetsImage("players/explosions/2.png"),
                Utils.loadAssetsImage("players/explosions/3.png"),
                Utils.loadAssetsImage("players/explosions/4.png"),
                Utils.loadAssetsImage("players/explosions/5.png"),
                Utils.loadAssetsImage("players/explosions/6.png"),
                Utils.loadAssetsImage("players/explosions/7.png")
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
