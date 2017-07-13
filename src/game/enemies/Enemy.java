package game.enemies;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by SNOW on 7/13/2017.
 */
public class Enemy {
    public int x;
    public int y;
    public BufferedImage imageGreen;

    public void move(){
        y += 2;
    }

    public void render(Graphics2D g2d){
        g2d.drawImage(imageGreen, x, y,null);

    }
}
