package game.players;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by SNOW on 7/13/2017.
 */
public class Player {
    public int x;
    public int y;
    public BufferedImage image;

    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }

    public void render(Graphics2D g2d){
        g2d.drawImage(image,x,y,null);
    }
}
