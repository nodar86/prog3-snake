package sch.nodar.snake.entity;

import sch.nodar.snake.Level;
import sch.nodar.snake.Position;

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

    public PositionedEntity(Level level, int x, int y){
        super(level);
        this.position = new Position(x, y);
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
