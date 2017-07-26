package game.players;

import bases.GameObjectPool;
import bases.GameObjects;
import bases.renderers.Animation;
import bases.renderers.ImageRenderer;
import bases.Vector2D;
import bases.physics.Boxcollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import game.Utils;
import game.enemies.Enemy;
import game.enemies.EnemyBoom;
import game.scenes.Setting;

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
            hitEnemy.isActive = false;
            this.isActive = false;
            EnemyBoom enemyBoom = new EnemyBoom();
            enemyBoom.position.set(this.position);
            GameObjects.add(enemyBoom);
        }
    }

    @Override
    public Boxcollider getBoxcollider() {
        return boxcollider;
    }
}
