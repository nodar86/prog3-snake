package sch.nodar.gameengine;

import java.awt.*;

/**
 * Interface for Objects that can be drawn via the drawAll(Graphics) method.
 */
public interface Drawable {
    /**
     * Draws the objects to given graphics interface.
     * @param graphics the graphics interface where the object will be drawn.
     */
    void draw(Graphics graphics);
}
