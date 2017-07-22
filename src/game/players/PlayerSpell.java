package game.players;

import bases.GameObjects;
import bases.ImageRenderer;
import game.Utils;

import java.awt.*;

/**
 * Created by SNOW on 7/13/2017.
 */
public class PlayerSpell extends GameObjects{

   public PlayerSpell(){
       this.renderer = new ImageRenderer(Utils.loadAssetsImage("player-spells/a/1.png"));
   }

   @Override
   public void run(){
       this.position.addUp(0,-10);

   }
}
