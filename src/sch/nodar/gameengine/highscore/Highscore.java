package sch.nodar.gameengine.highscore;


public class Highscore {
    private String name;
    private int score;

    public Highscore(String name, int score){
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
