package game.players;

import bases.GameObjects;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Utils;

/**
 * Created by SNOW on 7/25/2017.
 */
public class ChildPlayerBullet extends GameObjects {

    public Vector2D velocity;

    public ChildPlayerBullet() {
        super();
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("sphere-bullets/0.png"));
        this.velocity = new Vector2D();
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);

        this.position.addUp(velocity);
    }
}
