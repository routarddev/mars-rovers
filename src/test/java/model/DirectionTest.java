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
        direction = Direction.NORTH;
        assertNotNull(direction);
        assertNotNull(direction.getHeadingValue());
        assertEquals(Direction.NORTH.getHeadingValue(), direction.getHeadingValue());
    }

    @Test
    public void headingEnumValuesTest() {
        assertNotNull(Direction.values());
        assertTrue(Direction.values().length > 0);
    }

    @Test
    public void getHeadingByValueTest() {
        direction = Direction.EAST;
        assertNotNull(direction.getHeadingValue());
        assertEquals(Direction.EAST.getHeadingValue(), direction.getHeadingValue());
        assertEquals(Direction.EAST, Direction.valueOf(direction.getHeadingValue()));
    }

}
