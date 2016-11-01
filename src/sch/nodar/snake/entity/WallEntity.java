package sch.nodar.snake.entity;

import sch.nodar.snake.Drawable;
import sch.nodar.snake.Level;
import sch.nodar.snake.Position;
import sch.nodar.snake.entity.Entity;

import java.awt.*;

/**
 * Entity wall that serves as a barrier in the game.
 */
public class WallEntity extends PositionedEntity implements Drawable {
    /**
     * Constructs a wall with given level and a new position based on coordinates.
     * @param level The level on which the entity will live.
     * @param position The position of the entity
     */
    public WallEntity(Level level, Position position) {
        super(level, position);
    }

    /**
     * Constructs a wall with given level and a new position based on coordinates.
     * @param level The level on which the entity will live.
     * @param x The x coordinate for the position.
     * @param y The y coordinate for the position.
     */
    public WallEntity(Level level, int x, int y) {
        this(level, new Position(x, y));
    }

    @Override
    public String getName() {
        return "wall";
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(getDrawPosition().x, getDrawPosition().y, level.getTileWidth(), level.getTileHeight());
    }
}
