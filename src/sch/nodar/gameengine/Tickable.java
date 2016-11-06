package sch.nodar.gameengine;

/**
 * Interface for Objects that can tick via the tick() method.
 */
public interface Tickable {
    /**
     * The method that will be called when the object can tick.
     */
    void tick();
}
