package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

// Stores and represents GAD questions attempts by the user
public class GadData {
    private String title = "Anxiety Levels";
    private LinkedList<GadRecord> gadScoreList;

    // Constructs GadData with title and new LinkedList
    public GadData() {
        title = "Anxiety Levels: ";
        gadScoreList = new LinkedList<>();
    }

    //Getters
    public LinkedList<GadRecord> getGadScoreList() {
        return gadScoreList;
    }

    // REQUIRES: a Gad Record
    // MODIFIES: this
    // EFFECTS: adds a given Gad record to a list gadScoreList
    public void addRecord(GadRecord gadScore) {
        gadScoreList.add(gadScore);
    }

    // MODIFIES: this
    // EFFECTS: adds gadData to JSON Array
    public JSONObject gadDataToJson() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (GadRecord gd : gadScoreList) {
            jsonArray.put(gd.toJson());
        }
        jsonObject.put("gad records", jsonArray);
        return jsonObject;
    }
}