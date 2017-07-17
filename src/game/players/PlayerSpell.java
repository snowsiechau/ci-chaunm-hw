package game.players;

import bases.ImageRenderer;
import bases.Vector2D;
import game.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by SNOW on 7/13/2017.
 */
public class PlayerSpell {
   public Vector2D position;
   public ImageRenderer imageRenderer;

   public PlayerSpell(){
       this.position = new Vector2D();
       this.imageRenderer = new ImageRenderer(Utils.loadAssetsImage("player-spells/a/1.png"));
   }

   public void move(){
       this.position.addUp(0,-10);
   }

   public void render(Graphics2D g2d){
       imageRenderer.render(g2d, this.position);
   }
}
