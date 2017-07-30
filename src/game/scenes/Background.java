package game.scenes;

import bases.*;
import bases.renderers.ImageRenderer;
import game.Utils;
import tklibs.AudioUtils;

/**
 * Created by SNOW on 7/21/2017.
 */
public class Background extends GameObjects{

    ImageRenderer imageRenderer;
    AudioUtils audioUtils = new AudioUtils();

    public Background(){
        super();
        imageRenderer = new ImageRenderer(Utils.loadAssetsImage("background/0.png"));
        imageRenderer.anchor.set(0,1);
        this.renderer = imageRenderer;
        this.audioUtils.playMedia("assets/music/1.mp3");
    }

    @Override
    public void run(Vector2D parentPosition) {
        if (this.position.y - imageRenderer.getHeight() < 0) {
            this.position.addUp(0, 1);
        }
    }

}
