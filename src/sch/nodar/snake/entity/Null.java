package sch.nodar.snake.entity;

import sch.nodar.snake.Level;
import sch.nodar.snake.Position;
import sch.nodar.snake.entity.Entity;

import java.awt.*;

public class Null extends Entity {
    public Null(Level level, Position position) {
        super(level, position);
    }

    public Null(Level level, int x, int y) {
        super(level, x, y);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics graphics) {

    }
}
