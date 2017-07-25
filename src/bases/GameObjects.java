package bases;

import java.awt.*;
import java.util.Vector;

/**
 * Created by SNOW on 7/20/2017.
 */
public class GameObjects {

    public Vector2D position;

    public Vector2D screenPosition;

    public ImageRenderer renderer;

    public  Vector<GameObjects> children;

    private static Vector<GameObjects> gameObjects = new Vector<>();
    private static Vector<GameObjects> newGameObjects = new Vector<>();

    public  GameObjects(){
        this.position = new Vector2D();
        this.screenPosition = new Vector2D();
        this.children = new Vector<>();
    }

    public static void add(GameObjects gameObjects){
        newGameObjects.add(gameObjects);
    }

    public static void runAll(){
        for (GameObjects gameObject: gameObjects) {
            gameObject.run(new Vector2D(0,0));
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics2D g2d){
        for (GameObjects gameObject: gameObjects) {
            gameObject.render(g2d, gameObject.position);

            for (GameObjects child: gameObject.children){
                child.render(g2d, child.screenPosition);
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
