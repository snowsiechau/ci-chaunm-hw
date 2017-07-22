package game.enemies;

import bases.FrameCounter;
import bases.GameObjects;
import bases.ImageRenderer;
import game.Utils;

import java.awt.*;


/**
 * Created by SNOW on 7/21/2017.
 */
public class Enemy extends GameObjects{

    FrameCounter frameCounter;

    public Enemy(){
        this.frameCounter = new FrameCounter(100);
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("enemies/level0/black/0.png"));

    }


    @Override
    public void run() {
        this.position.addUp(0, 3);
        spells();
    }

    @Override
    public void render(Graphics2D g2d) {
        renderer.render(g2d, this.position);
    }

    public void spells(){
        if (frameCounter.run()){
            EnemySpells enemySpells = new EnemySpells();
            enemySpells.position.set(this.position.x, this.position.y + 20);

            GameObjects.add(enemySpells);

            frameCounter.reset();
        }
    }
}
