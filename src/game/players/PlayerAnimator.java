package game.players;

import bases.Vector2D;
import bases.renderers.Animation;
import bases.renderers.Renderer;
import game.Utils;

import java.awt.*;

/**
 * Created by SNOW on 7/31/2017.
 */
public class PlayerAnimator implements Renderer {

    private Animation leftAnimation;
    private Animation rightAnimation;
    private Animation straightAnimation;

    private Animation currentAnimation;

    public PlayerAnimator() {
        leftAnimation = new Animation(
                Utils.loadAssetsImage("players/left/0.png"),
                Utils.loadAssetsImage("players/left/1.png"),
                Utils.loadAssetsImage("players/left/2.png"),
                Utils.loadAssetsImage("players/left/3.png"),
                Utils.loadAssetsImage("players/left/4.png"),
                Utils.loadAssetsImage("players/left/5.png")
        );
        rightAnimation = new Animation(
                Utils.loadAssetsImage("players/right/0.png"),
                Utils.loadAssetsImage("players/right/1.png"),
                Utils.loadAssetsImage("players/right/2.png"),
                Utils.loadAssetsImage("players/right/3.png"),
                Utils.loadAssetsImage("players/right/4.png"),
                Utils.loadAssetsImage("players/right/5.png")
        );
        straightAnimation = new Animation(
                Utils.loadAssetsImage("players/straight/0.png"),
                Utils.loadAssetsImage("players/straight/1.png"),
                Utils.loadAssetsImage("players/straight/2.png"),
                Utils.loadAssetsImage("players/straight/3.png"),
                Utils.loadAssetsImage("players/straight/4.png"),
                Utils.loadAssetsImage("players/straight/5.png"),
                Utils.loadAssetsImage("players/straight/6.png")
        );
    }

    public void run(Player player){
        if (player.velocity.x < 0){
            currentAnimation = leftAnimation;
        }else if (player.velocity.x > 0){
            currentAnimation = rightAnimation;
        }else {
            currentAnimation = straightAnimation;
        }
    }

    @Override
    public void render(Graphics g, Vector2D position) {
        if (currentAnimation != null){
            currentAnimation.render(g, position);
        }
    }
}
