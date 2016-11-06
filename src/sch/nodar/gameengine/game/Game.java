package sch.nodar.gameengine.game;


import sch.nodar.gameengine.Level;
import sch.nodar.gameengine.Scoreable;
import sch.nodar.gameengine.ScoreboardPanel;
import sch.nodar.gameengine.Tickable;
import sch.nodar.gameengine.entity.ControllableEntity;
import sch.nodar.gameengine.entity.Entity;
import sch.nodar.gameengine.settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public abstract class Game extends Canvas implements KeyListener {

    protected static final int SCREEN_WIDTH = 800;
    protected static final int SCREEN_HEIGHT = 600;

    protected Level level;
    protected ArrayList<Tickable> tickables = new ArrayList<>();;
    protected ArrayList<ControllableEntity> controllableEntities = new ArrayList<>();;
    protected Settings settings;

    protected boolean playing;
    protected boolean gameOver;

    public Game(){
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setBackground(Color.BLACK);
        addKeyListener(this);
    }

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


    public void addEntity(Entity entity){
        if(entity instanceof Tickable)
            tickables.add((Tickable)entity);
        if(entity instanceof ControllableEntity)
            controllableEntities.add((ControllableEntity)entity);
    }

    public void addPanel(JPanel panel){
        if(panel instanceof ScoreboardPanel){
            controllableEntities.forEach( controllableEntity -> {
                if (controllableEntity instanceof Scoreable)
                    ((ScoreboardPanel) panel).registerScoreable((Scoreable)controllableEntity);
            });
        }
        if(panel instanceof Tickable)
            tickables.add((Tickable)panel);
    }

    /**
     * Called if the Game is over.
     */
    public void gameOver(){
        playing = false;
        gameOver = true;
    }

    /**
     * The main Game loop.
     * It tick entities that need ticking then repaints the screen.
     * The tickTime is read from the settings.
     * @throws InterruptedException if the sleep is interrupted it throws this. This should not happen.
     */
    public void play() throws InterruptedException{
        playing = true;
        gameOver = false;
        while(playing){
            sleep(settings.getTickTime());
            tickables.forEach(Tickable::tick);
            this.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for(Entity entity: controllableEntities){
            ControllableEntity controllableEntity = (ControllableEntity)entity;
            controllableEntity.getKeys().forEach( key -> {
                if (key == e.getKeyCode()) {
                    controllableEntity.keyPressed(e);
                }
            });
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
