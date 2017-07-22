package game.enemies;

import bases.FrameCounter;
import bases.GameObjects;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Utils;
import game.players.Player;

import javax.xml.bind.ValidationEvent;

/**
 * Created by SNOW on 7/21/2017.
 */
public class EnemyFocus extends GameObjects{

    private Vector2D positionPlayer;
    FrameCounter frameCounter;

    public EnemyFocus(Vector2D positionPlayer){
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("enemies/level0/blue/0.png"));
        this.positionPlayer = positionPlayer;
        this.frameCounter  = new FrameCounter(100);
    }

    @Override
    public void run() {
        this.position.addUp(0, 2);

        speslls();
    }

    private void speslls() {


        if (frameCounter.run()){
            EnemySpellsFocus enemySpellsFocus = new EnemySpellsFocus(this.positionPlayer);
            enemySpellsFocus.position.set(this.position.x, this.position.y + 20);

            GameObjects.add(enemySpellsFocus);
            frameCounter.reset();
        }

    }
}
