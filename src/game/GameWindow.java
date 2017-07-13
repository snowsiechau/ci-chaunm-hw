package game;

import game.enemies.Enemy;
import game.players.Player;
import game.players.PlayerSpell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static sun.misc.PostVMInitHook.run;

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

    private int delaySpell, delayEnemiesGreen, delayEnemiesRed;

    public GameWindow(){

        setUpWindow();
        loadImage();


        player.x = background.getWidth() / 2;
        player.y = this.getHeight() - 100;

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
            if (player.x < background.getWidth() - 30){
                dx += 5;
            }
        }
        if (leftPressed){
            if (player.x > 5){
                dx -= 5;
            }
        }
        if (downPressed){
            if (player.y < 720 ){
                dy += 5;
            }
        }
        if (upPressed){
            if (player.y > 30 ){
                dy -= 5;
            }
        }

        if (delaySpell > 20) {
            if (xPressed) {
                PlayerSpell playerSpell = new PlayerSpell();

                playerSpell.x = player.x + 5;
                playerSpell.y = player.y - 10;

                playerSpell.image = Utils.loadAssetsImage("player-bullets/a/1.png");

                playerSpells.add(playerSpell);

                delaySpell = 0;
            }
        }else {
            delaySpell++;
        }

        //Enemies

        if (delayEnemiesGreen > 20){
            Enemy enemy = new Enemy();

            enemy.x = (int) (Math.random()* (background.getWidth()-15) );
            enemy.y = 0;

            enemy.imageGreen = Utils.loadAssetsImage("enemies/bullets/green.png");

            enemies.add(enemy);

            delayEnemiesGreen = 0;

        }else {
            delayEnemiesGreen++;
        }




        // Move
        for (Enemy enemy : enemies
             ) {
            enemy.move();
        }

        player.move(dx,dy);

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

        for (Enemy enemy: enemies
             ) {
            enemy.render(backBufferGraphic2D);
        }

        for (PlayerSpell playerSpell : playerSpells
             ) {
            playerSpell.render(backBufferGraphic2D);
        }

        Graphics2D g2d = (Graphics2D)this.getGraphics();

        g2d.drawImage(backBufferImage,0,0,null);
    }

    private void loadImage() {

            background = Utils.loadAssetsImage("background/0.png");
            player.image = Utils.loadAssetsImage("players/straight/0.png");

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
