package controller;

import model.Coordinates;
import model.Orientation;
import model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by routarddev on 9/08/18.
 */
public class RoverInstructionTest {

    private RoverInstruction roverInstruction;

    @Before
    public void setUp() {
        roverInstruction = new RoverInstruction();
    }

    @Test
    public void testMove() {
        Position position = new Position(new Coordinates(3, 2), Orientation.E);
        Coordinates plateauCoordinates = new Coordinates(4, 6);
        Coordinates newCoordinates = roverInstruction.move(position, plateauCoordinates);
        assertNotNull(newCoordinates);
        assertEquals(4, newCoordinates.getXCoord());
        assertEquals(2, newCoordinates.getYCoord());
    }

    /**
     * Expected: do nothing
     */
    @Test
    public void testMoveOutOfBounds() {
        Position position = new Position(new Coordinates(4, 2), Orientation.E);
        Coordinates plateauCoordinates = new Coordinates(4, 6);
        Coordinates newCoordinates = roverInstruction.move(position, plateauCoordinates);
        assertNotNull(newCoordinates);
        assertEquals(4, newCoordinates.getXCoord());
        assertEquals(2, newCoordinates.getYCoord());
    }

    @Test
    public void testTurnLeft() {
        Orientation newOrientation = roverInstruction.turnLeft(Orientation.N);
        assertNotNull(newOrientation);
        assertEquals(Orientation.W, newOrientation);
    }

    @Test
    public void testTurnRight() {
        Orientation newOrientation = roverInstruction.turnRight(Orientation.E);
        assertNotNull(newOrientation);
        assertEquals(Orientation.S, newOrientation);
    }

}
