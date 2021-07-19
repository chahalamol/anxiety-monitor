package model;

// Represent GAD-7 questions
public class GadQuestions {
    private final String questionHeading;
    private final String question1;
    private final String question2;
    private final String question3;
    private final String question4;
    private final String question5;
    private final String question6;
    private final String question7;
    private final String answer0;
    private final String answer1;
    private final String answer2;
    private final String answer3;

    // Constructs a GadQuestions
    public GadQuestions() {
        questionHeading = "Over the two weeks, how often have you been bothered by the following problems?"
                + " Please enter from 0 = Not at all, 1 = Several days, 2 = More than half days, 3 = Nearly every day";
        question1 = "Feeling nervous, anxious, or on edge";
        question2 = "Not being able to stop or control worrying";
        question3 = "Worrying too much about different things";
        question4 = "Trouble relaxing";
        question5 = "Being so restless that it is hard to sit still";
        question6 = "Becoming easily annoyed or irritable";
        question7 = "Feeling afraid, as if something awful might happen";
        answer0 = "0 = Not at all";
        answer1 = "1 = Several days";
        answer2 = "2 = More than half the days";
        answer3 = "3 = Nearly every day";
    }

    //Getters
    public String getQuestion1() {
        return question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public String getQuestion5() {
        return question5;
    }

    public String getQuestion6() {
        return question6;
    }

    public String getQuestion7() {
        return question7;
    }

    public String getQuestionHeading() {
        return questionHeading;
    }

    public String getAnswer0() {
        return answer0;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }
}
