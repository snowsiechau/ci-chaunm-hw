package game.enemies;

import bases.*;
import game.Utils;
import game.players.ChildPlayerBullet;
import game.players.Player;
import game.scenes.Setting;

import java.awt.*;


/**
 * Created by SNOW on 7/21/2017.
 */
public class Enemy extends GameObjects{

    private FrameCounter shootCounter;

    public Vector2D velocity;

    Boxcollider boxcollider;

    public Enemy(){
        super();
        this.shootCounter = new FrameCounter(100);
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("enemies/level0/black/0.png"));
        this.velocity = new Vector2D();

        boxcollider = new Boxcollider(20,20);
        this.children.add(boxcollider);

    }


    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);

        velocity.y = Setting.SPEED_ENEMY;
        this.position.addUp(velocity);

        if (this.position.y < 800) {
            if (shootCounter.run()) {
                this.shootCounter.reset();

                shoot();

            }
        }


    }

    private void shoot() {
        Vector2D target = Player.instance.position;

        Vector2D bulletVelocity = target.substract(position)
                .nomalize()
                .multiply(Setting.SPEDD_ENEMY_BULLET);

        EnemyBullet enemyBullet = new EnemyBullet();
        enemyBullet.velocity.set(bulletVelocity);
        enemyBullet.position.set(this.position);

        GameObjects.add(enemyBullet);
    }
}
