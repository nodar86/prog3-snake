package sch.nodar.gameengine;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

 public class ScoreboardPanel extends JPanel implements Tickable {

    private LinkedHashMap<Scoreable, JLabel> scores;

    ScoreboardPanel(){
        super(new GridLayout());
        scores = new LinkedHashMap<>();
    }

     public void registerScoreable(Scoreable scoreable){
        JLabel jLabel = new JLabel("gameengine" + scoreable.getID());
        scores.put(scoreable, jLabel);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(jLabel);
    }

    @Override
    public void tick() {
        scores.forEach((snakeEntity, jLabel) ->
                jLabel.setText("gameengine[" + snakeEntity.getID() + "]: " + snakeEntity.getScore()));
    }
}
