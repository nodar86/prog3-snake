package sch.nodar.snake;

/**
 * Class for storing the positions of entities on the level grid.
 * Maybe it should be immutable? Perhaps not?
 */
public class Position {
    public int x;
    public int y;

    /**
     * Constructs a new Position with given coordinates
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new Positions at -1, -1
     */
    public Position(){
        this(-1, -1);
    }

    @Override
    public Position clone() {
        return new Position(x, y);
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof Position) {
            Position position = (Position)that;
            return (this.x == position.x && this.y == position.y);
        } else
            return false;
    }

    @Override
    public int hashCode(){
        return (17 * 31 + x) * 31 + y;
    }
}
