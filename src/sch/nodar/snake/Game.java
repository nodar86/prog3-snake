package sch.nodar.snake;

import sch.nodar.snake.Level;
import sch.nodar.snake.Settings;
import sch.nodar.snake.entity.Snake;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import static java.lang.Thread.sleep;

public class Game extends Canvas implements KeyListener {

    // Constants
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    private Level level;
    private Snake snake;
    private Settings settings;

    private boolean playing;

    @Override
    public void update(Graphics graphics){
        Image img = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = (Graphics2D) img.getGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, img.getWidth(null), img.getHeight(null));
        level.draw(graphics2D);
        graphics.drawImage(img, 0, 0, null);
    }

    public Game(){
        level = new Level(SCREEN_WIDTH, SCREEN_HEIGHT);
        settings = new Settings(250);

        snake = new Snake(level);

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setBackground(Color.BLACK);
        addKeyListener(this);
    }

    private void setPlaying(boolean playing){
        this.playing = playing;
    }

    public void play() throws InterruptedException{
        playing = true;
        level.addFood();
        while(playing){
            sleep(settings.tickTime);
            snake.tick();
            this.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setPlaying(false);
        } else {
            snake.keyPressed(e);
        }
    }

    // Unused KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
