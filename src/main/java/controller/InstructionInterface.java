package controller;

import model.Coordinates;
import model.Orientation;
import model.Position;

/**
 * Created by routarddev on 7/08/18.
 */
public interface InstructionInterface {

    Orientation turnLeft(Orientation orientation);
    Orientation turnRight(Orientation orientation);
    Coordinates move(Position currentPosition, Coordinates upperRightCoord);

}
