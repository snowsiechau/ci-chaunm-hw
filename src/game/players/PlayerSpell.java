package game.players;

import bases.GameObjects;
import bases.renderers.ImageRenderer;
import bases.Vector2D;
import bases.physics.Boxcollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import game.Utils;
import game.enemies.Enemy;
import game.scenes.Setting;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;


/**
 * Created by SNOW on 7/13/2017.
 */
public class PlayerSpell extends GameObjects implements PhysicsBody{

    private Boxcollider boxcollider;

   public PlayerSpell(){
       this.renderer = new ImageRenderer(Utils.loadAssetsImage("player-spells/a/1.png"));
       this.boxcollider = new Boxcollider(20,20);
       children.add(boxcollider);

   }

   @Override
   public void run(Vector2D parentPosition){
       super.run(parentPosition);
       this.position.addUp(0, Setting.SPEED_PLAYER_SPELL);

       hitEnemy();

       if (this.position.y < 0){
           this.isActive = false;
       }
   }

    private void hitEnemy() {
        Enemy hitEnemy = Physics.bodyInRed(this.boxcollider, Enemy.class);
        if (hitEnemy != null){
            hitEnemy.getHit(1);
            this.isActive = false;

            AudioUtils audioUtils = new AudioUtils();
            Clip clip = audioUtils.loadSound("assets/music/sfx/enemy-explosion.wav");
            clip.setFramePosition(0);
            clip.start();

        }
    }

    @Override
    public Boxcollider getBoxcollider() {
        return boxcollider;
    }
}
