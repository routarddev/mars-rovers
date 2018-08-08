package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hadrien on 7/08/18.
 */
@Getter
@Setter
@AllArgsConstructor
public class Position {

    private Coordinates coordinates;
    private Heading heading;
}
