package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by routarddev on 7/08/18.
 */
@AllArgsConstructor
public enum Orientation {

    N(0), //NORTH
    E(1), //EAST
    S(2), //SOUTH
    W(3); //WEST

    @Getter
    private final int headingValue;

    private static Map map = new HashMap<>();

    static {
        for (Orientation orientation : Orientation.values()) {
            map.put(orientation.headingValue, orientation);
        }
    }

    public static Orientation valueOf(int direction) {
        return (Orientation) map.get(direction);
    }
}
