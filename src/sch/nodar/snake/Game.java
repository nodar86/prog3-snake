package sch.nodar.snake;

import sch.nodar.snake.entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * The main Game class.
 * It extends Canvas to provide a drawing surface and implements KeyListener to accept keyboard inputs
 */
public class Game extends Canvas implements KeyListener {

    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int SNAKE_INITIAL_SIZE = 5;

    private Level level;
    private ArrayList<Tickable> tickables;
    private ArrayList<ControllableEntity> controllableEntities;
    private Settings settings;

    private boolean playing;
    private boolean gameOver;

    @Override
    public void update(Graphics graphics){
        Image bufferedImage = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, bufferedImage.getWidth(null), bufferedImage.getHeight(null));
        level.drawAll(graphics2D);
        graphics.drawImage(bufferedImage, 0, 0, null);
    }

    /**
     * Constructs a new game with default screen size (800x600).
     */
    public Game(){
        level = new Level(SCREEN_WIDTH, SCREEN_HEIGHT);
        settings = new Settings();

        tickables = new ArrayList<>();
        controllableEntities = new ArrayList<>();

        SnakeEntity snake1 = new SnakeEntity(level, Color.RED, SNAKE_INITIAL_SIZE,
                KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        addEntity(snake1);

        SnakeEntity snake2 = new SnakeEntity(level, Color.GREEN, SNAKE_INITIAL_SIZE,
                KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
        addEntity(snake2);

        FoodFactoryEntity foodFactory = new FoodFactoryEntity(level);
        addEntity(foodFactory);

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setBackground(Color.BLACK);
        addKeyListener(this);
    }

    private void addEntity(Entity entity){
        if(entity instanceof Tickable)
            tickables.add((Tickable)entity);
        if(entity instanceof ControllableEntity)
            controllableEntities.add((ControllableEntity)entity);
    }

    public void addPanel(JPanel panel){
        if(panel instanceof ScoreboardPanel){
            controllableEntities.forEach( controllableEntity -> {
                if (controllableEntity instanceof Scorable)
                    ((ScoreboardPanel) panel).registerScorable((Scorable)controllableEntity);
            });
        }
        if(panel instanceof Tickable)
            tickables.add((Tickable)panel);
    }

    /**
     * Called if the game is over.
     */
    public void gameOver(){
        playing = false;
        gameOver = true;
    }

    /**
     * The main game loop.
     * It tick entities that need ticking then repaints the screen.
     * The tickTime is read from the settings.
     * @throws InterruptedException if the sleep is interrupted it throws this. This should not happen.
     */
    public void play() throws InterruptedException{
        playing = true;
        gameOver = false;
        while(playing){
            sleep(settings.tickTime);
            tickables.forEach(Tickable::tick);
            this.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            playing = false;
        } else {
            for(Entity entity: controllableEntities){
                ControllableEntity controllableEntity = (ControllableEntity)entity;
                controllableEntity.getKeys().forEach( key -> {
                    if (key == e.getKeyCode()) {
                        controllableEntity.keyPressed(e);
                    }
                });
            }
        }
    }

    // Unused KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
