package interaction;

import controller.RoversController;
import lombok.NoArgsConstructor;
import model.Position;
import model.Rover;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by routarddev on 8/08/18.
 */
@NoArgsConstructor
public class ProcessSteps {

    public void run(String... args) {
        InputProcessor inputProcessor = new InputProcessor();
        switch(args[0]) {
            case "2":
                inputProcessor.processFromConsole();
                break;
            case "3":
                inputProcessor.processFromApi();
                break;
            default:
                try {
                    inputProcessor.processFromFile("src/main/resources/inputFile.txt");
                } catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
        }

        List<Position> resultPositions = new LinkedList<>();
        RoversController roversController;
        for(Map.Entry<Rover,String> entry : inputProcessor.getRovers().entrySet()) {
            Rover rover = entry.getKey();
            roversController = new RoversController(rover.getPosition(),
                                                    inputProcessor.getPlateau(),
                                                    entry.getValue());
            resultPositions.add(roversController.getRoverFinalPosition());
        }

        showResults(resultPositions, Integer.parseInt(args[0]));
    }

    private void showResults(List<Position> resultPosition, int option) {
        switch(option) {
            case 2:
                for(Position result: resultPosition)
                    System.out.println(result.getCoordinates().toString());
                break;
            case 3:
                //TO DO
                break;
            default:
                try {
                    writeFile(resultPosition);
                } catch(IOException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                }
                break;
        }
    }

    private void writeFile(List<Position> resultPosition) throws IOException {
        FileOutputStream file = new FileOutputStream("src/main/resources/outputFile.txt");
        ObjectOutputStream out = new ObjectOutputStream(file);

        for(Position result: resultPosition)
            out.writeObject(result.getCoordinates().toString());

        out.close();
        file.close();
    }

}
