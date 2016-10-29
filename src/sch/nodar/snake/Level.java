package sch.nodar.snake;

import sch.nodar.snake.entity.*;

import java.awt.*;

public class Level implements Drawable {

    private static final int DEFAULT_WIDTH = 40;
    private static final int DEFAULT_HEIGHT = 30;

    private Entity[][] levelData;
    private int width, height;
    private int tileWidth;
    private int tileHeight;

    public Level(int screenWidth, int screenHeight){
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;

        tileWidth = screenWidth / width;
        tileHeight = screenHeight / height;

        levelData = new Entity[width][height];
        for(int i = 0; i < width; ++i){
            for(int j = 0; j < height; ++j){
                levelData[i][j] = new Null(this, i, j);
            }
        }

        levelData[5][5] = new Wall(this, 5, 5);
        levelData[5][6] = new Wall(this, 5, 6);
    }

    public Level(String filename){
    }

    public void saveLevel(String filename){
    }

    public void registerEntity(Entity entity){
//        System.out.println("registering entity " + entity.getName() + " at: " + entity.getPosition().x + " " + entity.getPosition().y);
        levelData[entity.getPosition().x][entity.getPosition().y] = entity;
    }

    public Entity getEntityAt(Position position){
        return levelData[position.x][position.y];
    }

    public Entity getEntityAt(int x, int y){
        return levelData[x][y];
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getTileWidth(){
        return tileWidth;
    }

    public int getTileHeight(){
        return tileHeight;
    }

    public Position getFreePosition(){
        Position position = new Position();
        do{
            position.x = (int)(Math.random() * 1000) % width;
            position.y = (int)(Math.random() * 1000) % height;
        } while (!(levelData[position.x][position.y] instanceof Null));
        return position;
    }

    public void addFood(){
        Food food = new Food(this, getFreePosition());
    }

    @Override
    public void draw(Graphics graphics) {
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                levelData[i][j].draw(graphics);
            }
        }
    }
}
