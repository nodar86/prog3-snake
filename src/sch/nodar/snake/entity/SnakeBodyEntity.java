package sch.nodar.snake.entity;

import sch.nodar.snake.Drawable;
import sch.nodar.snake.Level;
import sch.nodar.snake.Position;

import java.awt.*;

/**
 * The body entities of the snake.
 */
public class SnakeBodyEntity extends PositionedEntity implements Drawable {

    /**
     * Constructs a SnakeBody with given level and a new position based on coordinates.
     * @param level The level on which the entity will live.
     * @param position The position of the entity.
     */
    public SnakeBodyEntity(Level level, Position position){
        super(level, position);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillOval(getDrawPosition().x, getDrawPosition().y, level.getTileWidth(), level.getTileHeight());
    }

    @Override
    public String getName() {
        return "body";
    }
}
