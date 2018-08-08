package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by routarddev on 8/08/18.
 */
public class DirectionTest {

    private Direction direction;

    @Test
    public void getHeadingValueTest() {
        direction = Direction.N;
        assertNotNull(direction);
        assertNotNull(direction.getHeadingValue());
        assertEquals(Direction.N.getHeadingValue(), direction.getHeadingValue());
    }

    @Test
    public void headingEnumValuesTest() {
        assertNotNull(Direction.values());
        assertTrue(Direction.values().length > 0);
    }

    @Test
    public void getHeadingByValueTest() {
        direction = Direction.E;
        assertNotNull(direction.getHeadingValue());
        assertEquals(Direction.E.getHeadingValue(), direction.getHeadingValue());
        assertEquals(Direction.E, Direction.valueOf(direction.getHeadingValue()));
    }

}
