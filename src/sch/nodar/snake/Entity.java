package sch.nodar.snake;

public abstract class Entity implements Drawable, Tickable {

    protected Position position;
    protected Level level;

    public Entity(){
        position = new Position();
    }

    public Entity(Level level, Position position){
        this.level = level;
        this.position = position;
    }

    public Entity(Level level, int x, int y){
        this.level = level;
        this.position = new Position(x, y);
    }

    public Position getPosition(){
        return position;
    }

    public Position getDrawPosition(){
        return new Position(position.x * level.getTileWidth(), position.y * level.getTileHeight());
    }

    public Level getLevel(){
        return level;
    }

    public abstract String getName();

}
