import api.HttpOperations;
import api.MintConfiguration;
import api.astralObjects.astralProperties.Color;
import api.astralObjects.astralProperties.Direction;

import java.util.List;

public class Main {

    private HttpOperations httpOperations;

    public void setup() {
        httpOperations = new HttpOperations(
                MintConfiguration.getBaseUrl(),
                MintConfiguration.getPolyanets(),
                MintConfiguration.getSoloons(),
                MintConfiguration.getComeths()
        );
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setup();

        if (args[0].equals("clear")) {
            main.clearBoard();
        }
        if (args[0].equals("fill")) {
            main.fillWithGoalMap();
        }
    }

    public void fillWithGoalMap() {
        List<List<String>> goalList = httpOperations.getGoalMap();
        for (int row = 0; row < goalList.size(); row++) {
            for (int col = 0; col < goalList.get(0).size(); col++) {
                String node = goalList.get(row).get(col);
                String response = parseAndRunString(node, row, col);
                System.out.println("Node: " + node + " Response: " + response);
            }
        }
    }

    public String parseAndRunString(String cmd, int row, int col) {
        String result = null;
        if (cmd.equals("SPACE")) {
            result = httpOperations.deletePolyanets(row, col);
        } else if (cmd.equals("POLYANET")) {
            result = httpOperations.postPolyanets(row, col);
        } else {
            String[] cmdArray = cmd.split("_");
            if (cmdArray[1].equals("SOLOON")) {
                if (cmdArray[0].equals(Color.BLUE.toString())) {
                    result = httpOperations.postSoloons(row, col, Color.BLUE.toString().toLowerCase());
                }
                if (cmdArray[0].equals(Color.RED.toString())) {
                    result = httpOperations.postSoloons(row, col, Color.RED.toString().toLowerCase());
                }
                if (cmdArray[0].equals(Color.PURPLE.toString())) {
                    result = httpOperations.postSoloons(row, col, Color.PURPLE.toString().toLowerCase());
                }
                if (cmdArray[0].equals(Color.WHITE.toString())) {
                    result = httpOperations.postSoloons(row, col, Color.WHITE.toString().toLowerCase());
                }
            } else if (cmdArray[1].equals("COMETH")) {
                if (cmdArray[0].equals(Direction.UP.toString())) {
                    result = httpOperations.postComeths(row, col, Direction.UP.toString().toLowerCase());
                }
                if (cmdArray[0].equals(Direction.DOWN.toString())) {
                    result = httpOperations.postComeths(row, col, Direction.DOWN.toString().toLowerCase());
                }
                if (cmdArray[0].equals(Direction.LEFT.toString())) {
                    result = httpOperations.postComeths(row, col, Direction.LEFT.toString().toLowerCase());
                }
                if (cmdArray[0].equals(Direction.RIGHT.toString())) {
                    result = httpOperations.postComeths(row, col, Direction.RIGHT.toString().toLowerCase());
                }
            }
        }
        return result;
    }

    public void clearBoard() {
        List<List<String>> goalList = httpOperations.getGoalMap();
        for (int row = 0; row < goalList.size(); row++) {
            for (int col = 0; col < goalList.get(0).size(); col++) {
                String response = httpOperations.deletePolyanets(row, col);
                System.out.println("Clearing Board... Response: " + response);
            }
        }
    }

}