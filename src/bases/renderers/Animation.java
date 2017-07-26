package bases.renderers;

import bases.FrameCounter;
import bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Arrays;

/**
 * Created by SNOW on 7/26/2017.
 */
public class Animation implements Renderer{
    private List<BufferedImage> images;
    private int imageIndex;
    private FrameCounter frameCounter;


    public Animation(int delayFrame, BufferedImage... imageArrays){
        frameCounter = new FrameCounter(delayFrame);
        frameCounter.reset();

        this.images = Arrays.asList(imageArrays);
    }

    public Animation(BufferedImage... imageArrays){
        this(1, imageArrays);
    }

    @Override
    public void render(Graphics g, Vector2D position) {
        if (frameCounter.run()){
            frameCounter.reset();
            changeIndex();
        }

        BufferedImage image = images.get(imageIndex);
        g.drawImage(image,
                (int) (position.x - image.getWidth() / 2),
                (int) (position.y - image.getHeight() / 2), null);
    }

    private void changeIndex() {
        imageIndex++;
        if (imageIndex >= images.size()){
            imageIndex = 0;
        }
    }

}
