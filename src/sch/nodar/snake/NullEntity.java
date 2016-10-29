package sch.nodar.snake;

import java.awt.*;

public class NullEntity extends Entity {
    public NullEntity(Level level, Position position) {
        super(level, position);
    }

    public NullEntity(Level level, int x, int y) {
        super(level, x, y);
    }

    @Override
    public String getName() {
        return " ";
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics graphics) {

    }
}
