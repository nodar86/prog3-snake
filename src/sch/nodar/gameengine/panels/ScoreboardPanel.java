package sch.nodar.gameengine.panels;

import sch.nodar.gameengine.Scoreable;
import sch.nodar.gameengine.Tickable;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

 public class ScoreboardPanel extends JPanel implements Tickable {

    private LinkedHashMap<Scoreable, JLabel> scores;

    public ScoreboardPanel(){
        super(new GridLayout());
        scores = new LinkedHashMap<>();
    }

     public void registerScoreable(Scoreable scoreable){
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
