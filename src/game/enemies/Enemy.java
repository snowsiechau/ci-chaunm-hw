package game.enemies;

import bases.Contraints;
import bases.FrameCounter;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by SNOW on 7/13/2017.
 */
public class Enemy {
    public Vector2D position;
    public ImageRenderer imageRenderer;

    Contraints contraints;

    public int x;

    public Enemy(int x){
        this.position = new Vector2D();
        this.imageRenderer = new ImageRenderer(Utils.loadAssetsImage("enemies/bullets/green.png"));
        this.x = x;
    }

    public void move(){
        this.position.addUp(this.x, 5);
        contraints.make(this.position);


    }

    public void render(Graphics2D g2d){
        imageRenderer.render(g2d, this.position);
    }

    public void setContraints(Contraints contraints){
        this.contraints = contraints;
    }
}
