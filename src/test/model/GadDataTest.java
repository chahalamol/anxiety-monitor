package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GadDataTest {

    private GadData testGadData;
    private GadRecord testGadRecord;

    @BeforeEach
    void setup() {
        testGadData = new GadData();
        testGadRecord = new GadRecord();
    }

    @Test
    void testGetScoreList() {
        assertEquals(0, testGadData.getGadScoreList().size());
    }

    @Test
    void testPrintGadScores() {
        GadRecord testGr1 = new GadRecord(Severity.MILD, 7); // "mild anxiety 7"
        GadRecord testGr2 = new GadRecord(Severity.MODERATE, 12); // "moderate anxiety 12"
        testGadData.addRecord(testGr1); // ["mild anxiety 7"]
        testGadData.addRecord(testGr2);
        assertEquals(2, testGadData.getGadScoreList().size());

    }

    @Test
    void testAddRecord() {
        testGadData.addRecord(testGadRecord);
        assertEquals(1, testGadData.getGadScoreList().size());
    }
}
