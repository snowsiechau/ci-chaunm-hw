package game.players;

import bases.GameObjects;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Utils;
import game.scenes.Setting;

import java.awt.*;

/**
 * Created by SNOW on 7/13/2017.
 */
public class PlayerSpell extends GameObjects{

   public PlayerSpell(){
       this.renderer = new ImageRenderer(Utils.loadAssetsImage("player-spells/a/1.png"));
   }

   @Override
   public void run(Vector2D parentPosition){

       super.run(parentPosition);
       this.position.addUp(0, Setting.SPEED_PLAYER_SPELL);

   }
}
