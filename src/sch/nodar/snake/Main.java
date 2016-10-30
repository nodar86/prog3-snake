package sch.nodar.snake;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>Programozás alapjai nagy házi feladat</h1>
 * Kígyós játék / Snake.
 *
 * This is actually a full-blown 2D grid-based Game Engine.
 * It can play any game as long as you provide the correct entities,
 * that perform the tick-based gamelogic.
 *
 * Initial entity setup is done in Game.java I recommend you start from there when
 * exploring the code, but I will maybe write a guide to allow you to create games
 * with this. This was made as a school project so it's nothing professional.
 *
 * @author Károlyi Péter Márton
 */
public class Main {

    public static Game game = new Game();

    /**
     * The main function constructs a JFrame then adds the game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Snake");

        mainFrame.setLayout(new BorderLayout());

        ScoreboardPanel scoreboardPanel = new ScoreboardPanel();
        mainFrame.add(scoreboardPanel, BorderLayout.NORTH);

        game.addPanel(scoreboardPanel);

        mainFrame.add(game, BorderLayout.CENTER);
        // TODO The menu currently doesn't work I don't know why.
//        mainFrame.add(new MenuPanel(), BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        playGame();
    }

    /**
     * Plays the game.
     */
    public static void playGame(){
        try {
            game.play();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
