package game.players;

import bases.Contraints;
import bases.FrameCounter;
import bases.ImageRenderer;
import bases.Vector2D;
import game.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by SNOW on 7/13/2017.
 */
public class Player {

    public Vector2D position;
    public ImageRenderer imageRenderer;
    Contraints contraints;

    FrameCounter cooldownCounter;
    boolean spellDisable;

    public Player(){
        this.position = new Vector2D();
        this.cooldownCounter = new FrameCounter(17);
        this.imageRenderer  = new ImageRenderer(Utils.loadAssetsImage("players/straight/0.png"));
    }

    public void move(float dx, float dy){
        this.position.addUp(dx, dy);
        contraints.make(this.position);
    }

    public void castSpell(ArrayList<PlayerSpell> playerSpells){
        if (!spellDisable) {
            PlayerSpell playerSpell = new PlayerSpell();
            playerSpell.position.set(this.position.add(0, -20));
            playerSpells.add(playerSpell);

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

    public void render(Graphics2D g2d){
        imageRenderer.render(g2d, this.position);
    }

    public void setContraints(Contraints contraints){
        this.contraints = contraints;
    }
}
