package bases;

import java.util.Vector;

/**
 * Created by SNOW on 7/17/2017.
 */
public class Vector2D {

    public float x;
    public float y;

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
        this(0, 0);
    }

    public void set(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D other){
        set(other.x, other.y);
    }

    public void addUp(float x, float y){
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D other){
        addUp(other.x, other.y);
    }

    public Vector2D add(float x, float y){
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D other){
        return add(other.x, other.y);
    }

    public Vector2D substract(float x, float y){
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D substract(Vector2D other){
        return substract(other.x, other.y);
    }

    public Vector2D nomalize(){
        float length = (float) Math.sqrt(x * x + y * y);
        return new Vector2D(x / length, y / length);
    }

    public Vector2D multiply(float a) {
        return new Vector2D(this.x * a, this.y * a);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
