package game.enemies;

import bases.*;
import bases.physics.Boxcollider;
import bases.physics.PhysicsBody;
import bases.renderers.Animation;

import game.Utils;
import game.players.Player;
import game.scenes.Setting;


/**
 * Created by SNOW on 7/21/2017.
 */
public class Enemy extends GameObjects implements PhysicsBody{

    private FrameCounter shootCounter;

    public Vector2D velocity;

    Boxcollider boxcollider;

    public Enemy(){
        super();
        this.shootCounter = new FrameCounter(50);
        this.velocity = new Vector2D();

        this.renderer = new Animation(Utils.loadAssetsImage("enemies/level0/blue/0.png"),
                Utils.loadAssetsImage("enemies/level0/blue/1.png"),
                Utils.loadAssetsImage("enemies/level0/blue/2.png"),
                Utils.loadAssetsImage("enemies/level0/blue/3.png")
        );

        boxcollider = new Boxcollider(20,20);
        this.children.add(boxcollider);

    }


    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);

        velocity.y = Setting.SPEED_ENEMY;

        this.position.addUp(velocity);
        if (shootCounter.run()) {
            this.shootCounter.reset();
            shoot();
        }
    }

    private void shoot() {
        Vector2D target = Player.instance.position;
        Vector2D bulletVelocity = target.substract(position)
                .nomalize()
                .multiply(Setting.SPEDD_ENEMY_BULLET);

        EnemyBullet enemyBullet = GameObjectPool.recycle(EnemyBullet.class);
        enemyBullet.velocity.set(bulletVelocity);
        enemyBullet.position.set(this.position.x, this.position.y + 15);

    }

    @Override
    public Boxcollider getBoxcollider() {
        return boxcollider;
    }
}
