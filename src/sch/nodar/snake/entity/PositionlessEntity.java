package sch.nodar.snake.entity;

import sch.nodar.snake.Level;

public abstract class PositionlessEntity extends Entity {

    PositionlessEntity(Level level){
        super(level);
        level.registerEntity(this);
    }
}
