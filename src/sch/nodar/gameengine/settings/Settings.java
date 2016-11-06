package sch.nodar.gameengine.settings;

public abstract class Settings {
    int tickTime;

    Settings(int tickTime){
        this.tickTime = tickTime;
    }

    public int getTickTime(){
        return tickTime;
    }
}
