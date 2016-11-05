package sch.nodar.snake.entity;

import sch.nodar.snake.Level;
import sch.nodar.snake.Position;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ControllableEntity extends PositionedEntity {
    HashMap<String, Integer> keys;

    /**
     * Constructs a new entity with the given level and position.
     * It also registers the entity with the level.
     * @param level The level on which the entity will live.
     * @param position The position of the entity.
     */
    ControllableEntity(Level level, Position position){
        super(level, position);
        this.keys = new HashMap<>();
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
