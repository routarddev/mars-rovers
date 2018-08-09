import controller.RoverInstructionTest;
import controller.RoversControllerTest;
import interaction.InputProcessorTest;
import interaction.ProcessStepsTest;
import model.OrientationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite for all tests
 * @author routarddev
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        InputProcessorTest.class,
        OrientationTest.class,
        ProcessStepsTest.class,
        RoversControllerTest.class,
        RoverInstructionTest.class
})
public class MarsRoversTestSuite {
}
