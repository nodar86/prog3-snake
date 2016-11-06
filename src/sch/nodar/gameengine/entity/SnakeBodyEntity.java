package sch.nodar.gameengine.entity;

import sch.nodar.gameengine.Drawable;
import sch.nodar.gameengine.Level;
import sch.nodar.gameengine.Position;

import java.awt.*;

/**
 * The body entities of the gameengine.
 */
class SnakeBodyEntity extends PositionedEntity implements Drawable {

    /**
     * Constructs a SnakeBody with given level and a new position based on coordinates.
     * @param level The level on which the entity will live.
     * @param position The position of the entity.
     */
    SnakeBodyEntity(Level level, Position position){
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
