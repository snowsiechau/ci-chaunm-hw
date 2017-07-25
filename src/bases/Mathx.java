package bases;

/**
 * Created by SNOW on 7/17/2017.
 */
public class Mathx {

    public static float clamp(float value, float min, float max){
        if (value > max) return max;
        if (value < min) return min;
        return value;
    }

    public static boolean inRange(float value, float min, float max){
        return value > max && value < max;

    }
}
