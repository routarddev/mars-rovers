package controller;

import model.Coordinates;
import model.Heading;
import model.Position;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by hadrien on 8/08/18.
 */
public class RoversControllerTest {

    private RoversController roversController;

    @Test
    public void testRoverFinalPosition() {
        Position roverPosition = new Position(new Coordinates(3, 3), Heading.EAST);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "MMRMMRMRRM";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition, 5, 1, Heading.EAST);
    }

    @Test
    public void testRoverHeadingLeft() {
        Position roverPosition = new Position(new Coordinates(1, 2), Heading.NORTH);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "L";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition, 1, 2, Heading.WEST);
    }

    @Test
    public void testRoverHeadingRight() {
        Position roverPosition = new Position(new Coordinates(1, 2), Heading.NORTH);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "R";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition, 1, 2, Heading.EAST);
    }

    @Test
    public void testRoverMoveOneStep() {
        Position roverPosition = new Position(new Coordinates(1, 2), Heading.NORTH);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "M";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition,1, 3, Heading.NORTH);
    }

    @Test
    public void testRoverOutOfBounds() {
        Position roverPosition = new Position(new Coordinates(1, 2), Heading.WEST);
        Coordinates upperRightCoord = new Coordinates(5, 5);
        String chainOfInstructions = "MMMLMMMMLMMMMMMMMMMLMMMMMMMMMMM";

        roversController = new RoversController(roverPosition, upperRightCoord, chainOfInstructions);
        Position finalPosition = roversController.getRoverFinalPosition();

        assertResult(finalPosition, 5, 5, Heading.NORTH);
    }

    private void assertResult(Position finalPosition, int expectedXCoord, int expectedYCoord, Heading expectedHeading) {
        assertNotNull(finalPosition);
        Position expectedPosition = new Position(new Coordinates(expectedXCoord, expectedYCoord), expectedHeading);
        assertEquals(expectedPosition.getCoordinates().getXCoord(), finalPosition.getCoordinates().getXCoord());
        assertEquals(expectedPosition.getCoordinates().getYCoord(), finalPosition.getCoordinates().getYCoord());
        assertEquals(expectedPosition.getHeading(), finalPosition.getHeading());
    }

}
