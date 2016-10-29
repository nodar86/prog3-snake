package sch.nodar.snake;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        JFrame mainFrame = new JFrame("Snake");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(game, BorderLayout.CENTER);
        mainFrame.add(new MenuPanel(), BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        try {
            game.play();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
