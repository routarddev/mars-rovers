package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by routarddev on 7/08/18.
 */
@AllArgsConstructor
public enum Direction {

    NORTH(0), //NORTH
    EAST(1), //EAST
    SOUTH(2), //SOUTH
    WEST(3); //WEST

    @Getter
    private final int headingValue;

    private static Map map = new HashMap<>();

    static {
        for (Direction direction : Direction.values()) {
            map.put(direction.headingValue, direction);
        }
    }

    public static Direction valueOf(int direction) {
        return (Direction) map.get(direction);
    }
}
