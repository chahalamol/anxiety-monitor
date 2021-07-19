package persistence;

import model.GadData;
import model.GadRecord;
import model.Severity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkGadData() {
        GadData gd = new GadData();
        GadRecord gr = new GadRecord(Severity.MILD, 3);
        gd.addRecord(gr);
        assertEquals(1, gd.getGadScoreList().size());
    }
}
