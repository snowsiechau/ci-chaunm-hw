package game;

import bases.Contraints;
import game.enemies.Enemy;
import game.players.Player;
import game.players.PlayerSpell;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import java.util.ArrayList;


/**
 * Created by SNOW on 7/9/2017.
 */
public class GameWindow extends JFrame{

    BufferedImage background;

    Player player = new Player();
    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();

    private int backGroundY;

    BufferedImage backBufferImage;
    Graphics2D backBufferGraphic2D;

    boolean rightPressed, leftPressed, upPressed, downPressed, xPressed;


    public GameWindow(){

        setUpWindow();
        loadImage();

        Contraints contraints = new Contraints(0, this.getHeight(), 0, background.getWidth());

        player.position.set(background.getWidth() / 2, this.getHeight() - 50);

        player.setContraints(contraints);

        backGroundY = this.getHeight() - background.getHeight();

        backBufferImage = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphic2D = (Graphics2D) backBufferImage.getGraphics();

        setupInput();

        this.setVisible(true);
    }

    private void setupInput() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        rightPressed = true;
                        break;

                    case KeyEvent.VK_LEFT:
                        leftPressed = true;
                        break;

                    case KeyEvent.VK_UP:
                        upPressed = true;

                        break;

                    case KeyEvent.VK_DOWN:
                        downPressed = true;
                        break;

                    case KeyEvent.VK_X:
                        xPressed = true;
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        rightPressed = false;
                        break;

                    case KeyEvent.VK_LEFT:
                        leftPressed = false;
                        break;

                    case KeyEvent.VK_UP:
                        upPressed = false;
                        break;

                    case KeyEvent.VK_DOWN:
                        downPressed = false;
                        break;

                    case KeyEvent.VK_X:
                        xPressed = false;

                    default:
                        break;
                }
            }
        });

    }

    public void loop(){
        while (true){
            try {
                Thread.sleep(1);

                render();

                run();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void run(){

        if(backGroundY <= 0){
            backGroundY ++;
        }
        int dx = 0;
        int dy = 0;

        if (rightPressed){
            dx += 5;
        }
        if (leftPressed){
            dx -= 5;
        }
        if (downPressed){
            dy += 5;
        }
        if (upPressed){
            dy -= 5;
        }

        if (xPressed){
            player.castSpell(playerSpells);
        }

        player.cooldown();

        player.move(dx, dy);

        for (PlayerSpell playerSpell : playerSpells
                ) {
            playerSpell.move();
        }
    }

    private void render() {
        backBufferGraphic2D.setColor(Color.BLACK);
        backBufferGraphic2D.fillRect(0,0,this.getWidth(),this.getHeight());

        backBufferGraphic2D.drawImage(background, 0, backGroundY, null);

        player.render(backBufferGraphic2D);

        for (PlayerSpell playerSpell : playerSpells
             ) {
            playerSpell.render(backBufferGraphic2D);
        }

        Graphics2D g2d = (Graphics2D)this.getGraphics();

        g2d.drawImage(backBufferImage,0,0,null);
    }

    private void loadImage() {

            background = Utils.loadAssetsImage("background/0.png");

    }

    private void setUpWindow() {
        this.setSize(800, 800);

        this.setResizable(false);
        this.setTitle("Touhou - remade by SNOW");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //
                System.exit(0);
            }
        });
    }


}
