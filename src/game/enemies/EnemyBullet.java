package game.enemies;

import bases.GameObjects;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Utils;

/**
 * Created by SNOW on 7/24/2017.
 */
public class EnemyBullet extends GameObjects{
    Vector2D velocity;

    public EnemyBullet() {
        super();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("enemies/bullets/blue.png"));
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);

        this.position.addUp(velocity);
    }
}
