package sch.nodar.gameengine.panels;

import sch.nodar.gameengine.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the panel containing the Main Menu and all associated elements.
 */
public class MenuPanel extends JPanel {

    private class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent){
            switch (actionEvent.getActionCommand()){
                case "play":
                    Main.playGame();
                    break;
                case "highscore":
                    Main.showHighscores();
                    break;
                case "leveleditor":
                    Main.editLevel();
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * Constructs the Main Menu with all the required elements.
     */
    public MenuPanel(){
        super(new FlowLayout());

        JButton playButton = new JButton("Play!");
        JButton highScoreButton = new JButton("Show highscores");
        JButton levelEditorButton = new JButton("Level editor");
        JButton exitButton = new JButton("Exit");

        playButton.setActionCommand("play");
        highScoreButton.setActionCommand("highscore");
        levelEditorButton.setActionCommand("leveleditor");
        exitButton.setActionCommand("exit");

        ActionListener menuActionListener = new MenuActionListener();
        playButton.addActionListener(menuActionListener);
        highScoreButton.addActionListener(menuActionListener);
        levelEditorButton.addActionListener(menuActionListener);
        exitButton.addActionListener(menuActionListener);

        add(playButton);
        add(highScoreButton);
        add(levelEditorButton);
        add(exitButton);
    }

}