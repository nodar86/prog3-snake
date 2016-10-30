package sch.nodar.snake;

import sch.nodar.snake.entity.SnakeEntity;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class ScoreboardPanel extends JPanel implements Tickable {

    private LinkedHashMap<SnakeEntity, JLabel> scores;

    public ScoreboardPanel(){
        super(new GridLayout());
        scores = new LinkedHashMap<>();
    }

    public void registerSnake(SnakeEntity snakeEntity){
        JLabel jLabel = new JLabel("snake" + snakeEntity.getID());
        scores.put(snakeEntity, jLabel);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(jLabel);
    }

    @Override
    public void tick() {
        scores.forEach((snakeEntity, jLabel) ->
                jLabel.setText("snake[" + snakeEntity.getID() + "]: " + snakeEntity.getScore()));
    }
}
