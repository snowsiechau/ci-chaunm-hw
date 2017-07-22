package game.players;

import bases.*;
import game.Utils;
import game.enemies.EnemyFocus;
import game.enemies.EnemySpellsFocus;
import game.inputs.InputManager;

import javax.xml.bind.ValidationEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by SNOW on 7/13/2017.
 */
public class Player extends GameObjects {
    Contraints contraints;
    InputManager inputManager;

    Vector2D velocity;

    FrameCounter cooldownCounter;
    FrameCounter enemyFocusCounter;
    boolean spellDisable;


    public Player(){
        this.velocity = new Vector2D();
        this.cooldownCounter = new FrameCounter(17);
        this.enemyFocusCounter = new FrameCounter(100);
        this.renderer = new ImageRenderer(Utils.loadAssetsImage("players/straight/0.png"));
    }

    @Override
    public void run() {
        move();

        castSpell();

        cooldown();

        enemyFocus();

    }

    private void enemyFocus() {
        if (enemyFocusCounter.run()) {

            EnemyFocus enemyFocus = new EnemyFocus(this.position);
            float x = (int) (Math.random() * 300 + 5);
            enemyFocus.position.set(x, 0);

            GameObjects.add(enemyFocus);
            enemyFocusCounter.reset();
        }
    }

    public void move(){
        this.velocity.set(0, 0);
        if (inputManager.leftPressed) velocity.x -= 5;
        if (inputManager.rightPressed) velocity.x += 5;
        if (inputManager.upPressed) velocity.y -= 5;
        if (inputManager.downPressed) velocity.y += 5;

        this.position.addUp(velocity);
        this.contraints.make(this.position);
    }

    public void castSpell(){
        if (!spellDisable) {
            if (inputManager.xPressed) {
                PlayerSpell playerSpell = new PlayerSpell();
                playerSpell.position.set(this.position.add(0, -20));
                GameObjects.add(playerSpell);

                spellDisable = true;
            }
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
    
    public void render(Graphics2D g2d){
        renderer.render(g2d, this.position);
    }

    public void setContraints(Contraints contraints){
        this.contraints = contraints;
    }

    public void setInputManager(InputManager inputManager){
        this.inputManager = inputManager;
    }

}
