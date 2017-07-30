package game;

import bases.Contraints;
import bases.GameObjects;
import game.enemies.Enemy;
import game.enemies.EnemySpawner;
import game.inputs.InputManager;
import game.players.Player;
import game.scenes.Background;
import game.scenes.Setting;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javafx.embed.swing.JFXPanel;

/**
 * Created by SNOW on 7/9/2017.
 */
public class GameWindow extends JFrame{

    BufferedImage backBufferImage;
    Graphics2D backBufferGraphic2D;

    InputManager inputManager = new InputManager();

    Background background;

    final JFXPanel jfxPanel = new JFXPanel();

    public GameWindow(){

        setUpWindow();

        addBackground();

        addPlayer();

        addEnemySpawn();

        backBufferImage = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphic2D = (Graphics2D) backBufferImage.getGraphics();

        setupInput();

        this.setVisible(true);
    }

    private void addEnemySpawn() {
        GameObjects.add(new EnemySpawner());
    }

    private void addBackground() {
        background = new Background();

        background.position.y = this.getHeight();

        GameObjects.add(background);

    }

    private void addPlayer() {
        Player player = new Player();

        player.setContraints(new Contraints(0, this.getHeight(), 0, Setting.WIDTH_BACKGROUND));
        player.setInputManager(inputManager);
        player.position.set(Setting.WIDTH_BACKGROUND / 2 , this.getHeight() - 50);

        GameObjects.add(player);
    }

    private void setupInput() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
               inputManager.KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManager.KeyReleased(e);
            }
        });

    }

    long lastUpdateTime;

    public void loop(){
        while (true){
          long currentTime = System.currentTimeMillis();

          if (currentTime - lastUpdateTime > 17){
              lastUpdateTime = currentTime;
              render();
              run();
          }
        }
    }

    private void run() {

        GameObjects.runAll();

    }

    private void render() {
        backBufferGraphic2D.setColor(Color.BLACK);
        backBufferGraphic2D.fillRect(0,0,this.getWidth(),this.getHeight());

        GameObjects.renderAll(backBufferGraphic2D);

        Graphics2D g2d = (Graphics2D)this.getGraphics();
        g2d.drawImage(backBufferImage,0,0,null);
    }


    private void setUpWindow() {
        this.setSize(Setting.WIDTH_WINDOW, Setting.HEIGHT_WINDOW);

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
