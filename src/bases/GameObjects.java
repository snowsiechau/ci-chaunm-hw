package bases;

import bases.physics.Physics;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;
import bases.renderers.Renderer;

import java.awt.*;
import java.util.Vector;

/**
 * Created by SNOW on 7/20/2017.
 */
public class GameObjects {

    public Vector2D position;
    public Vector2D screenPosition;

    public Renderer renderer;

    public boolean isActive;

    public  Vector<GameObjects> children;
    private static Vector<GameObjects> gameObjects = new Vector<>();
    private static Vector<GameObjects> newGameObjects = new Vector<>();

    public  GameObjects(){
        this.position = new Vector2D();
        this.screenPosition = new Vector2D();
        this.children = new Vector<>();
        this.isActive = true;
    }

    public boolean isActive(){
        return isActive;
    }

    public void setActive(boolean active){
        this.isActive = active;
    }

    public static void add(GameObjects gameObjects){
        newGameObjects.add(gameObjects);

        if (gameObjects instanceof PhysicsBody){
            Physics.add((PhysicsBody) gameObjects);
        }
    }

    public static void runAll(){
        for (GameObjects gameObject: gameObjects) {
            if (gameObject.isActive) {
                gameObject.run(Vector2D.ZERO);
            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        System.out.println(gameObjects.size());
    }

    public static void renderAll(Graphics2D g2d){
        for (GameObjects gameObject: gameObjects) {
            if (gameObject.isActive) {
                gameObject.render(g2d, gameObject.position);
            }
        }
    }

    public void run(Vector2D parentPosition){

        this.screenPosition = parentPosition.add(this.position);

        for (GameObjects child: children) {
            child.run(this.screenPosition);
        }
    }

    public void render(Graphics2D g2d, Vector2D position){
        if (renderer != null) {
            renderer.render(g2d, position);
        }
    }



}
