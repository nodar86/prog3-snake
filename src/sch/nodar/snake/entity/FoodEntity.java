package sch.nodar.snake.entity;

import sch.nodar.snake.Drawable;
import sch.nodar.snake.Level;
import sch.nodar.snake.Position;

import java.awt.*;

/**
 * Entity food, the snake can eat this to grow.
 */
public class FoodEntity extends PositionedEntity implements Drawable {

    private FoodFactoryEntity parentFoodFactory;

    /**
     * Constructs a new food with the given level and position.
     * It also registers the entity with the level.
     * @param level The level on which the entity will live.
     * @param position The position of the entity.
     */
    public FoodEntity(Level level, Position position, FoodFactoryEntity parentFoodFactory){
        super(level, position);
        this.parentFoodFactory = parentFoodFactory;
    }

    /**
     * Constructs a new food with a new position based on coordinates.
     * @param level The level on which the entity will live.
     * @param x The x coordinate for the position.
     * @param y The y coordinate for the position.
     */
    public FoodEntity(Level level, int x, int y, FoodFactoryEntity parentFoodFactory) {
        this(level, new Position(x,y), parentFoodFactory);
    }

    @Override
    public void notifyRemoval() {
        parentFoodFactory.foodRemoved();
    }

    @Override
    public String getName() {
        return "food";
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(getDrawPosition().x, getDrawPosition().y, level.getTileWidth(), level.getTileHeight());
    }
}
