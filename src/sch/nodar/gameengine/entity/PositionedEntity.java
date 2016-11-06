package sch.nodar.gameengine.entity;

import sch.nodar.gameengine.Level;
import sch.nodar.gameengine.Position;

/**
 * Entities
 */
public abstract class PositionedEntity extends Entity {

    protected Position position;

    public PositionedEntity(Level level, Position position){
        super(level);
        this.position = position;
        level.registerEntity(this);
    }

    /**
     * Returns the position of the entity.
     * @return The position of the entity.
     */
    public Position getPosition(){
        return position;
    }

    /**
     * Returns the drawing position of the entity.
     * That is the position where the entity should be drawn.
     * @return The drawing positions of the entity.
     */
    public Position getDrawPosition(){
        return new Position(position.x * level.getTileWidth(), position.y * level.getTileHeight());
    }
}
