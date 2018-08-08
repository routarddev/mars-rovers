package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by routarddev on 8/08/18.
 */
public class HeadingTest {

    private Heading heading;

    @Test
    public void getHeadingValueTest() {
        heading = Heading.NORTH;
        assertNotNull(heading);
        assertNotNull(heading.getHeadingValue());
        assertEquals(Heading.NORTH.getHeadingValue(), heading.getHeadingValue());
    }

    @Test
    public void headingEnumValuesTest() {
        assertNotNull(Heading.values());
        assertTrue(Heading.values().length > 0);
    }

    @Test
    public void getHeadingByValueTest() {
        heading = Heading.EAST;
        assertNotNull(heading.getHeadingValue());
        assertEquals(Heading.EAST.getHeadingValue(), heading.getHeadingValue());
        assertEquals(Heading.EAST, Heading.valueOf(heading.getHeadingValue()));
    }

}
