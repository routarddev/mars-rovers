import controller.RoversControllerTest;
import model.HeadingTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite for all tests
 * @author routarddev
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        RoversControllerTest.class,
        HeadingTest.class
})
public class MarsRoversTestSuite {
}
