package sch.nodar.snake;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    public void paint(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        level.draw(graphics2D);
    }

    public Game(){
        level = new Level(SCREEN_WIDTH, SCREEN_HEIGHT);
        settings = new Settings(1000);

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
        while(playing){
            snake.tick();
            this.repaint();
            sleep(settings.tickTime);
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
