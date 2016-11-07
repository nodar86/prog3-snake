package sch.nodar.gameengine.game;

import sch.nodar.gameengine.entity.EditorCaretEntity;
import sch.nodar.gameengine.panels.EditorPanel;
import sch.nodar.gameengine.settings.LevelEditorSettings;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class LevelEditorGame extends Game {

    private EditorCaretEntity editorCaretEntity;

    public LevelEditorGame(){
        super();
    }

    @Override
    public void reset(){
        super.reset();

        settings = new LevelEditorSettings(30);
        editorCaretEntity = new EditorCaretEntity(level, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SPACE, KeyEvent.VK_ENTER);
        addEntity(editorCaretEntity);
    }

    @Override
    public void addPanel(JPanel panel){
        super.addPanel(panel);
        if(panel instanceof EditorPanel){
            ((EditorPanel)panel).setEditorCaretEntity(editorCaretEntity);
        }
    }
}
