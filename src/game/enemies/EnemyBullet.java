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
import game.scenes.Setting;
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

        children.add(boxcollider);
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        this.position.addUp(velocity);

        hitPlayer();

        if (this.position.y > 800 || this.position.y < 0 || this.position.x < 0 || this.position.x > Setting.WIDTH_BACKGROUND){
            this.isActive = false;
        }
    }

    private void hitPlayer() {
        Player hitPlayer = Physics.bodyInRed(this.boxcollider, Player.class);
        if (hitPlayer != null){
            hitPlayer.getHit(1);
            this.isActive = false;

            AudioUtils audioUtils = new AudioUtils();
            Clip clip = audioUtils.loadSound("assets/music/sfx/player-dead.wav");
            clip.setFramePosition(0);
            clip.start();
        }
    }

    @Override
    public Boxcollider getBoxcollider() {
        return this.boxcollider;
    }
}
