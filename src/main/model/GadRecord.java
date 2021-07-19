package model;

import org.json.JSONObject;

// Represents a class where the scores are calculated based on the provided algorithm (all the math is done here)
public class GadRecord {

    private int score;
    private int totalScore;
    private Severity severity;

    // Constructs a GAD Record
    public GadRecord() {
        score = 0;
        severity = null;
        totalScore = 0;
    }

    // Constructs a GAD Record with the given parameters
    public GadRecord(Severity severity, Integer totalScore) {
        this.severity = severity;
        this.totalScore = totalScore;
    }

    // Getters
    public int getScore() {
        return score;
    }

    public String getSeverity() {
        if (severity.equals(Severity.MINIMAL)) {
            return "minimal anxiety";
        } else if (severity.equals(Severity.MILD)) {
            return "mild anxiety";
        } else if (severity.equals(Severity.MODERATE)) {
            return "moderate anxiety";
        } else {
            return "severe anxiety";
        }
    }

    public int getTotalScore() {
        return totalScore;
    }


    // MODIFIES: this
    // EFFECTS: sets the score value to 0
    public void setScore0() {
        score = 0;
    }

    // MODIFIES: this
    // EFFECTS: sets the score value to 1
    public void setScore1() {
        score = 1;
    }

    // MODIFIES: this
    // EFFECTS: sets the score value to 2
    public void setScore2() {
        score = 2;
    }

    // MODIFIES: this
    // EFFECTS: sets the score value to 3
    public void setScore3() {
        score = 3;
    }


    // MODIFIES: this
    // EFFECTS: adds all the scores to totalScore
    public void setTotalScore(int a1, int a2, int a3, int a4,
                              int a5, int a6, int a7) {
        totalScore = a1 + a2 + a3 + a4 + a5 + a6 + a7;
    }

    // MODIFIES: this
    // EFFECTS: if the totalScore is b/w 0 - 4, then sets the severity to minimal
    //          if the totalScore is b/w 5 - 9, then sets the severity to mild
    //          if the totalScore is b/w 10 - 14, then sets the severity to moderate
    //          if the totalScore is b/w 15 - 21, then sets the severity to severe
    //          if the totalScore is over 22, then it throws an exception, ScoreTooHighException
    public void setSeverity() throws ScoreTooHighException {
        if (totalScore < 5) {
            severity = Severity.MINIMAL;
        } else if (totalScore < 10) {
            severity = Severity.MILD;
        } else if (totalScore < 15) {
            severity = Severity.MODERATE;
        } else if (totalScore < 22) {
            severity = Severity.SEVERE;
        } else if (totalScore > 22) {
            throw new ScoreTooHighException();
        }
    }


    // MODIFIES: this
    // EFFECTS: adds a GAD Record to GAD Data in JSON Array
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("severity", severity);
        json.put("totalscore", totalScore);
        return json;
    }
}
