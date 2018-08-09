package controller;

import model.Coordinates;
import model.Orientation;
import model.Position;

/**
 * Created by routarddev on 7/08/18.
 */
public class RoversController {

    private Position roverPosition;
    private Coordinates upperRightCoord;
    private String chainOfInstructions;
    private RoverInstruction roverMovement;


    public RoversController(Position roverPosition,
                            Coordinates upperRightCoord,
                            String chainOfInstructions) {
        this.roverPosition = roverPosition;
        this.upperRightCoord = upperRightCoord;
        this.chainOfInstructions = chainOfInstructions;
        this.roverMovement = new RoverInstruction();
    }

    public Position getRoverFinalPosition() {
        for(char instruction: chainOfInstructions.toCharArray()) {
            roverPosition = processInstruction(roverPosition, instruction);
        }
        return roverPosition;
    }

    private Position processInstruction(Position currentPosition, char instruction) {
        Coordinates newCoordinates = currentPosition.getCoordinates();
        Orientation newOrientation = currentPosition.getOrientation();

        switch(instruction) {
            case 'L':
                newOrientation = roverMovement.turnLeft(currentPosition.getOrientation());
                break;

            case 'R':
                newOrientation = roverMovement.turnRight(currentPosition.getOrientation());
                break;

            case 'M':
                newCoordinates = roverMovement.move(currentPosition, upperRightCoord);
                break;

            default: //unknown instruction
                //do nothing
                break;
        }

        currentPosition.setCoordinates(newCoordinates);
        currentPosition.setOrientation(newOrientation);

        return currentPosition;
    }

}
