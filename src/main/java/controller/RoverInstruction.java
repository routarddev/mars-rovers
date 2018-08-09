package controller;

import model.Coordinates;
import model.Orientation;
import model.Position;

/**
 * Offers available instructions for MarsRover
 *
 * Created by routarddev on 9/08/18.
 */
public class RoverInstruction implements InstructionInterface {

    @Override
    public Orientation turnLeft(Orientation orientation) {
        return turnRover(orientation, true);
    }

    @Override
    public Orientation turnRight(Orientation orientation) {
        return turnRover(orientation, false);
    }

    /**
     * Turn 90 degrees left or right
     * @param orientation current orientation
     * @param isTurnLeft true if going to turn left, false otherwise
     * @return the new orientation after the movement
     */
    private Orientation turnRover(Orientation orientation, boolean isTurnLeft) {
        int headingToValue = orientation.getHeadingValue();

        if (isTurnLeft)
            headingToValue--;
        else
            headingToValue++;

        headingToValue = Math.floorMod(headingToValue, Orientation.values().length);

        return Orientation.valueOf(headingToValue);
    }

    /**
     * Instruction to move the rover one step towards the current orientation.
     * If the rover is in the limits of the plateau and heading over this limits,
     * nothing will be done.
     *
     * @param currentPosition position where the MarsRover is
     * @param upperRightCoord limits of the plateau
     * @return the new coordinates of the rover
     */
    @Override
    public Coordinates move(Position currentPosition, Coordinates upperRightCoord) {
        int xCoord = currentPosition.getCoordinates().getXCoord();
        int yCoord = currentPosition.getCoordinates().getYCoord();

        switch(currentPosition.getOrientation().getHeadingValue()) {
            case 0: //N
                if (yCoord != upperRightCoord.getYCoord()) yCoord++;
                break;

            case 1: //E
                if (xCoord != upperRightCoord.getXCoord()) xCoord++;
                break;

            case 2: //S
                if (yCoord != 0) yCoord--;
                break;

            case 3: //W
                if (xCoord != 0) xCoord--;
                break;
        }

        return new Coordinates(xCoord, yCoord);
    }
}
