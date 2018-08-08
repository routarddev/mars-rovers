package interaction;

import utils.Constants;
import controller.RoversController;
import lombok.NoArgsConstructor;
import model.Position;
import model.Rover;

import java.io.*;
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
                    System.out.println("Process From File");
                    if (args.length > 1 && !args[1].isEmpty() && new File(args[1]).exists())
                        inputProcessor.processFromFile(args[1]);
                    else
                        inputProcessor.processFromFile(Constants.INPUT_FILE_PATHNAME);
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
            case 2: //Console
                for(Position result: resultPosition)
                    System.out.println(result.toString());
                break;
            case 3: //API
                //TO DO
                break;
            default: //File
                try {
                    writeFile(resultPosition);
                } catch(IOException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                }
                break;
        }
    }

    private void writeFile(List<Position> resultPosition) throws IOException {

        FileWriter fileWriter = new FileWriter(Constants.OUTPUT_FILE_PATHNAME);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for(Position result: resultPosition)
            printWriter.println(result.toString());

        printWriter.close();
        fileWriter.close();
    }

}
