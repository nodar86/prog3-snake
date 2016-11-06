package sch.nodar.gameengine.settings;

/**
 * Class for storing the snakeGame settings. As of now it only stores the tickTime, but it can be expanded.
 */
public class SnakeSettings extends Settings{
    /**
     * Constructs new SnakeSettings object with give tickTime
     * @param tickTime The time between two ticks in milliseconds.
     */
    public SnakeSettings(int tickTime) {
        super(tickTime);
    }

    /**
     * Constructs a new SnakeSettings object with tickTime = 90ms.
     */
    public SnakeSettings() {
        this(90);
    }
}
