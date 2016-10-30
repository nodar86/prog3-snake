package sch.nodar.snake;

/**
 * Class for storing the game settings. As of now it only stores the tickTime, but it can be expanded.
 */
public class Settings {
    public int tickTime;

    /**
     * Constructs new Settings object with give tickTime
     * @param tickTime The time between two ticks in milliseconds.
     */
    public Settings(int tickTime) {
        this.tickTime = tickTime;
    }

    /**
     * Constructs a new Settings object with tickTime = 90ms.
     */
    public Settings() {
        this(90);
    }
}
