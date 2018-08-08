package interaction;

import org.junit.Before;
import org.junit.Test;
import utils.Constants;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Created by routarddev on 8/08/18.
 */
public class ProcessStepsTest {

    private ProcessSteps processSteps;
    private final static String FILE_PATHNAME = "src/test/resources/testInputFile.txt";

    @Before
    public void setUp() {
        processSteps = new ProcessSteps();
    }

    @Test
    public void testProcessFile() {
        processSteps.run("1");
        File outputFile = new File(Constants.OUTPUT_FILE_PATHNAME);
        assertTrue(outputFile.exists());
    }

    @Test
    public void testProcessArgumentFile() {
        processSteps.run(new String[]{"10", FILE_PATHNAME});
        File outputFile = new File(Constants.OUTPUT_FILE_PATHNAME);
        assertTrue(outputFile.exists());
    }


}
