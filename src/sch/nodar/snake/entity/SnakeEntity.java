package sch.nodar.snake.entity;

import sch.nodar.snake.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 * Snake entity. It contains the whole body of the snake.
 */
public class SnakeEntity extends ControllableEntity implements Drawable, Tickable, Scorable {

    private Color headColor;

    private LinkedList<SnakeBodyEntity> body;
    private Direction direction;
    private int score = 0;

    private int ID;
    private static int nextID = 0;

    private int growCount = 0;
    private boolean moved = true;
    private boolean alive = true;

    /**
     * Constructs an entity with given level.
     * @param level The level on which the entity will live.
     * @param headColor The color of the head of this snake.
     * @param upKey The input on which the snake should go up.
     * @param downKey The input on which the snake should go down.
     * @param leftKey The input on which the snake should go left.
     * @param rightKey The input on which the snake should go right.
     */
    public SnakeEntity(Level level, Color headColor, int initialSize,
                       int upKey, int downKey, int leftKey, int rightKey) {
        super(level, level.getFreePosition());
        this.headColor = headColor;
        this.growCount = initialSize;

        ID = nextID++;

        keys.put("upKey", upKey);
        keys.put("downKey", downKey);
        keys.put("leftKey", leftKey);
        keys.put("rightKey", rightKey);

        body = new LinkedList<>();
        direction = Direction.DOWN;
    }

    /**
     * Moves the snake in it's current direction.
     */
    public void move(){
        body.addFirst(new SnakeBodyEntity(level, position.clone()));
        if(growCount == 0) {
            new NullEntity(level, body.removeLast().getPosition());
        } else {
            growCount--;
        }

        switch (direction){
            case UP:
                if(0 < position.y)
                    position.y--;
                else
                    position.y = level.getHeight()-1;
                break;
            case DOWN:
                if(position.y < level.getHeight()-1)
                    position.y++;
                else
                    position.y = 0;
                break;
            case LEFT:
                if(0 < position.x)
                    position.x--;
                else
                    position.x = level.getWidth()-1;
                break;
            case RIGHT:
                if(position.x < level.getWidth()-1)
                    position.x++;
                else
                    position.x = 0;
                break;
        }
        moved = true;
    }

    /**
     * Check for collision and acts accordingly
     */
    private void checkCollision(){
        switch (level.getEntityAt(position).getName()){
            case "food":
                growCount++;
                score++;
                break;
            case "wall":
            case "body":
                alive = false;
                Main.game.gameOver();
                break;
        }
    }

    @Override
    public int getID(){
        return ID;
    }

    @Override
    public int getScore(){
        return score;
    }

    @Override
    public void tick() {
        move();
        checkCollision();
        level.registerEntity(this);
    }

    @Override
    public void draw(Graphics graphics){
        graphics.setColor(headColor);
        graphics.fillOval(getDrawPosition().x, getDrawPosition().y, level.getTileWidth(), level.getTileHeight());
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(moved) {
            int inputKeyCode = e.getKeyCode();
            if(inputKeyCode == keys.get("upKey")) {
                if (direction != Direction.DOWN)
                    direction = Direction.UP;
            }
            if(inputKeyCode == keys.get("leftKey")) {
                if (direction != Direction.RIGHT)
                    direction = Direction.LEFT;
            }
            if(inputKeyCode == keys.get("downKey")) {
                if (direction != Direction.UP)
                    direction = Direction.DOWN;
            }
            if(inputKeyCode == keys.get("rightKey")) {
                if (direction != Direction.LEFT)
                    direction = Direction.RIGHT;
            }
        }
        moved = false;
    }

    @Override
    public String getName() {
        return "head";
    }
}
