package sch.nodar.gameengine.game;

import sch.nodar.gameengine.Level;
import sch.nodar.gameengine.entity.EditorCaretEntity;
import sch.nodar.gameengine.settings.LevelEditorSettings;

import java.awt.event.KeyEvent;

public class LevelEditorGame extends Game {

    public LevelEditorGame(){
        super();
        level = new Level("whatever", SCREEN_WIDTH, SCREEN_HEIGHT);
        settings = new LevelEditorSettings(30);
        addEntity(new EditorCaretEntity(level, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_ENTER, KeyEvent.VK_ESCAPE));
    }
}
