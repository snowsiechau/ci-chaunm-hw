package game.players;

import bases.GameObjects;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Utils;

/**
 * Created by SNOW on 7/25/2017.
 */
public class ChildPlayer extends GameObjects{
    public ChildPlayer() {
        super();

        this.renderer = new ImageRenderer(Utils.loadAssetsImage("sphere/0.png"));
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
    }
}
