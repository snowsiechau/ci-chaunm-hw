package game.players;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by SNOW on 7/13/2017.
 */
public class PlayerSpell {
    public int x;
    public int y;
    public BufferedImage image;

    public void move(){
        y -= 10;
    }

    public void render(Graphics2D g2d){
        g2d.drawImage(image, x, y,null);
    }
}
