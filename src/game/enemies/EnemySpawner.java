package game.enemies;

import bases.FrameCounter;
import bases.GameObjects;

import java.util.Random;

/**
 * Created by SNOW on 7/20/2017.
 */
public class EnemySpawner extends GameObjects{

    FrameCounter frameCounter;

    public EnemySpawner(){
        this.frameCounter = new FrameCounter(100);
    }

    @Override
    public void run() {
        if (frameCounter.run()) {
            Enemy enemy = new Enemy();
            float x = (int) (Math.random() * 300 + 5);
            enemy.position.set(x, 0);

            GameObjects.add(enemy);

            frameCounter.reset();
        }
    }
}
