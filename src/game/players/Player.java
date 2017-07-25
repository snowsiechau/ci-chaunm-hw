package game.players;

import bases.*;
import game.Utils;
import game.inputs.InputManager;
import game.scenes.Setting;

/**
 * Created by SNOW on 7/13/2017.
 */
public class Player extends GameObjects {
    Contraints contraints;
    InputManager inputManager;

    Vector2D velocity;

    FrameCounter cooldownCounter;

    boolean spellDisable;

    public static Player instance;

    ChildPlayer childPlayerLeft;
    ChildPlayer childPlayerRight;

    public Player(){
        super();
        this.velocity = new Vector2D();
        this.cooldownCounter = new FrameCounter(10);
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("players/straight/0.png"));

        instance = this;

        childPlayerLeft = new ChildPlayer();
        childPlayerLeft.position.set(-30, 0);
        this.children.add(childPlayerLeft);

        childPlayerRight = new ChildPlayer();
        childPlayerRight.position.set(30, 0);
        this.children.add(childPlayerRight);
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
                PlayerSpell playerSpell = new PlayerSpell();
                playerSpell.position.set(this.position.add(0, -30));
                GameObjects.add(playerSpell);
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

}
