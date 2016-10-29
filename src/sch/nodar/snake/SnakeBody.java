package sch.nodar.snake;

import java.awt.*;

public class SnakeBody extends Entity{
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
        return "B";
    }
}
