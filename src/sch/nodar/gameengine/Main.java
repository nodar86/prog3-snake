package sch.nodar.gameengine;

import sch.nodar.gameengine.game.LevelEditorGame;
import sch.nodar.gameengine.game.SnakeGame;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

/**
 * <h1>Programozás alapjai nagy házi feladat</h1>
 * Kígyós játék / Snake.
 *
 * This is actually a full-blown 2D grid-based SnakeGame Engine.
 * It can play any snakeGame as long as you provide the correct entities,
 * that perform the tick-based gamelogic.
 *
 * Initial entity setup is done in SnakeGame.java I recommend you start from there when
 * exploring the code, but I will maybe write a guide to allow you to create games
 * with this. This was made as a school project so it's nothing professional.
 *
 * @author Károlyi Péter Márton
 */
public class Main {

    public static SnakeGame snakeGame = new SnakeGame();
    public static LevelEditorGame levelEditor = new LevelEditorGame();
    private static JFrame mainFrame = new JFrame("Snake");
    private static MenuPanel menuPanel = new MenuPanel();

    /**
     * The main function constructs a JFrame then adds the snakeGame.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        mainFrame.setLayout(new BorderLayout());

//        mainFrame.add(menuPanel, BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        playGame();
    }

    /**
     * Plays the snakeGame.
     */
    static void playGame(){

        ScoreboardPanel scoreboardPanel = new ScoreboardPanel();
        mainFrame.add(scoreboardPanel, BorderLayout.NORTH);

        snakeGame.addPanel(scoreboardPanel);
        mainFrame.add(snakeGame, BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setVisible(true);

        try{
            snakeGame.play();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
