package sch.nodar.snake;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

 class ScoreboardPanel extends JPanel implements Tickable {

    private LinkedHashMap<Scoreable, JLabel> scores;

    ScoreboardPanel(){
        super(new GridLayout());
        scores = new LinkedHashMap<>();
    }

    void registerScoreable(Scoreable scoreable){
        JLabel jLabel = new JLabel("snake" + scoreable.getID());
        scores.put(scoreable, jLabel);
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
