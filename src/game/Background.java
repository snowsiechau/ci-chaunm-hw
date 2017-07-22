package game;

import bases.Contraints;
import bases.FrameCounter;
import bases.GameObjects;
import bases.ImageRenderer;
import com.sun.prism.impl.FactoryResetException;

/**
 * Created by SNOW on 7/21/2017.
 */
public class Background extends GameObjects{

    Contraints contraints;

    public Background(){
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("background/0.png"));
        this.contraints = new Contraints(0, renderer.image.getHeight() / 2, 0, 400);
    }

    @Override
    public void run() {
            this.position.addUp(0, 1);
            contraints.make(position);
    }

}
