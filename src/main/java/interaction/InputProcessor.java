package interaction;

import utils.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.Coordinates;
import model.Direction;
import model.Position;
import model.Rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by routarddev on 8/08/18.
 */
@NoArgsConstructor
@Getter
public class InputProcessor {

    //List of rovers and their instructions
    private Map<Rover, String> rovers = new HashMap<>();

    //Plateau Upper Right Coordinates
    private Coordinates plateau;

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void processFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        //Expecting plateau size information in the heading
        String line = br.readLine();
        if (line != null && hasExpectedPattern(line, false)) {
            String[] plateauCoord = line.split(Constants.LINE_SEPARATOR);
            plateau = new Coordinates(  Integer.parseInt(plateauCoord[0]),
                                        Integer.parseInt(plateauCoord[1]));
        } //else finish with error message
        else return;

        int numberOfRovers = 0;
        while ((line = br.readLine().toUpperCase()) != null) {
            if (!hasExpectedPattern(line, true)) return;
            Rover rover = processLines(numberOfRovers++, line);
            rovers.put(rover, br.readLine().toUpperCase());
        }
    }



    /**
     *
     */
    public void processFromConsole() {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        if (line != null && hasExpectedPattern(line, false)) {
            String[] plateauCoord = line.split(Constants.LINE_SEPARATOR);
            plateau = new Coordinates(  Integer.parseInt(plateauCoord[0]),
                    Integer.parseInt(plateauCoord[1]));
        } //else finish with error message
        else return;

        System.out.println("Read rovers positions and movements");
        int numberOfRovers = 0;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().toUpperCase();
            if (!hasExpectedPattern(line, true)) return;
            Rover rover = processLines(numberOfRovers++, line);
            rovers.put(rover, scanner.nextLine().toUpperCase());
        }
    }


    /**
     *
     * @param count
     * @param positionString
     * @return
     */
    private Rover processLines(int count, String positionString) {
        String[] pos = positionString.split(Constants.LINE_SEPARATOR);
        Position position = new Position(new Coordinates(   Integer.parseInt(pos[0]),
                Integer.parseInt(pos[1])),
                Direction.valueOf(pos[2]));
        return new Rover(count, "R" + count, position);
    }

    /**
     * Verify that the line matches the expected pattern
     * @param line String that is currently being read
     * @param hasDirection true if the orientation is provided, false otherwise
     * @return true if line matches the expected pattern, false otherwise
     */
    private boolean hasExpectedPattern(String line, boolean hasDirection) {
        String pattern = "\\d+\\s\\d+";
        if (hasDirection) pattern += "\\s[NESW]";
        return line.matches(pattern);
    }


    /**
     * TODO
     */
    public void processFromApi() {

    }


}
