package sch.nodar.snake;

import sch.nodar.snake.entity.*;

import java.awt.*;
import java.util.HashMap;

/**
 * Class for storing level data.
 * It stores the level layout as well as rendering information.
 */
public class Level {

    private static final int DEFAULT_WIDTH = 40;
    private static final int DEFAULT_HEIGHT = 30;

    private HashMap<Position, PositionedEntity> levelData;
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

        int minTileSize = Integer.min(screenWidth / width, screenHeight / height);
        tileHeight = tileWidth = minTileSize;

        levelData = new HashMap<>();

        for(int i = 0; i < 5; ++i)
            new WallEntity(this, getFreePosition());
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
     * @param positionedEntity the entity that we register
     */
    public void registerEntity(PositionedEntity positionedEntity){
        if(levelData.containsKey(positionedEntity.getPosition()))
            levelData.remove(positionedEntity.getPosition()).notifyRemoval();
        levelData.put(positionedEntity.getPosition(), positionedEntity);
    }

    public void removeEntity(Position position){
        levelData.remove(position).getName();
    }

    /**
     * Returns the entity at the given position.
     * @param position The position of the polled entity.
     * @return The entity at position.
     */
    public PositionedEntity getEntityAt(Position position){
        return levelData.get(position);
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
        } while (levelData.containsKey(position));
        return position;
    }

    /**
     * Draws all the elements of the level on the given Graphics element.
     * @param graphics The Graphics element.
     */
    public void drawAll(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawRect(0, 0, width*tileWidth-1, height*tileHeight-1);
        levelData.forEach(((position, positionedEntity) -> {
            if(positionedEntity instanceof Drawable)
                ((Drawable) positionedEntity).draw(graphics);
        }));
    }
}
