package game.enemies;

import bases.GameObjects;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Utils;

/**
 * Created by SNOW on 7/21/2017.
 */
public class EnemySpellsFocus extends GameObjects{
    Vector2D playerPosition;

    public EnemySpellsFocus(Vector2D playerPosition){
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("enemies/bullets/red.png"));
        this.playerPosition = playerPosition;
    }

    @Override
    public void run() {
        if (this.playerPosition.x > this.position.x){
            this.position.addUp(1, 3);
        }
        else if (this.playerPosition.x < this.position.x){
            this.position.addUp(-1, 3);
        }
        else {
            this.position.addUp(0, 3);
        }


    }
}
