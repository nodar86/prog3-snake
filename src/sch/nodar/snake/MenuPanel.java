package sch.nodar.snake;

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
                    // TODO This somehow breaks everything. The game loop runs but the window freezes.
                    Main.playGame();
                    break;
                case "highscore":
                    break;
                case "leveleditor":
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