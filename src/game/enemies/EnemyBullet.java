package game.enemies;

import bases.FrameCounter;
import bases.GameObjects;
import bases.physics.Boxcollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;
import bases.Vector2D;
import game.Utils;
import game.players.Player;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

/**
 * Created by SNOW on 7/24/2017.
 */
public class EnemyBullet extends GameObjects implements PhysicsBody{
    Vector2D velocity;
    private Boxcollider boxcollider;


    public EnemyBullet() {
        super();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("enemies/bullets/blue.png"));
        this.boxcollider = new Boxcollider(20,20);

    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        this.position.addUp(velocity);

        hitPlayer();

        if (this.position.y > 800){
            this.isActive = false;
        }
    }

    private void hitPlayer() {
        Player.instance = Physics.bodyInRed(this.boxcollider, Player.class);


    }

    @Override
    public Boxcollider getBoxcollider() {
        return this.boxcollider;
    }
}
