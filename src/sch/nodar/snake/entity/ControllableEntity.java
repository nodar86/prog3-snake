package sch.nodar.snake.entity;

import sch.nodar.snake.Level;
import sch.nodar.snake.Position;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class ControllableEntity extends PositionedEntity {
    LinkedHashMap<String, Integer> keys;

    /**
     * Constructs a new entity with the given level and position.
     * It also registers the entity with the level.
     * @param level The level on which the entity will live.
     * @param position The position of the entity.
     */
    public ControllableEntity(Level level, Position position){
        super(level, position);
        this.keys = new LinkedHashMap<>();
    }

    /**
     * Constructs an entity with given level and a new position based on coordinates.
     * @param level The level on which the entity will live.
     * @param x The x coordinate for the position.
     * @param y The y coordinate for the position.
     */
    public ControllableEntity(Level level, int x, int y){
        this(level, new Position(x, y));
    }

    /**
     * Returns an ArrayList of the contained keys.
     * @return ArrayList of the control keys.
     */
    public ArrayList<Integer> getKeys(){
        ArrayList<Integer> keyArray = new ArrayList<>();
        keyArray.addAll(keys.values());
        return keyArray;
    }

    public abstract void keyPressed(KeyEvent e);
}
