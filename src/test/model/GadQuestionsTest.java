package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GadQuestionsTest {

    private GadQuestions testGadQuestions;

    @BeforeEach
    void setup() {
        testGadQuestions = new GadQuestions();
    }

    @Test
    void testGetQuestions() {
        assertEquals("Over the two weeks, how often have you been bothered by the following problems?",
                testGadQuestions.getQuestionHeading());
        assertEquals("Feeling nervous, anxious, or on edge", testGadQuestions.getQuestion1());
        assertEquals("Not being able to stop or control worrying", testGadQuestions.getQuestion2());
        assertEquals("Worrying too much about different things", testGadQuestions.getQuestion3());
        assertEquals("Trouble relaxing", testGadQuestions.getQuestion4());
        assertEquals("Being so restless that it is hard to sit still", testGadQuestions.getQuestion5());
        assertEquals("Becoming easily annoyed or irritable", testGadQuestions.getQuestion6());
        assertEquals("Feeling afraid, as if something awful might happen", testGadQuestions.getQuestion7());
        assertEquals("0 = Not at all", testGadQuestions.getAnswer0());
        assertEquals("1 = Several days", testGadQuestions.getAnswer1());
        assertEquals("2 = More than half the days", testGadQuestions.getAnswer2());
        assertEquals("3 = Nearly every day", testGadQuestions.getAnswer3());
    }
}
