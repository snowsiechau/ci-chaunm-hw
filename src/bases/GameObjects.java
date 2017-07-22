package bases;

import java.awt.*;
import java.util.Vector;

/**
 * Created by SNOW on 7/20/2017.
 */
public class GameObjects {

    public Vector2D position;
    public ImageRenderer renderer;

    private static Vector<GameObjects> gameObjects = new Vector<>();
    private static Vector<GameObjects> newGameObjects = new Vector<>();

    public  GameObjects(){
        this.position = new Vector2D();
    }

    public static void add(GameObjects gameObjects){
        newGameObjects.add(gameObjects);
    }

    public static void runAll(){
        for (GameObjects gameObject: gameObjects) {
            gameObject.run();
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics2D g2d){
        for (GameObjects gameObject: gameObjects) {
            gameObject.render(g2d);
        }
    }

    public void run(){
    }

    public void render(Graphics2D g2d){
        if (renderer != null) {
            renderer.render(g2d, position);
        }
    }



}
