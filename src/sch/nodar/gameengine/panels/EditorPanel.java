package sch.nodar.gameengine.panels;

import sch.nodar.gameengine.Tickable;
import sch.nodar.gameengine.entity.EditorCaretEntity;

import javax.swing.*;
import java.awt.*;

public class EditorPanel extends JPanel implements Tickable{

    private JLabel status = new JLabel("", SwingConstants.CENTER);
    private EditorCaretEntity editorCaretEntity;

    public EditorPanel(){
        super(new GridLayout());
        add(new JLabel("WASD to move, SPACE to change, RETURN to save.", SwingConstants.CENTER));
        add(status);
    }

    public void setEditorCaretEntity(EditorCaretEntity editorCaretEntity){
        this.editorCaretEntity = editorCaretEntity;
    }

    @Override
    public void tick() {
        if(editorCaretEntity.isSuccessful())
            status.setText("successfully saved to: " + editorCaretEntity.getLastFileName());
        else
            status.setText("");
    }
}
