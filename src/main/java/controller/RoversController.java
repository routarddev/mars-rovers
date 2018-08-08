package controller;

import lombok.AllArgsConstructor;
import model.Coordinates;
import model.Heading;
import model.Position;

/**
 * Created by routarddev on 7/08/18.
 */
@AllArgsConstructor
public class RoversController {

    private Position roverPosition;
    private Coordinates upperRightCoord;
    private String chainOfInstructions;

    public Position getRoverFinalPosition() {
        for(char instruction: chainOfInstructions.toCharArray()) {
            roverPosition = processInstruction(roverPosition, instruction);
        }
        return roverPosition;
    }

    private Position processInstruction(Position currentPosition, char instruction) {
        Coordinates newCoordinates = currentPosition.getCoordinates();
        int headingValue = currentPosition.getHeading().getHeadingValue();

        switch(instruction) {
            case 'L':
                headingValue--;
                headingValue = Math.floorMod(headingValue, Heading.values().length);
                break;

            case 'R':
                headingValue++;
                headingValue = Math.floorMod(headingValue, Heading.values().length);
                break;

            case 'M':
                newCoordinates = move(currentPosition);
                break;

            default: //unknown instruction
                //do nothing
                break;
        }

        currentPosition.setCoordinates(newCoordinates);

        //REVIEW following instruction!
        currentPosition.setHeading(Heading.valueOf(headingValue));

        return currentPosition;
    }

    private Coordinates move(Position currentPosition) {
        int xCoord = currentPosition.getCoordinates().getXCoord();
        int yCoord = currentPosition.getCoordinates().getYCoord();

        switch(currentPosition.getHeading().getHeadingValue()) {
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
