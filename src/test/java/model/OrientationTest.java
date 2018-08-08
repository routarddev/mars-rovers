package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by routarddev on 8/08/18.
 */
public class OrientationTest {

    private Orientation orientation;

    @Test
    public void getHeadingValueTest() {
        orientation = Orientation.N;
        assertNotNull(orientation);
        assertNotNull(orientation.getHeadingValue());
        assertEquals(Orientation.N.getHeadingValue(), orientation.getHeadingValue());
    }

    @Test
    public void headingEnumValuesTest() {
        assertNotNull(Orientation.values());
        assertTrue(Orientation.values().length > 0);
    }

    @Test
    public void getHeadingByValueTest() {
        orientation = Orientation.E;
        assertNotNull(orientation.getHeadingValue());
        assertEquals(Orientation.E.getHeadingValue(), orientation.getHeadingValue());
        assertEquals(Orientation.E, Orientation.valueOf(orientation.getHeadingValue()));
    }

}
