package interaction;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by routarddev on 8/08/18.
 */
public class InputProcessorTest {

    private InputProcessor inputProcessor;
    private final static String FILE_PATH = "src/test/resources/";

    @Before
    public void setUp() {
        inputProcessor = new InputProcessor();
    }

    @Test
    public void testFile() throws Exception {
        inputProcessor.processFromFile(FILE_PATH + "testInputFile.txt");
        assertNotNull(inputProcessor.getPlateau());
        assertNotNull(inputProcessor.getRovers());
        assertEquals(2, inputProcessor.getRovers().size());
    }

    @Test(expected = Exception.class)
    public void testFileUnexpectedPattern() throws Exception {
        inputProcessor.processFromFile(FILE_PATH + "testInputFileWrongPattern.txt");
    }


}
