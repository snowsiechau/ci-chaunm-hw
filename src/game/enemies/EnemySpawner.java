package game.enemies;

import bases.FrameCounter;
import bases.GameObjects;
import bases.Vector2D;
import game.players.ChildPlayerBullet;
import game.players.Player;

import java.util.Random;

/**
 * Created by SNOW on 7/20/2017.
 */
public class EnemySpawner extends GameObjects{

    FrameCounter enemyCounter;

    public EnemySpawner(){
        this.enemyCounter = new FrameCounter(100);
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        if (enemyCounter.run()) {
            enemyCounter.reset();

            Enemy enemy = new Enemy();
            float x = (int) (Math.random() * 300 + 5);
            enemy.position.set(x, 0);

            Vector2D start1 = new Vector2D(Player.instance.position.x - 30, Player.instance.position.y);
            Vector2D start2 = new Vector2D(Player.instance.position.x + 30, Player.instance.position.y);

            Vector2D bullet1 = enemy.position.substract(start1)
                    .nomalize()
                    .multiply(3);

            ChildPlayerBullet childPlayerBullet1 = new ChildPlayerBullet();
            childPlayerBullet1.velocity.set(bullet1);
            childPlayerBullet1.position.set(start1);



            Vector2D bullet2 = enemy.position.substract(start2)
                    .nomalize()
                    .multiply(3);

            ChildPlayerBullet childPlayerBullet2 = new ChildPlayerBullet();
            childPlayerBullet2.position.set(start2);
            childPlayerBullet2.velocity.set(bullet2);

            GameObjects.add(childPlayerBullet1);
            GameObjects.add(childPlayerBullet2);

            GameObjects.add(enemy);
        }

    }

}
