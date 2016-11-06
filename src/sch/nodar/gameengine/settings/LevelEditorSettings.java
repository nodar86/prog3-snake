package sch.nodar.gameengine.settings;

public class LevelEditorSettings extends Settings {

    public LevelEditorSettings(int tickTime) {
        super(tickTime);
    }

    public LevelEditorSettings(){
        this(90);
    }
}
