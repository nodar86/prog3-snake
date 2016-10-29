package sch.nodar.snake.entity;

import sch.nodar.snake.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Snake extends Entity {

    private LinkedList<SnakeBody> body;
    private Direction direction;
    private int score;
    private boolean growing;

    public Snake(Level level) {
        super(level, new Position(10, 10));

        body = new LinkedList<>();
        body.addLast(new SnakeBody(level, new Position(10, 9)));
        body.addLast(new SnakeBody(level, new Position(10, 8)));
        score = 0;
        growing = false;
        direction = Direction.DOWN;
    }

    public void move(){
        body.addFirst(new SnakeBody(level, position.clone()));
        if(!growing) {
            new Null(level, body.removeLast().getPosition());
        } else {
            growing = false;
        }

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
    }

    public void keyPressed(KeyEvent e){
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

    @Override
    public void tick() {
        move();
        switch (level.getEntityAt(position).getName()){
            case "food":
                growing = true;
                level.addFood();
                break;
        }
        level.registerEntity(this);
    }

    @Override
    public void draw(Graphics graphics){
        graphics.setColor(Color.RED);
        graphics.fillOval(getDrawPosition().x, getDrawPosition().y, level.getTileWidth(), level.getTileHeight());
    }

    @Override
    public String getName() {
        return "head";
    }
}
