package sch.nodar.gameengine.highscore;

import javax.json.*;
import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Highscores extends AbstractTableModel {

    private List<Highscore> highscores;

    public Highscores(){
        highscores = new ArrayList<>();

        try {
            JsonArray highscoreArray = Json.createReader(new FileInputStream(System.getProperty("user.dir") + File.separator + "highscores.json")).readArray();

            highscoreArray.getValuesAs(JsonObject.class).forEach(highscore ->
                highscores.add(new Highscore(highscore.getString("name"), highscore.getInt("score"))));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void save(){
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        highscores.forEach(highscore -> {
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("name", highscore.getName()).add("score", highscore.getScore());
            jsonArrayBuilder.add(jsonObjectBuilder.build());
        });

        try {
            JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(new File("highscores.json")));
            jsonWriter.writeArray(jsonArrayBuilder.build());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void add(Highscore highscore){
        highscores.add(highscore);
    }

    @Override
    public String getColumnName(int column){
        if(column == 0)
            return "Name";
        else if(column == 1)
            return "Score";
        else
            return "wtf";
    }

    @Override
    public int getRowCount() {
        return highscores.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Highscore highscore = highscores.get(rowIndex);
        if(columnIndex == 0)
            return highscore.getName();
        else if (columnIndex == 1)
            return highscore.getScore();
        else
            return null;
    }
}
