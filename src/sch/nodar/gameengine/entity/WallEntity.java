package sch.nodar.gameengine.entity;

import sch.nodar.gameengine.Drawable;
import sch.nodar.gameengine.Level;
import sch.nodar.gameengine.Position;

import java.awt.*;

/**
 * Entity wall that serves as a barrier in the snakeGame.
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
