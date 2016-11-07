package sch.nodar.gameengine.game;

import sch.nodar.gameengine.Level;
import sch.nodar.gameengine.entity.*;
import sch.nodar.gameengine.settings.SnakeSettings;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * The main SnakeGame class.
 * It extends Canvas to provide a drawing surface and implements KeyListener to accept keyboard inputs
 */
public class SnakeGame extends Game {

    private static final int SNAKE_INITIAL_SIZE = 5;

    /**
     * Constructs a new snakeGame with default screen size (800x600).
     */
    public SnakeGame(){
        super();
        addEntity(new FoodFactoryEntity(level));
    }

    public void reset(){
        super.reset();
        level = new Level("whatever", SCREEN_WIDTH, SCREEN_HEIGHT);
        settings = new SnakeSettings();

        addEntity(new SnakeEntity(level, Color.RED, SNAKE_INITIAL_SIZE,
                KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT));

        addEntity(new SnakeEntity(level, Color.GREEN, SNAKE_INITIAL_SIZE,
                KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D));

        addEntity(new FoodFactoryEntity(level));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
        controllableEntities.forEach(controllableEntity -> {
            if(!((SnakeEntity)controllableEntity).isAlive())
                timer.stop();
        });
    }

}
