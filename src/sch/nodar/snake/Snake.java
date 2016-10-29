package sch.nodar.snake;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Snake extends Entity {

    private LinkedList<SnakeBody> body;
    private Direction direction;
    private int score;
    private boolean moved;

    public Snake(Level level) {
        this.position = new Position(0, 0);
        this.level = level;

        level.registerEntity(this);

        body = new LinkedList<>();
        score = 0;
        direction = Direction.DOWN;
    }

    public void keyPressed(KeyEvent e){
        if(!moved) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_W:
                    if(direction != Direction.DOWN)
                        direction = Direction.UP;
                    break;
                case KeyEvent.VK_A:
                    if(direction != Direction.RIGHT)
                        direction = Direction.LEFT;
                    break;
                case KeyEvent.VK_S:
                    if(direction != Direction.UP)
                        direction = Direction.DOWN;
                    break;
                case KeyEvent.VK_D:
                    if(direction != Direction.LEFT)
                        direction = Direction.RIGHT;
                    break;
            }
        }
    }

    @Override
    public void tick() {
        level.registerEntity(new NullEntity(level, position));
        switch (direction){
            case UP:
                position.y--;
                break;
            case DOWN:
                position.y++;
                break;
            case LEFT:
                position.x--;
                break;
            case RIGHT:
                position.x++;
                break;
        }
        level.registerEntity(this);
        moved = false;
    }

    @Override
    public void draw(Graphics graphics){
        graphics.setColor(Color.RED);
        graphics.fillOval(getDrawPosition().x, getDrawPosition().y, level.getTileWidth(), level.getTileHeight());
    }

    @Override
    public String getName() {
        return "S";
    }
}
