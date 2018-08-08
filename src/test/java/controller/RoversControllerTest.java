package controller;

import model.Coordinates;
import model.Orientation;
import model.Position;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by routarddev on 8/08/18.
 */
public class RoversControllerTest {

    private RoversController roversController;

    @Test
    public void testRoverFinalPosition() {
        Position roverPosition = new Position(new Coordinates(3, 3), Orientation.E);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "MMRMMRMRRM";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition, 5, 1, Orientation.E);
    }

    @Test
    public void testRoverHeadingLeft() {
        Position roverPosition = new Position(new Coordinates(1, 2), Orientation.N);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "L";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition, 1, 2, Orientation.W);
    }

    @Test
    public void testRoverHeadingRight() {
        Position roverPosition = new Position(new Coordinates(1, 2), Orientation.N);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "R";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition, 1, 2, Orientation.E);
    }

    @Test
    public void testRoverMoveOneStep() {
        Position roverPosition = new Position(new Coordinates(1, 2), Orientation.N);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "M";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition,1, 3, Orientation.N);
    }

    @Test
    public void testRoverOutOfBounds() {
        Position roverPosition = new Position(new Coordinates(1, 2), Orientation.W);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "MMMLMMMMLMMMMMMMMMMLMMMMMMMMMMM";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition, 5, 5, Orientation.N);
    }

    private void assertResult(Position finalPosition,
                              int expectedXCoord,
                              int expectedYCoord,
                              Orientation expectedOrientation)
    {
        assertNotNull(finalPosition);
        assertEquals(expectedXCoord, finalPosition.getCoordinates().getXCoord());
        assertEquals(expectedYCoord, finalPosition.getCoordinates().getYCoord());
        assertEquals(expectedOrientation, finalPosition.getOrientation());
    }

}
