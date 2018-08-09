package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by routarddev on 7/08/18.
 */
@Data
@AllArgsConstructor
public class Position {

    private Coordinates coordinates;
    private Orientation orientation;

    @Override
    public String toString() {
        return  coordinates.getXCoord() + " " +
                coordinates.getYCoord() + " " +
                orientation.name();
    }

}
