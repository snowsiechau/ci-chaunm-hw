package game.players;

import bases.*;
import bases.physics.Boxcollider;
import bases.physics.PhysicsBody;
import bases.renderers.Animation;
import bases.renderers.ImageRenderer;
import game.Utils;
import game.inputs.InputManager;
import game.scenes.Setting;
import sun.nio.cs.UTF_32LE;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

/**
 * Created by SNOW on 7/13/2017.
 */
public class Player extends GameObjects implements PhysicsBody{
    Contraints contraints;
    InputManager inputManager;

    Vector2D velocity;

    FrameCounter cooldownCounter;

    boolean spellDisable;

    public static Player instance;

    private Boxcollider boxcollider;


    public Player(){
        super();
        this.velocity = new Vector2D();
        this.cooldownCounter = new FrameCounter(10);

        this.renderer = new Animation(10, Utils.loadAssetsImage("players/straight/0.png"),
                Utils.loadAssetsImage("players/straight/1.png"),
                Utils.loadAssetsImage("players/straight/2.png"),
                Utils.loadAssetsImage("players/straight/3.png"),
                Utils.loadAssetsImage("players/straight/4.png"),
                Utils.loadAssetsImage("players/straight/5.png"),
                Utils.loadAssetsImage("players/straight/6.png")
        );

        instance = this;

        this.boxcollider = new Boxcollider(20,20);
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        move();
        castSpell();
        cooldown();
    }

    public void move(){
        this.velocity.set(0, 0);
        if (inputManager.leftPressed) velocity.x -= Setting.SPEED_PLAYER;
        if (inputManager.rightPressed) velocity.x += Setting.SPEED_PLAYER;
        if (inputManager.upPressed) velocity.y -= Setting.SPEED_PLAYER;
        if (inputManager.downPressed) velocity.y += Setting.SPEED_PLAYER;

        this.position.addUp(velocity);
        this.contraints.make(this.position);
    }

    public void castSpell(){
        if (!spellDisable) {
            if (inputManager.xPressed) {
                PlayerSpell playerSpell = GameObjectPool.recycle(PlayerSpell.class);
                playerSpell.position.set(this.position.add(0, -20));

                AudioUtils audioUtils = new AudioUtils();
                Clip clip = audioUtils.loadSound("assets/music/sfx/player-shoot.wav");
                clip.setFramePosition(0);
                clip.start();

            }
                spellDisable = true;
        }
    }


    public void cooldown(){
        if (spellDisable){
            boolean status = cooldownCounter.run();
            if (status){
                spellDisable = false;
                cooldownCounter.reset();
            }
        }
    }

    public void setContraints(Contraints contraints){
        this.contraints = contraints;
    }

    public void setInputManager(InputManager inputManager){
        this.inputManager = inputManager;
    }

    @Override
    public Boxcollider getBoxcollider() {
        return boxcollider;
    }
}
