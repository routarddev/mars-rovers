package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by routarddev on 8/08/18.
 */
@Data
@AllArgsConstructor
public class Rover {

    private int id;
    private String name;
    private Position position;
}
