import controller.RoversControllerTest;
import model.DirectionTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite for all tests
 * @author routarddev
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        RoversControllerTest.class,
        DirectionTest.class
})
public class MarsRoversTestSuite {
}
