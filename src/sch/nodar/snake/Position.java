package sch.nodar.snake;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position clone(){
        return new Position(x, y);
    }

   public Position(){
        x = 0;
        y = 0;
    }
}
