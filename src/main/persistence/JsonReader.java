package persistence;

/* Code adopted from: https://github.com/stleary/JSON-java */

import model.GadData;
import model.GadRecord;
import model.Severity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//Represents a reader that reads GAD score from JSON stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads GadScore to read from source file
    public GadData read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return addGadScores(jsonObject);
    }

    // EFFECTS: reads source file as String and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses GadScore from JSON object and returns it
    private GadRecord parseGadRecord(JSONObject jsonObject) {
        Severity severity = Severity.valueOf(jsonObject.getString("severity"));
        Integer totalScore = jsonObject.getInt("totalscore");
        GadRecord gd = new GadRecord(severity, totalScore);

        return gd;
    }

    // EFFECTS: adds Gad Records to JSON Array
    public GadData addGadScores(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("gad records");
        GadData data = new GadData();
        for (Object json : jsonArray) {
            JSONObject nextGadScore = (JSONObject) json;
            GadRecord record = parseGadRecord(nextGadScore);
            data.addRecord(record);
        }
        return data;
    }

}