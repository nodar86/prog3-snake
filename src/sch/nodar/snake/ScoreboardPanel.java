package sch.nodar.snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class ScoreboardPanel extends JPanel implements Tickable {

    private LinkedHashMap<Scorable, JLabel> scores;

    public ScoreboardPanel(){
        super(new GridLayout());
        scores = new LinkedHashMap<>();
    }

    public void registerScorable(Scorable scorable){
        JLabel jLabel = new JLabel("snake" + scorable.getID());
        scores.put(scorable, jLabel);
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
