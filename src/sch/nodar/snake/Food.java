package sch.nodar.snake;

import java.awt.*;

public class Food extends Entity {
    public Food(Level level, int x, int y) {
        super(level, x, y);
    }

    @Override
    public String getName() {
        return "F";
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
