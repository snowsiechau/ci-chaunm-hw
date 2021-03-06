package bases.physics;

import bases.GameObjects;
import bases.Mathx;

/**
 * Created by SNOW on 7/25/2017.
 */
public class Boxcollider extends GameObjects {
    public float width;
    public float height;

    public Boxcollider(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public Boxcollider() {
        this(0,0);
    }

    public float left(){
        return this.screenPosition.x - width / 2;
    }

    public float right(){
        return this.screenPosition.x + width / 2;
    }

    public float top(){
        return this.screenPosition.y - height / 2;
    }

    public float bottom(){
        return this.screenPosition.y + height / 2;
    }

    public boolean collideWidth(Boxcollider other){
        boolean xOverlap = Mathx.inRange(other.left(), this.left(), this.right())
                || Mathx.inRange(this.left(), other.left(), other.right());

        boolean yOverlap = Mathx.inRange(other.top(), this.top(), this.bottom())
                || Mathx.inRange(this.top(), other.top(), other.bottom());

        return xOverlap && yOverlap;
    }

    @Override
    public String toString() {
        return "BoxCollider{" +
                "width=" + width +
                ", height=" + height +
                ", position=" + position +
                ", screenPosition=" + screenPosition +
                '}';
    }
}
