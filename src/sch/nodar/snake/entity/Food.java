package sch.nodar.snake.entity;

import sch.nodar.snake.Level;
import sch.nodar.snake.Position;

import java.awt.*;

public class Food extends Entity {
    public Food(Level level, int x, int y) {
        super(level, x, y);
    }

    public Food(Level level, Position position){
        super(level, position);
    }

    @Override
    public String getName() {
        return "food";
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(getDrawPosition().x, getDrawPosition().y, level.getTileWidth(), level.getTileHeight());
    }

    @Override
    public void tick() {

    }
}
