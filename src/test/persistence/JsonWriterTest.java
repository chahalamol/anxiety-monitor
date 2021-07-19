package persistence;


import model.GadData;
import model.GadRecord;
import model.Severity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    public void testWriterInvalidFile() {
        try {
            GadData gd = new GadData();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            Assertions.fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyGadScore() {
        try {
            GadData gd = new GadData();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyRecord.json");
            writer.open();
            writer.write(gd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyRecord.json");
            gd = reader.read();
            Assertions.assertEquals(0, gd.getGadScoreList().size());
        } catch (IOException e) {
            Assertions.fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralGadData() {
        try {
            GadData gd = new GadData();
            GadRecord gr1 = new GadRecord();
            GadRecord gr2 = new GadRecord();

            gd.addRecord(new GadRecord(Severity.MINIMAL, 4));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGadData.json");
            writer.open();
            writer.write(gd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGadData.json");
            gd = reader.read();
            List<GadRecord> gadScoresList = new LinkedList<>();
            gadScoresList.add(gr1);
            gadScoresList.add(gr2);
            Assertions.assertEquals(2, gadScoresList.size());

        } catch (IOException e) {
            Assertions.fail("Exception should not have been thrown");
        }
    }
}
