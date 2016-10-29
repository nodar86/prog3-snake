package sch.nodar.snake;

import java.awt.*;

public class Wall extends Entity {
    public Wall(Level level, int x, int y) {
        super(level, x, y);
    }

    @Override
    public String getName() {
        return "W";
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(getDrawPosition().x, getDrawPosition().y, level.getTileWidth(), level.getTileHeight());
    }
}
