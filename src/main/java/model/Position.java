package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by routarddev on 7/08/18.
 */
@Data
@AllArgsConstructor
public class Position {

    private Coordinates coordinates;
    private Direction direction;

    @Override
    public String toString() {
        return  coordinates.getXCoord() + " " +
                coordinates.getYCoord() + " " +
                direction.name();
    }

}
