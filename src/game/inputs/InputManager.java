package game.inputs;

import java.awt.event.KeyEvent;

/**
 * Created by SNOW on 7/20/2017.
 */
public class InputManager {
    public boolean leftPressed = false;
    public boolean rightPressed = false;
    public boolean upPressed;
    public boolean downPressed;
    public boolean xPressed;

    public void KeyPressed(KeyEvent keyEvent){
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;

            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;

            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;

            case KeyEvent.VK_UP:
                upPressed = true;
                break;

            case KeyEvent.VK_X:
                xPressed = true;
                break;

            default:
                break;
        }
    }

    public void KeyReleased(KeyEvent keyEvent){
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;

            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;

            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;

            case KeyEvent.VK_UP:
                upPressed = false;
                break;

            case KeyEvent.VK_X:
                xPressed = false;
                break;

            default:
                break;
        }
    }
}
