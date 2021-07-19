package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class GadRecordTest {
    private int testTotalScore;
    private Severity testSeverity;
    private GadRecord testGadRecord;

    @BeforeEach
    void setup() {
        testTotalScore = 0;
        testSeverity = Severity.MILD;
        testGadRecord = new GadRecord(testSeverity, testTotalScore);
    }

    @Test
    void testGetScore() {
        assertEquals(0, testGadRecord.getScore());
    }

    @Test
    void testGetSeverity() {
        assertEquals("mild anxiety", testGadRecord.getSeverity());
        testGadRecord = new GadRecord(Severity.MODERATE, testTotalScore);
        assertEquals("moderate anxiety", testGadRecord.getSeverity());
        testGadRecord = new GadRecord(Severity.MINIMAL, testTotalScore);
        assertEquals("minimal anxiety", testGadRecord.getSeverity());
        testGadRecord = new GadRecord(Severity.SEVERE, testTotalScore);
        assertEquals("severe anxiety", testGadRecord.getSeverity());
    }

    @Test
    void testGetTotalScore() {
        testTotalScore = 12;
        testGadRecord = new GadRecord(Severity.MODERATE, testTotalScore);
        assertEquals(12, testGadRecord.getTotalScore());
    }

    @Test
    void testSetScore() {
        testGadRecord.setScore1();
        assertEquals(1, testGadRecord.getScore());
        testGadRecord.setScore2();
        assertEquals(2, testGadRecord.getScore());
        testGadRecord.setScore3();
        assertEquals(3, testGadRecord.getScore());
        testGadRecord.setScore0();
        assertEquals(0, testGadRecord.getScore());
    }

    @Test
    void testSetTotalScore() {
        testGadRecord.setScore1();
        testGadRecord.setTotalScore(1,0,0,0,0,0,0);
        testGadRecord.setScore2();
        testGadRecord.setTotalScore(2,0,0,0,0,0,0);
        testGadRecord.setScore3();
        testGadRecord.setTotalScore(3,0,0,0,0,0,0);
        assertEquals(6, testGadRecord.getTotalScore());
    }

    @Test
    void testSetSeverity() {
        testTotalScore = 3;
        GadRecord testGadMin1 = new GadRecord(Severity.MILD, testTotalScore);
        try {
            testGadMin1.setSeverity();
            assertEquals("minimal anxiety", testGadMin1.getSeverity());
        } catch (ScoreTooHighException e) {
            fail();
        }

        testTotalScore = 7;
        GadRecord testGadMin2 = new GadRecord(Severity.MINIMAL, testTotalScore);
        try {
            testGadMin2.setSeverity();
            assertEquals("mild anxiety", testGadMin2.getSeverity());
        } catch (ScoreTooHighException e) {
            fail();
        }
        testTotalScore = 12;
        GadRecord testGadMin3 = new GadRecord(Severity.MILD, testTotalScore);
        try {
            testGadMin3.setSeverity();
            assertEquals("moderate anxiety", testGadMin3.getSeverity());
        } catch (ScoreTooHighException e) {
            fail();
        }
        testTotalScore = 18;
        GadRecord testGadMin4 = new GadRecord(Severity.MILD, testTotalScore);
        try {
            testGadMin4.setSeverity();
            assertEquals("severe anxiety", testGadMin4.getSeverity());
        } catch (ScoreTooHighException e) {
            fail();
        }
        testTotalScore = 24;
        GadRecord testGadMin5 = new GadRecord(Severity.MILD, testTotalScore);
        try {
            testGadMin5.setSeverity();
            fail();
        } catch (ScoreTooHighException e) {
            // Exception expected
        }
    }
}
