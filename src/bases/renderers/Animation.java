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

    private boolean finished;
    private boolean repeat;


    public Animation(int delayFrame, boolean repeat, BufferedImage... imageArrays){
        frameCounter = new FrameCounter(delayFrame);
        frameCounter.reset();

        this.images = Arrays.asList(imageArrays);
        this.repeat = repeat;
    }

    public Animation(BufferedImage... imageArrays){
        this(1, true, imageArrays);
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

        if (imageIndex >= images.size() - 1){
            if (repeat) {
                imageIndex = 0;
            }
            finished = true;
        }else {
            imageIndex++;
        }
    }

    public boolean isFinished() {
        return finished;
    }

    public void reset(){
        imageIndex = 0;
        finished = false;
    }
}
