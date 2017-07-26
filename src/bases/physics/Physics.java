package bases.physics;

import java.util.Vector;

/**
 * Created by SNOW on 7/26/2017.
 */
public class Physics {
    private static Vector<PhysicsBody> bodies = new Vector<>();

    public static void add(PhysicsBody body){
        bodies.add(body);
    }

    public static <T extends PhysicsBody> T bodyInRed(Boxcollider boxcollider, Class<T> classz){
        for (PhysicsBody body: bodies){
            if (body.isActive() && body.getBoxcollider().collideWidth(boxcollider)){
                if (body.getClass() == classz){
                    return (T) body;
                }
            }
        }
        return null;
    }
}
