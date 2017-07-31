package bases;

import java.util.Vector;

/**
 * Created by SNOW on 7/26/2017.
 */
public class GameObjectPool {
    private static Vector<GameObjects> pool = new Vector<>();

    public static <T extends GameObjects> T recycle(Class<T> classz){
        for (GameObjects gameObjects: pool){
            if (!gameObjects.isActive && gameObjects.getClass() == classz){
                gameObjects.refresh();
                return (T) gameObjects;
            }
        }
        try {
            T newGameObject = classz.newInstance();  // = new PlayerSpell();
            pool.add(newGameObject);
            GameObjects.add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
