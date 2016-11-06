package sch.nodar.gameengine.entity;

import sch.nodar.gameengine.Drawable;
import sch.nodar.gameengine.Level;

import java.awt.*;
import java.awt.event.KeyEvent;

public class EditorCaretEntity extends ControllableEntity implements Drawable {

    public EditorCaretEntity(Level level, int upKey, int downKey, int leftKey, int rightKey, int changeKey, int saveKey){
        super(level, level.getFreePosition());

        keys.put("upKey", upKey);
        keys.put("downKey", downKey);
        keys.put("leftKey", leftKey);
        keys.put("rightKey", rightKey);
        keys.put("changeKey", changeKey);
        keys.put("saveKey", saveKey);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawRect(getDrawPosition().x, getDrawPosition().y, level.getTileWidth(), level.getTileHeight());
        graphics.drawRect(getDrawPosition().x+1, getDrawPosition().y+1, level.getTileWidth()-2, level.getTileHeight()-2);
    }

    @Override
    public String getName() {
        return "caret";
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int inputKeyCode = e.getKeyCode();
        if(inputKeyCode == keys.get("upKey")) {
            if(0 < position.y)
                position.y--;
            else
                position.y = level.getHeight()-1;
        }
        if(inputKeyCode == keys.get("leftKey")) {
            if(0 < position.x)
                position.x--;
            else
                position.x = level.getWidth()-1;
        }
        if(inputKeyCode == keys.get("downKey")) {
            if(position.y < level.getHeight()-1)
                position.y++;
            else
                position.y = 0;
        }
        if(inputKeyCode == keys.get("rightKey")) {
            if(position.x < level.getWidth()-1)
                position.x++;
            else
                position.x = 0;
        }
        if(inputKeyCode == keys.get("changeKey")) {
            if(level.getEntityAt(position) == null)
                new WallEntity(level, position.clone());
            else if(level.getEntityAt(position) instanceof WallEntity)
                level.removeEntity(position);
        }
        if(inputKeyCode == keys.get("saveKey")) {
            level.saveLevel("whatever");
        }
    }
}