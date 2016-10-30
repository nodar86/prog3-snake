package sch.nodar.snake;

import jdk.nashorn.internal.parser.JSONParser;
import sch.nodar.snake.entity.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Class for storing level data.
 * It stores the level layout as well as rendering information.
 */
public class Level {

    private static final int DEFAULT_WIDTH = 30;
    private static final int DEFAULT_HEIGHT = 30;

    private Entity[][] levelData;
    private ArrayList<PositionedEntity> drawData;
    private int width, height;
    private int tileWidth;
    private int tileHeight;

    /**
     * Constructs a level for the given screen size with default level size (40x30).
     * @param screenWidth The width of the containing screen.
     * @param screenHeight The height of the containing screen.
     */
    public Level(int screenWidth, int screenHeight){
        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;

        tileWidth = screenWidth / width;
        tileHeight = screenHeight / height;

        int minTileSize = Integer.min(tileHeight, tileWidth);
        tileHeight = minTileSize;
        tileWidth = minTileSize;

        levelData = new Entity[width][height];
        drawData = new ArrayList<>();

        for(int i = 0; i < width; ++i){
            for(int j = 0; j < height; ++j){
                levelData[i][j] = new NullEntity(this, i, j);
            }
        }

        registerEntity(new WallEntity(this, 5, 5));
    }

    /**
     * Constructs a level based on a level file.
     * @param fileName The level file.
     * @param screenWidth The width of the containing screen.
     * @param screenHeight The height of the containing screen.
     */
    public Level(String fileName, int screenWidth, int screenHeight){
    }

    /**
     * Saves the level to given file.
     * @param filename The level file.
     */
    public void saveLevel(String filename){
    }

    /**
     * Registers a new entity on the level.
     * It saves the entity to the level layout and if it needs drawing to the rendering data.
     * @param entity the entity that we register
     */
    public void registerEntity(Entity entity){
        if(entity instanceof PositionedEntity) {
            PositionedEntity positionedEntity = (PositionedEntity)entity;
            if(levelData[positionedEntity.getPosition().x][positionedEntity.getPosition().y] != null)
                levelData[positionedEntity.getPosition().x][positionedEntity.getPosition().y].notifyRemoval();
            levelData[positionedEntity.getPosition().x][positionedEntity.getPosition().y] = entity;
            for (int i = 0; i < drawData.size(); ++i) {
                if (drawData.get(i).getPosition().equals(positionedEntity.getPosition())) {
                    drawData.remove(i);
                }
            }
            if (entity instanceof Drawable) {
                drawData.add(positionedEntity);
            }
        }
    }

    /**
     * Returns the entity at the given position.
     * @param position The position of the polled entity.
     * @return The entity at position.
     */
    public Entity getEntityAt(Position position){
        return levelData[position.x][position.y];
    }

    /**
     * Gets the width of the level.
     * @return The width of the level.
     */
    public int getWidth(){
        return width;
    }

    /**
     * Gets the height of the level.
     * @return The height of the level.
     */
    public int getHeight(){
        return height;
    }

    /**
     * Gets the width of a tile in pixels.
     * @return The width of a single tile in pixels.
     */
    public int getTileWidth(){
        return tileWidth;
    }

    /**
     * Gets the height of a tile in pixels.
     * @return The height of a single tile in pixels.
     */
    public int getTileHeight(){
        return tileHeight;
    }

    /**
     * Returns a random free position on the level.
     * Free meaning it contains a NullEntity.
     * @return A random free position.
     */
    public Position getFreePosition(){
        Position position = new Position();
        do{
            position.x = (int)(Math.random() * 1000) % width;
            position.y = (int)(Math.random() * 1000) % height;
        } while (!(levelData[position.x][position.y] instanceof NullEntity));
        return position;
    }

    /**
     * Draws all the elements of the level on the given Graphics element.
     * @param graphics The Graphics element.
     */
    public void drawAll(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawRect(0, 0, width*tileWidth-1, height*tileHeight-1);
        for(Entity entity: drawData){
            ((Drawable)entity).draw(graphics);
        }
    }
}
