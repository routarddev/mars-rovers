package interaction;

import controller.RoversController;
import model.Position;
import model.Rover;
import utils.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by routarddev on 8/08/18.
 */
public class ProcessSteps {

    private InputProcessor inputProcessor;

    public ProcessSteps() {
        inputProcessor = new InputProcessor();
    }

    /**
     * Entry method to treat the input data depending on the mode,
     * execute the instructions and presenting the results.
     * @param args program execution arguments (input mode, filename)
     */
    public void run(String... args) {
        processInformation(args);
        List<Position> resultPositions = getFinalPositions();
        showResults(resultPositions, Integer.parseInt(args[0]));
    }

    /**
     * Treat the received information depending on the input mode.
     * By default, the example file in the resources folder is used.
     * @param args program execution arguments (input mode, filename)
     */
    private void processInformation(String[] args) {
        try {
            switch (args[0]) {
                case "2":
                    inputProcessor.processFromConsole();
                    break;
                default:
                    if (args.length > 1 && !args[1].isEmpty() && new File(args[1]).exists())
                        inputProcessor.processFromFile(args[1]);
                    else
                        inputProcessor.processFromFile(Constants.INPUT_FILE_PATHNAME);

                    break;
            }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * For each rover, execute the corresponding received instructions
     * and get the final position.
     * @return list of rover's new positions
     */
    private List<Position> getFinalPositions() {
        List<Position> resultPositions = new LinkedList<>();
        RoversController roversController;
        for(Map.Entry<Rover,String> entry : inputProcessor.getRovers().entrySet()) {
            Rover rover = entry.getKey();
            roversController = new RoversController(rover.getPosition(),
                                                    inputProcessor.getPlateau(),
                                                    entry.getValue());
            resultPositions.add(roversController.getRoverFinalPosition());
        }
        return resultPositions;
    }

    /**
     * Show resulting position depending on the data input mode
     * @param resultPosition list of rover's new positions
     * @param option data input mode (2: console, 1: file)
     */
    private void showResults(List<Position> resultPosition, int option) {
        switch(option) {
            case 2: //Console
                for(Position result: resultPosition)
                    System.out.println(result.toString());
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

    /**
     * Creates output file with final positions for each Rover
     * @param resultPosition list of rover's new positions
     * @throws IOException error while working with the file
     */
    private void writeFile(List<Position> resultPosition) throws IOException {

        FileWriter fileWriter = new FileWriter(Constants.OUTPUT_FILE_PATHNAME);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for(Position result: resultPosition)
            printWriter.println(result.toString());

        printWriter.close();
        fileWriter.close();
    }

}
