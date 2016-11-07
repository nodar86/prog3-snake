package sch.nodar.gameengine;

import sch.nodar.gameengine.game.LevelEditorGame;
import sch.nodar.gameengine.game.SnakeGame;
import sch.nodar.gameengine.panels.EditorPanel;
import sch.nodar.gameengine.panels.MenuPanel;
import sch.nodar.gameengine.panels.ScoreboardPanel;

import javax.swing.*;
import java.awt.*;

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

    private static JFrame mainFrame = new JFrame("Snake");
    private static SnakeGame snakeGame = new SnakeGame();
    private static LevelEditorGame levelEditor = new LevelEditorGame();
    private static MenuPanel menuPanel = new MenuPanel();
    private static ScoreboardPanel scoreboardPanel = new ScoreboardPanel();
    private static EditorPanel editorPanel = new EditorPanel();

    /**
     * The main function constructs a JFrame then adds the snakeGame.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        mainFrame.setLayout(new BorderLayout());

        mainFrame.add(menuPanel, BorderLayout.SOUTH);

        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    /**
     * Plays the snakeGame.
     */
    public static void playGame(){
        mainFrame.remove(levelEditor);
        mainFrame.remove(editorPanel);
        mainFrame.add(scoreboardPanel, BorderLayout.NORTH);
        mainFrame.add(snakeGame, BorderLayout.CENTER);
        mainFrame.pack();
        try{
            snakeGame.reset();
            snakeGame.addPanel(scoreboardPanel);
            snakeGame.play();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void editLevel(){
        mainFrame.remove(snakeGame);
        mainFrame.remove(scoreboardPanel);
        mainFrame.add(editorPanel, BorderLayout.NORTH);
        mainFrame.add(levelEditor, BorderLayout.CENTER);
        mainFrame.pack();
        try{
            levelEditor.reset();
            levelEditor.addPanel(editorPanel);
            levelEditor.play();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static JFrame getMainFrame(){
        return mainFrame;
    }
}
