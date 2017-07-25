package game.scenes;

import bases.*;
import com.sun.prism.impl.FactoryResetException;
import game.Utils;

/**
 * Created by SNOW on 7/21/2017.
 */
public class Background extends GameObjects{

    Contraints contraints;

    public Background(){
        super();
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("background/0.png"));
        this.renderer.anchor.set(0,1);
        this.contraints = new Contraints(0, renderer.getHeight(), 0, 400);
    }

    @Override
    public void run(Vector2D parentPosition) {
        this.position.addUp(0,1);
        contraints.make(position);
    }

}
