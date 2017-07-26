package bases.renderers;

import bases.Vector2D;

import java.awt.*;

/**
 * Created by SNOW on 7/26/2017.
 */
public interface Renderer {
    void render(Graphics g, Vector2D position);
}
