package game.enemies;

import bases.GameObjects;
import bases.ImageRenderer;
import game.Utils;

/**
 * Created by SNOW on 7/21/2017.
 */
public class EnemySpells extends GameObjects{

    public EnemySpells(){
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("enemies/bullets/yellow.png"));
    }

    @Override
    public void run() {
        this.position.addUp(0, 5);
    }
}
