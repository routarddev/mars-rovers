package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadrien on 7/08/18.
 */
@AllArgsConstructor
public enum Heading {

    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    @Getter
    private final int headingValue;

    private static Map map = new HashMap<>();

    static {
        for (Heading heading : Heading.values()) {
            map.put(heading.headingValue, heading);
        }
    }

    public static Heading valueOf(int heading) {
        return (Heading) map.get(heading);
    }
}
