package game.enemies;

import bases.FrameCounter;
import bases.GameObjects;
import bases.Vector2D;
import game.players.Player;

/**
 * Created by SNOW on 7/20/2017.
 */
public class EnemySpawner extends GameObjects{

    FrameCounter enemyCounter;

    public EnemySpawner(){
        this.enemyCounter = new FrameCounter(50);
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        if (enemyCounter.run()) {
            enemyCounter.reset();

            Enemy enemy = new Enemy();
            float x = (int) (Math.random() * 300 + 5);
            enemy.position.set(x, 0);

            GameObjects.add(enemy);
        }
    }

}
