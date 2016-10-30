package sch.nodar.snake.entity;

import sch.nodar.snake.Level;
import sch.nodar.snake.Position;
import sch.nodar.snake.entity.Entity;

import java.awt.*;

public class NullEntity extends PositionedEntity {

    /**
     * Constructs a new null with the given level and position.
     * It also registers the entity with the level.
     * @param level The level on which the entity will live.
     * @param position The position of the entity.
     */
    public NullEntity(Level level, Position position) {
        super(level, position);
    }

    /**
     * Constructs an null with given level and a new position based on coordinates.
     * @param level The level on which the entity will live.
     * @param x The x coordinate for the position.
     * @param y The y coordinate for the position.
     */
    public NullEntity(Level level, int x, int y) {
        super(level, x, y);
    }

    @Override
    public String getName() {
        return "null";
    }
}
