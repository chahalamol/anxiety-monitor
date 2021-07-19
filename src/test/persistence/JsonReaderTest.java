package persistence;

import model.GadData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            GadData gd = reader.read();
            Assertions.fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyGadRecord() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGadData.json");
        try {
            GadData gd = reader.read();
            Assertions.assertEquals(0, gd.getGadScoreList().size());
        } catch (IOException e) {
            Assertions.fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralGadData() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGadData.json");
        try {
            GadData gd = reader.read();
            Assertions.assertEquals(1, gd.getGadScoreList().size());
        } catch (IOException e) {
            Assertions.fail("Couldn't read from file");
        }
    }
}
