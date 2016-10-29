package sch.nodar.snake.entity;

import sch.nodar.snake.Level;
import sch.nodar.snake.Position;

import java.awt.*;

public class SnakeBody extends Entity {

    public SnakeBody(){

    }

    public SnakeBody(Level level, Position position){
        super(level, position);
    }

    @Override
    public void tick() {

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
